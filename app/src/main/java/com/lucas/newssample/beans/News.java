package com.lucas.newssample.beans;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：lucas on 2016/6/24 17:55
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
public class News implements Serializable{
    public String title;
    public String digest;
    public String imgsrc;
    public String docid;

    public News(String digest, String imgsrc, String title,String docid) {
        this.digest = digest;
        this.imgsrc = imgsrc;
        this.title = title;
        this.docid = docid;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("com.lucas.newssample.beans.News{");
        sb.append("digest='").append(digest).append('\'');
        sb.append(", imgsrc='").append(imgsrc).append('\'');
        sb.append(", title='").append(title).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
