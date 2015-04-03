package com.sds.mini.platform.minion.service;

import com.sds.mini.platform.minion.domain.MinionInfo;
import org.junit.Test;

import java.net.InetAddress;

public class AgentServiceTest {
    AgentService agentService = new AgentService();

    @Test
    public void testAddMinion() throws Exception {
        final MinionInfo info = new MinionInfo();
        info.setName("agent1");
        info.setUrl("http://" + InetAddress.getLocalHost().getHostAddress() + ":20308");
        agentService.addMinion(info);

        Thread.sleep(10000);
    }

    @Test
    public void testUpdateMinion() throws Exception {
        final MinionInfo info = new MinionInfo();
        info.setName("agent1");
        info.setUrl("http://" + InetAddress.getLocalHost().getHostAddress() + ":20308");
        agentService.updateMinionStatus(info);

        Thread.sleep(10000);
    }

    @Test
    public void testRemoveMinion() {

    }
}
