package com.valueup.veryveryhot.FCM;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AndroidPushNotifications {

    public static String NewCommentNotificationJson(List<String> tokens, String qnatitle) throws JSONException {

        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for(int i=0; i<tokens.size(); i++){
            tokenlist.add(tokens.get(i));
        }

        JSONArray array = new JSONArray();

        for(int i=0; i<tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();
        String title = "새로운 댓글이 달렸습니다.";
        try{
            title = URLEncoder.encode(title, "UTF-8");
            qnatitle = URLEncoder.encode("글 제목:" + qnatitle, "UTF-8");
            notification.put("title", title);
            notification.put("body", qnatitle);

        } catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }

    public static String DailyNotificationJson(List<String> tokens, String newstitle) throws JSONException {
        JSONObject body = new JSONObject();

        List<String> tokenlist = new ArrayList<String>();

        for (int i = 0; i < tokens.size(); i++) {
            tokenlist.add(tokens.get(i));
        }

        JSONArray array = new JSONArray();

        for (int i = 0; i < tokenlist.size(); i++) {
            array.put(tokenlist.get(i));
        }

        body.put("registration_ids", array);

        JSONObject notification = new JSONObject();

        String title = "오늘의 금융 상식";
        try {
            title = URLEncoder.encode(title, "UTF-8");
            newstitle = URLEncoder.encode(newstitle, "UTF-8");
            notification.put("title", title);
            notification.put("body", newstitle);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }

    public static String BalanceNotificationJson(String token, String message) throws JSONException {
        JSONObject body = new JSONObject();

        body.put("to", token);

        JSONObject notification = new JSONObject();

        String title = "잔고를 확인하세요!";
        try {
            title = URLEncoder.encode(title, "UTF-8");
            message = URLEncoder.encode(message, "UTF-8");
            notification.put("title", title);
            notification.put("body", message);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        body.put("notification", notification);

        System.out.println(body.toString());

        return body.toString();
    }


}