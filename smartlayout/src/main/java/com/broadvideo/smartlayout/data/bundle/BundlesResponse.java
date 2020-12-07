package com.broadvideo.smartlayout.data.bundle;

/**
 * Created by vinda on 2018/7/5.
 * Describe:
 * qq:1304314404
 */

public class BundlesResponse {
//  "bundle_id": "(int)节目id",
//  "url": "json文件下载地址",
//  "path": ""json文件下载路径",
// "file": "json文件名",
// "checksum": "json文件checksum",
// "size": "(int)json文件大小",
// "thumbnail": "节目缩略图",
    private int bundle_id;
    private String url;
    private String path;
    private String file;

    public int getBundle_id() {
        return bundle_id;
    }

    public void setBundle_id(int bundle_id) {
        this.bundle_id = bundle_id;
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

    private String checksum;
    private int size;
    private String thumbnail;
}
