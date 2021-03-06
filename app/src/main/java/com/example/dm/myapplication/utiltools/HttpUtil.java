package com.example.dm.myapplication.utiltools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by dm on 16-4-22.
 * http工具类
 */
public class HttpUtil {
    public static String NEWSLIST_LATEST = "http://news-at.zhihu.com/api/4/news/latest";
    public static String STORY_VIEW = "http://daily.zhihu.com/story/";
    public static String NEWSDETAIL = "http://news-at.zhihu.com/api/4/news/";

    public static String get(String urlAddr) throws IOException {
        HttpURLConnection con = null;
        try {
            URL url = new URL(urlAddr);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                return response.toString();
            } else {
                throw new IOException("Network Error - response code: " + con.getResponseCode());
            }
        } finally {
            if (con != null) {
                con.disconnect();
            }
        }
    }

    public static String getLastNewsList() throws IOException {
        return get(NEWSLIST_LATEST);
    }

    public static String getNewsDetail(int id) throws IOException {
        return get(NEWSDETAIL + id);
    }

    public static String getWeatherJson(String city) throws UnsupportedEncodingException {
        String cityName = URLEncoder.encode(city, "utf-8");
        String requestUrl = "http://api.map.baidu.com/telematics/v3/weather?location=" + cityName + "&output=json&ak=8a435fdb57f244acc087a50656965562";
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回获取的json字符串
        if (buffer != null) {
            return buffer.toString();  //返回获取的json字符串
        } else {
            return "";
        }
    }

    public static String getVideoJsonStr() throws UnsupportedEncodingException {
        String requestUrl = "http://gank.io/api/data/%E4%BC%91%E6%81%AF%E8%A7%86%E9%A2%91/10/1";
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //返回获取的json字符串
        if (buffer != null) {
            return buffer.toString();  //返回获取的json字符串
        } else {
            return "";
        }
    }

    public static String getGankJsonStr(String gankClassStr) throws UnsupportedEncodingException {
        String requestUrl = "http://gank.io/api/search/query/listview/category/"
                + URLEncoder.encode(gankClassStr, "utf-8") + "/count/30/page/1 ";
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (buffer != null) {
            return buffer.toString();  //返回获取的json字符串
        } else {
            return "";
        }
    }

    public static String getSearchJsonStr(String keywordStr) throws UnsupportedEncodingException {
//        String requestUrl = "http://gank.io/api/search/query/listview/category/"
//                + URLEncoder.encode(gankClassStr, "utf-8") + "/count/30/page/1 ";
        String requestUrl = "http://gank.io/api/search/query/"
                + URLEncoder.encode(keywordStr, "utf-8") + "/category/all/count/50/page/1";
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }

            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (buffer != null) {
            return buffer.toString();  //返回获取的json字符串
        } else {
            return "";
        }
    }
}
