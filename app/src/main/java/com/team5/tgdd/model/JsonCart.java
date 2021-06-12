package com.team5.tgdd.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class JsonCart {
    @SerializedName("errorCode")
    private Integer ERROR_CODE;

    @SerializedName("errorMessage")
    private String ERROR_MASSAGE;

    @SerializedName("data")
    private ArrayList<SmartPhone> smartPhoneList;

    @Override
    public String toString() {
        return "JsonCart{" +
                "ERROR_CODE=" + ERROR_CODE +
                ", ERROR_MASSAGE='" + ERROR_MASSAGE + '\'' +
                ", smartPhoneList=" + smartPhoneList.toString() +
                '}';
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

    public ArrayList<SmartPhone> getSmartPhoneList() {
        return smartPhoneList;
    }

    public void setSmartPhoneList(ArrayList<SmartPhone> smartPhoneList) {
        this.smartPhoneList = smartPhoneList;
    }

    public JsonCart() {
    }

    public JsonCart(Integer ERROR_CODE, String ERROR_MASSAGE, ArrayList<SmartPhone> smartPhoneList) {
        this.ERROR_CODE = ERROR_CODE;
        this.ERROR_MASSAGE = ERROR_MASSAGE;
        this.smartPhoneList = smartPhoneList;
    }
}
