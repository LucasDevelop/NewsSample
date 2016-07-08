package com.lucas.newssample.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lucas.newssample.App;
import com.lucas.newssample.beans.Images;
import com.lucas.newssample.beans.News;
import com.lucas.newssample.beans.NewsDetail;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Response;

/**
 * 作者：lucas on 2016/6/29 11:28
 * 邮箱：lucas_developer@163.com
 * 说明：json 解析
 */
public abstract class ParseJson {
    public static List<News> parseNews(Response response, String id) {
        ArrayList<News> list = new ArrayList<>();
        String json = response.body().toString();
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

    public static NewsDetail parseNewsDetail(Response response, String id) {
        String s =  response.body().toString();
        JsonParser parser = new JsonParser();
        JsonObject jsonObject = parser.parse(s).getAsJsonObject();
        JsonElement element = jsonObject.get(id);
        return App.getAppComponent().getGson().fromJson(element, NewsDetail.class);
    }

    public static List<Images> parseImages(Response response) throws IOException {
        String string = response.body().toString();
        JsonParser parser = new JsonParser();
        JsonArray object = parser.parse(string).getAsJsonArray();
        List<Images> images = new ArrayList<>();
        for (int i = 0; i < object.size(); i++) {
            JsonObject jsonObject = object.get(i).getAsJsonObject();
            images.add(App.getAppComponent().getGson().fromJson(jsonObject,Images.class));
        }
        return images;
    }
}
