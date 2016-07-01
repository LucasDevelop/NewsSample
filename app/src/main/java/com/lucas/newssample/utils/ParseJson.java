package com.lucas.newssample.utils;

import android.graphics.Bitmap;
import android.text.TextUtils;

import com.lucas.newssample.beans.News;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;
import java.util.List;

import retrofit.client.Response;
import retrofit.mime.TypedByteArray;

/**
 * 作者：lucas on 2016/6/29 11:28
 * 邮箱：lucas_developer@163.com
 * 说明：json 解析
 */
public abstract class ParseJson {
    public static List<News> parseNews(Response response, String id) {
        ArrayList<News> list = new ArrayList<>();
        TypedByteArray body = (TypedByteArray) response.getBody();
        String json = new String(body.getBytes());
        JSONTokener jsonTokener = new JSONTokener(json);
        try {
            JSONObject value = (JSONObject) jsonTokener.nextValue();
            JSONArray array = value.getJSONArray(id);
            if (array == null) {
                throw new JSONException("数据为空！");
            }
            for (int i = 0; i < array.length(); i++) {
                JSONObject item = (JSONObject) array.get(i);
                if (item == null) continue;
                if (item.has("skipType") && "special".equals(item.getString("skipType"))) {
                    continue;
                }
                if (item.has("TAGS") && !item.has("TAG")) {
                    continue;
                }
                if (item.has("imgextra")) continue;
                String title = item.getString("title");
                String digest = item.getString("digest");
                String imgsrc = item.getString("imgsrc");
                String docid = item.getString("docid");
                list.add(new News(digest, imgsrc, title, docid));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }
}
