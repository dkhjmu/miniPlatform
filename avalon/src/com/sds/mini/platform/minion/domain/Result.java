package com.sds.mini.platform.minion.domain;

import java.io.Serializable;

public class Result implements Serializable{
	private static final long serialVersionUID = 1L;
	String result;

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
