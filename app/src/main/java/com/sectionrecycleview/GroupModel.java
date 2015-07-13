package com.sectionrecycleview;

import java.util.List;

public class GroupModel {

    private String startDate;
    private List<ChildModel> workshops;

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public List<ChildModel> getWorkshops() {
        return workshops;
    }

    public void setWorkshops(List<ChildModel> workshops) {
        this.workshops = workshops;
    }
}
