package com.broadvideo.smartlayout.data.zone;

/**
 * Created by vinda on 2018/7/10.
 * Describe:
 * qq:1304314404
 */

public class ZoneViewModule {
    public int zonge_id;//所属的zone区域id,不唯一
    public long viewID;//moduleid，唯一
    public Object o;//View实体
    public int zIndex;//z轴顺序
    public int viewType;//view类别
    public int interval;//图片的切换间隔时间(当前View显示每个资源ID分配的时间),s
    public int w;
    public int h;
    public int top;
    public int left;
}
