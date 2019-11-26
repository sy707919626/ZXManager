package com.bfby.zxjl.Bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/7/27.
 */

public class BaseBean<T> implements Serializable {
    /**
     * status : 1
     * data : {"UserName":"廖志华","RoleID":"00000000-0000-0000-0000-000000000000","UserID":"005f052f-7020-4d48-9652-6975dd2de3fe","IsSuperManage":false,"CompanyID":"7e0dc412-7d7b-43f0-8e89-6b6941db1f8f"}
     */

    private int status;
    private T data;
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
