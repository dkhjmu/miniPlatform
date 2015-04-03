package com.sds.mini.platform.minion.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sds.mini.platform.avalon.domain.Result;
import com.sds.mini.platform.minion.domain.MinionInfo;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Component
public class AgentService {

    private Map<String, MinionInfo> minions = new HashMap<>();

    private Map<String, ScheduledExecutorService> schedulers = new HashMap<>();

    private ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, MinionInfo> getMinions() {
        return minions;
    }

    public MinionInfo getMinion(String key) {
        return minions.get(key);
    }

    /**
     * Minion을 추가하고, Minion 정보확인용 스케쥴러를 시작한다.
     * @param minionInfo
     * @return
     */
    public boolean addMinion(final MinionInfo minionInfo){
        minions.put(minionInfo.getName(), minionInfo);
        // trigger a timer to check minion's info
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(10);
        scheduler.scheduleAtFixedRate(new Runnable(){
            public void run() {
                updateMinionStatus(minionInfo);
                System.out.println("Update minion info : " + getMinion(minionInfo.getName()));
            }
        }, 0, 3, TimeUnit.SECONDS);
        schedulers.put(minionInfo.getName(), scheduler);
        return true;
    }

    public void updateMinionStatus(MinionInfo minionInfo) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(new HttpGet(minionInfo.getUrl() + "/status"));
            InputStream is = response.getEntity().getContent();
            String json = IOUtils.toString(is);
            MinionInfo newMinionInfo = objectMapper.readValue(json, MinionInfo.class);
            minions.put(minionInfo.getName(), newMinionInfo);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Minion 을 관리 목록에서 제거하고 타이머를 멈춘다.
     * @param minionInfo
     * @return
     */
    public boolean removeMinion(MinionInfo minionInfo){
        minions.remove(minionInfo.getName());
        // stop to check a minion's info
        ScheduledExecutorService scheduler = schedulers.get(minionInfo.getName());
        scheduler.shutdownNow();
        schedulers.remove(minionInfo.getName());
        return true;
    }

    /**
     * Agent 가 내려갔는지 체크
     *
     * @param minionInfo
     * @return
     */
    public boolean isAlive(MinionInfo minionInfo) {
        String json = executeUrl(minionInfo.getUrl() + "/healthCheck");
        if(json != null) {
            return true;
        }
        return false;
    }

    public String executeUrl(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpResponse response = httpClient.execute(new HttpGet(url));
            InputStream is = response.getEntity().getContent();
            String json = IOUtils.toString(is);
            return json;
        } catch (ClientProtocolException e) {
        } catch (IOException e) {
        }
        return null;
    }

    public String controlAgent(String app, String run) {
        MinionInfo minionInfo = minions.get(app);
        if("start".equalsIgnoreCase(run) || "stop".equalsIgnoreCase(run)) {
            String result = executeUrl(minionInfo.getUrl() + "/run/" + app + "/" + run);
            System.out.printf("Complete - ", app, run + " : Result - " + result);
            return result;
        } else {
            throw new IllegalArgumentException("app : " + app + ", run : " + run);
        }
    }
}
