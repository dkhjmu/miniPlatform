package com.sds.mini.platform.minion.service;

import java.util.HashMap;

import com.sds.mini.platform.minion.domain.MinionInfo;
import com.sds.mini.platform.minion.domain.MinionStatus;

public class CheckService {
	
	public static HashMap<String, MinionInfo> map;
	static{
		MinionInfo dead = new MinionInfo();
		dead.setName("Tibero");
		dead.setStatus(MinionStatus.DEAD);
		map.put(dead.getName(), dead);
		MinionInfo lived = new MinionInfo();
		lived.setName("Scout");
		lived.setStatus(MinionStatus.LIVED);
		map.put(lived.getName(), lived);
	}
	
	public MinionInfo checkMinion(String key){
		return map.get(key);
	}
}
