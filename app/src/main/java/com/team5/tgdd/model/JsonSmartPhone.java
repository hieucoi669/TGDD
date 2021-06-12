package com.team5.tgdd.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonSmartPhone {
    @SerializedName("errorCode")
    private Integer ERROR_CODE;

    @SerializedName("errorMessage")
    private String ERROR_MASSAGE;

    @SerializedName("data")
    private SmartPhone smartPhone;

    public JsonSmartPhone() {
    }

    public JsonSmartPhone(Integer ERROR_CODE, String ERROR_MASSAGE, SmartPhone smartPhone) {
        this.ERROR_CODE = ERROR_CODE;
        this.ERROR_MASSAGE = ERROR_MASSAGE;
        this.smartPhone = smartPhone;
    }

    public Integer getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(Integer ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public String getERROR_MASSAGE() {
        return ERROR_MASSAGE;
    }

    public void setERROR_MASSAGE(String ERROR_MASSAGE) {
        this.ERROR_MASSAGE = ERROR_MASSAGE;
    }

    public SmartPhone getSmartPhone() {
        return smartPhone;
    }

    public void setSmartPhone(SmartPhone smartPhone) {
        this.smartPhone = smartPhone;
    }

    @Override
    public String toString() {
        return "JsonSmartPhone{" +
                "ERROR_CODE=" + ERROR_CODE +
                ", ERROR_MASSAGE='" + ERROR_MASSAGE + '\'' +
                ", smartPhone=" + smartPhone.toString() +
                '}';
    }
}
