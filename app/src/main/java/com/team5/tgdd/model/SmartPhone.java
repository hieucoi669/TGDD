package com.team5.tgdd.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class SmartPhone implements Serializable {
    @SerializedName("_id")
    private String _id;

    @SerializedName("id_product")
    private String id_product;

    @SerializedName("name_product")
    private String name_product;

    @SerializedName("price_product")
    private String price_product;

    @SerializedName("brand_product")
    private String brand_product;

    @SerializedName("display")
    private String display;

    @SerializedName("os")
    private String os;

    @SerializedName("front_camera")
    private String front_camera;

    @SerializedName("behind_camera")
    private String behind_camera;

    @SerializedName("cpu")
    private String cpu;

    @SerializedName("ram")
    private String ram;

    @SerializedName("rom")
    private String rom;

    @SerializedName("sim")
    private String sim;

    @SerializedName("pin")
    private String pin;

    @SerializedName("image1")
    private String image1;

    @SerializedName("image2")
    private String image2;

    @SerializedName("image3")
    private String image3;




    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "SmartPhone{" +
                "_id='" + _id + '\'' +
                ", id_product='" + id_product + '\'' +
                ", name_product='" + name_product + '\'' +
                ", price_product='" + price_product + '\'' +
                ", brand_product='" + brand_product + '\'' +
                ", display='" + display + '\'' +
                ", os='" + os + '\'' +
                ", front_camera='" + front_camera + '\'' +
                ", behind_camera='" + behind_camera + '\'' +
                ", cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", rom='" + rom + '\'' +
                ", sim='" + sim + '\'' +
                ", pin='" + pin + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                '}';
    }

    public String getId_product() {
        return id_product;
    }

    public void setId_product(String id_product) {
        this.id_product = id_product;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getPrice_product() {
        return price_product;
    }

    public void setPrice_product(String price_product) {
        this.price_product = price_product;
    }

    public String getBrand_product() {
        return brand_product;
    }

    public void setBrand_product(String brand_product) {
        this.brand_product = brand_product;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getFront_camera() {
        return front_camera;
    }

    public void setFront_camera(String front_camera) {
        this.front_camera = front_camera;
    }

    public String getBehind_camera() {
        return behind_camera;
    }

    public void setBehind_camera(String behind_camera) {
        this.behind_camera = behind_camera;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getRom() {
        return rom;
    }

    public void setRom(String rom) {
        this.rom = rom;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public SmartPhone(String _id, String id_product, String name_product, String price_product, String brand_product, String display, String os, String front_camera, String behind_camera, String cpu, String ram, String rom, String sim, String pin, String image1, String image2, String image3) {
        this._id = _id;
        this.id_product = id_product;
        this.name_product = name_product;
        this.price_product = price_product;
        this.brand_product = brand_product;
        this.display = display;
        this.os = os;
        this.front_camera = front_camera;
        this.behind_camera = behind_camera;
        this.cpu = cpu;
        this.ram = ram;
        this.rom = rom;
        this.sim = sim;
        this.pin = pin;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
    }
}
