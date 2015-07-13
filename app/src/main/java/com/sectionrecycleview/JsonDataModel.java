package com.sectionrecycleview;

import java.util.List;

public class JsonDataModel {
    private String status;
    private String message;
    private List<GroupModel> data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GroupModel> getData() {
        return data;
    }

    public void setData(List<GroupModel> data) {
        this.data = data;
    }
}
