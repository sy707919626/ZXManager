package com.bfby.zxjl.Bean;

import java.io.Serializable;

public class CarOrderFeeBean implements Serializable {

    /**
     * status : 1
     * ID : 00000000-0000-0000-0000-000000000000
     * fee : 0
     * TotalFee : 0
     * taxFee : 0
     */
    private int status;
    private String ID;
    private float fee;
    private float TotalFee;
    private float taxFee;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public float getFee() {
        return fee;
    }

    public void setFee(float fee) {
        this.fee = fee;
    }

    public float getTotalFee() {
        return TotalFee;
    }

    public void setTotalFee(float totalFee) {
        TotalFee = totalFee;
    }

    public float getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(float taxFee) {
        this.taxFee = taxFee;
    }
}
