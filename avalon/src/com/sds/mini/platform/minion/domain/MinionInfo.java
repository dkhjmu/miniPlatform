package com.sds.mini.platform.minion.domain;

import com.sds.mini.platform.avalon.domain.AppInfo;
import com.sds.mini.platform.avalon.domain.Info;

public class MinionInfo extends Info{
	String status;
	AppInfo info;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AppInfo getInfo() {
		return info;
	}
	public void setInfo(AppInfo info) {
		this.info = info;
	}
	
}
