package com.spring.toyproject_backend.v2.value;

import java.io.Serializable;

public class Result implements Serializable {

    private static final long serialVersionUID = 1L;

    // success, fail, error, ...
    protected String code;

    // result description message
    protected String message;

    // body
    protected Object data;

    // getters, setters
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
