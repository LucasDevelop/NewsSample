package com.lucas.newssample.utils;

/**
 * 作者：lucas on 2016/6/23 16:52
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public interface Constant {
    //连接超时时间
    int CONN_TIME_OUT = 5 * 1000;
    //数据读取超时时间
    int READ_TIME_OUT = 5 * 1000;

    //http://c.m.163.com/nc/article/headline/T1348647909107/0-5.html  头条

    int PAGE_SIZE = 20;

    String HOST = "http://c.m.163.com";
    String END_URL = "-" + PAGE_SIZE + ".html";
    String END_DETAIL_URL = "/full.html";
    // 头条
    String TOP_URL = "nc/article/headline/";
    String TOP_ID = "T1348647909107";
    // 新闻详情
    String NEW_DETAIL =  "nc/article/";
    String COMMON_URL =  "nc/article/list/";
    // 汽车
    String CAR_ID = "T1348654060988";
    // 笑话
    String JOKE_ID = "T1350383429665";
    // nba
    String NBA_ID = "T1348649145984";
    // 图片
    String IMAGES_URL = "http://api.laifudao.com/open/tupian.json";
    // 天气预报url
    String WEATHER = "http://wthrcdn.etouch.cn/weather_mini?city=";
    //百度定位
    String INTERFACE_LOCATION = "http://api.map.baidu.com/geocoder?output=json&referer=32D45CBEEC107315C553AD1131915D366EEF79B4&location=";

}
