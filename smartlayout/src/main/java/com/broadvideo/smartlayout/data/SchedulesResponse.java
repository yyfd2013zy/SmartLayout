package com.broadvideo.smartlayout.data;

import java.util.ArrayList;

public class SchedulesResponse {
    private String start_time;//开始时间
    private String ent_time = "";//结束时间


    private ArrayList<Integer> bundle_ids;//在这个开始时间后，播放的bundle
    private long startTime;
    private long endTime;

    public long getStartTimeLong() {
        return startTime;
    }

    public void setStartTimeLong(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTimeLong() {
        return endTime;
    }

    public void setEndTimeLong(long endTime) {
        this.endTime = endTime;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public ArrayList<Integer> getBundle_ids() {
        return bundle_ids;
    }

    public void setBundle_ids(ArrayList<Integer> bundle_ids) {
        this.bundle_ids = bundle_ids;
    }


    public String getEnt_time() {
        return ent_time;
    }

    public void setEnt_time(String ent_time) {
        this.ent_time = ent_time;
    }
}
