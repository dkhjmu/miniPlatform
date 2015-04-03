package com.sds.mini.platform.avalon.domain;

import java.io.Serializable;

public class Result implements Serializable{
    String result;

    public Result(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
