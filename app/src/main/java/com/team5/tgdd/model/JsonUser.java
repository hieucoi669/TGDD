package com.team5.tgdd.model;

import com.google.gson.annotations.SerializedName;

public class JsonUser {
    @SerializedName("errorCode")
    private String ERROR_CODE;

    @SerializedName("errorMessage")
    private String ERROR_MASSAGE;

    @SerializedName("data")
    private User user;

    public JsonUser() {
    }

    public JsonUser(String ERROR_CODE, String ERROR_MASSAGE, User user) {
        this.ERROR_CODE = ERROR_CODE;
        this.ERROR_MASSAGE = ERROR_MASSAGE;
        this.user = user;
    }

    public String getERROR_CODE() {
        return ERROR_CODE;
    }

    public void setERROR_CODE(String ERROR_CODE) {
        this.ERROR_CODE = ERROR_CODE;
    }

    public String getERROR_MASSAGE() {
        return ERROR_MASSAGE;
    }

    public void setERROR_MASSAGE(String ERROR_MASSAGE) {
        this.ERROR_MASSAGE = ERROR_MASSAGE;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toStringUser() {
        return "JSON{" +
                "ERROR_CODE='" + ERROR_CODE + '\'' +
                ", ERROR_MASSAGE='" + ERROR_MASSAGE + '\'' +
                ", user=" + user.toString() +
                '}';
    }
}
