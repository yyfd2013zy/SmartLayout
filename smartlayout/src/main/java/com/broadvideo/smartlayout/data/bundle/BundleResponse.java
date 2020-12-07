package com.broadvideo.smartlayout.data.bundle;

import com.broadvideo.smartlayout.data.SchedulesResponse;

import java.util.ArrayList;

/**
 * Created by vinda on 2018/7/5.
 * Describe:
 * qq:1304314404
 */

public class BundleResponse {
    private int code = -1;
    private String message;

    private int play_type;//1-固定播放 2-按时间段播放"

    private ArrayList<SchedulesResponse> schedules;//按时间段播放
    private ArrayList<SchedulesResponse> attachschedules;

    private ArrayList<BundlesResponse> bundles;//节目列表
    private ArrayList<VideosResponse> videos;
    private ArrayList<ImagessResponse> images;
    private ArrayList<AudiosResponse> audios;//音频文件
    private ArrayList<StreamResponse> streams;
    private BackupMediaResponse backupMediaResponse;//垫片文件

    public BackupMediaResponse getBackupMediaResponse() {
        return backupMediaResponse;
    }

    public void setBackupMediaResponse(BackupMediaResponse backupMediaResponse) {
        this.backupMediaResponse = backupMediaResponse;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getPlay_type() {
        return play_type;
    }

    public void setPlay_type(int play_type) {
        this.play_type = play_type;
    }

    public ArrayList<SchedulesResponse> getSchedules() {
        return schedules;
    }

    public void setSchedules(ArrayList<SchedulesResponse> schedules) {
        this.schedules = schedules;
    }


    public ArrayList<BundlesResponse> getBundles() {
        return bundles;
    }

    public void setBundles(ArrayList<BundlesResponse> bundles) {
        this.bundles = bundles;
    }

    public ArrayList<VideosResponse> getVideos() {
        return videos;
    }

    public void setVideos(ArrayList<VideosResponse> videos) {
        this.videos = videos;
    }

    public ArrayList<ImagessResponse> getImages() {
        return images;
    }

    public void setImages(ArrayList<ImagessResponse> images) {
        this.images = images;
    }

    public ArrayList<AudiosResponse> getAudios() {
        return audios;
    }

    public void setAudios(ArrayList<AudiosResponse> audios) {
        this.audios = audios;
    }

    public ArrayList<SchedulesResponse> getAttachschedules() {
        return attachschedules;
    }

    public void setAttachschedules(ArrayList<SchedulesResponse> attachschedules) {
        this.attachschedules = attachschedules;
    }

    public ArrayList<StreamResponse> getStreams() {
        return streams;
    }

    public void setStreams(ArrayList<StreamResponse> streams) {
        this.streams = streams;
    }
}
