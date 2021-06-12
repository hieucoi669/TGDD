package com.team5.tgdd.model;

import com.google.gson.annotations.SerializedName;

public class Json {
    @SerializedName("errorCode")
    private Integer ERROR_CODE;

    @SerializedName("errorMessage")
    private String ERROR_MASSAGE;

    @Override
    public String toString() {
        return "Json{" +
                "ERROR_CODE=" + ERROR_CODE +
                ", ERROR_MASSAGE='" + ERROR_MASSAGE + '\'' +
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

    public Json() {
    }

    public Json(Integer ERROR_CODE, String ERROR_MASSAGE) {
        this.ERROR_CODE = ERROR_CODE;
        this.ERROR_MASSAGE = ERROR_MASSAGE;
    }
}
