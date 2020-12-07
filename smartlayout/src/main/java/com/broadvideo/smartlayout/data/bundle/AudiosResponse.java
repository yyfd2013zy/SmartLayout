package com.broadvideo.smartlayout.data.bundle;

/**
 * Created by vinda on 2018/7/5.
 * Describe: 音频文件实体类
 * qq:1304314404
 */

public class AudiosResponse {
//  "id": "(int)图片id",
//  "name": "图片名称",
//  "url": "图片下载地址",
//  "path": "图片下载路径",
//  "file": "文件名",
//  "checksum": "图片checksum",
//  "size": "(int)图片大小",
//  "thumbnail": "缩略图",
//  "relate_type": "image",
//  "relate_id": "关联id",
//  "relate_url": "关联url",


    private int id;
    private String name;
    private String url;
    private String path;
    private String file;
    private String checksum;
    private int size;

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
}
