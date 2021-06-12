package com.team5.tgdd.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

public class Bill implements Serializable {
    @SerializedName("id_bill")
    private String id_bill;
    @SerializedName("phone_number")
    private String phone_number;
    @SerializedName("item_list")
    @Expose
    private ArrayList<SmartPhone> item_list;
    @SerializedName("total_value")
    private String total_value;
    @SerializedName("status")
    private String status;

    public Bill(String id_bill, String phone_number, ArrayList<SmartPhone> item_list, String total_value, String status) {
        this.id_bill = id_bill;
        this.phone_number = phone_number;
        this.item_list = item_list;
        this.total_value = total_value;
        this.status = status;
    }

    public String getId_bill() {
        return id_bill;
    }

    public void setId_bill(String id_bill) {
        this.id_bill = id_bill;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public ArrayList<SmartPhone> getItem_list() {
        return item_list;
    }

    public void setItem_list(ArrayList<SmartPhone> item_list) {
        this.item_list = item_list;
    }

    public String getTotal_value() {
        return total_value;
    }

    public void setTotal_value(String total_value) {
        this.total_value = total_value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
