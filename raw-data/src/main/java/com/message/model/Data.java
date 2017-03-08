package com.message.model;

/**
 * Created by ME on 3/8/2017.
 */
public class Data {

    private String dataID;

    private String dataType;

    public Data() {
    }

    public Data(String dataID, String dataType) {
        this.dataID = dataID;
        this.dataType = dataType;
    }

    public String getDataID() {
        return dataID;
    }

    public void setDataID(String dataID) {
        this.dataID = dataID;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}
