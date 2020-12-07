package com.broadvideo.smartlayout.data.bundle;

/**
 * Created by vinda on 2018/7/5.
 * Describe:
 * qq:1304314404
 */

public class VideosResponse {
    //"id": "(int)视频id",
// "name": "视频名称",
// "url": "视频下载地址",
// "path": "视频下载路径",
// "file": "文件名",
// "checksum": "视频checksum",
// "size": "(int)视频大小",
// "thumbnail": "缩略图",
    private int id;
    private String name;
    private String url;
    private String path;
    private String file;
    private String checksum;
    private int size;
    private String thumbnail;
    private int downLoadID;//用来校验下载的id
    private String relate_type;//关联类型
    private int relate_id;//关联的ID
    private String relate_url;//关联的网页url

    public int getDownLoadID() {
        return downLoadID;
    }

    public void setDownLoadID(int downLoadID) {
        this.downLoadID = downLoadID;
    }

    public String getRelate_type() {
        return relate_type;
    }

    public void setRelate_type(String relate_type) {
        this.relate_type = relate_type;
    }

    public int getRelate_id() {
        return relate_id;
    }

    public void setRelate_id(int relate_id) {
        this.relate_id = relate_id;
    }

    public String getRelate_url() {
        return relate_url;
    }

    public void setRelate_url(String relate_url) {
        this.relate_url = relate_url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
