package com.team5.tgdd.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class User {
    @SerializedName("phone_number")
    private String phone_number;

    @SerializedName("full_name")
    private String full_name;

    @SerializedName("address")
    private String address;

    @SerializedName("password")
    private String password;

    @SerializedName("cart")
    @Expose
    private ArrayList<String> idProduct;

    public User() {
    }

    public ArrayList<String> getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(ArrayList<String> idProduct) {
        this.idProduct = idProduct;
    }

    public User(String phone_number, String full_name, String address, String password, ArrayList<String> idProduct) {
        this.phone_number = phone_number;
        this.full_name = full_name;
        this.address = address;
        this.password = password;
        this.idProduct = idProduct;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "phone_number='" + phone_number + '\'' +
                ", full_name='" + full_name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                ", idProduct=" + idProduct.toString() +
                '}';
    }
    public String toStringUser() {
        return "User{" +
                "phone_number='" + phone_number + '\'' +
                ", full_name='" + full_name + '\'' +
                ", address='" + address + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
