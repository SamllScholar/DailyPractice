package com;
/**
 * 获取网页源码
 * yongxinYang   2019-11-21  20：00
 */

import java.io.*;
import java.net.*;

public class ExcepTest {

    public static String getHtmlContent(URL url, String encode) {
        StringBuffer contentBuffer = new StringBuffer();

        int responseCode = -1;
        HttpURLConnection con = null;
        try {
            con = (HttpURLConnection) url.openConnection();
            /*
             * 此处的urlConnection对象实际上是根据URL的
             *  请求协议(此处是http)生成的URLConnection类
             *  的子类HttpURLConnection,故此处最好将其转化
             * 为HttpURLConnection类型的对象,以便用到
             *  HttpURLConnection更多的API
             * */
            con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");// IE代理进行下载
            con.setConnectTimeout(60000);
            con.setReadTimeout(60000);
            // 获得网页返回信息码
            responseCode = con.getResponseCode();
            if (responseCode == -1) {
                System.out.println(url.toString() + " : connection is failure...");
                con.disconnect();
                return null;
            }
            if (responseCode >= 400) // 请求失败
            {
                System.out.println("请求失败:get response code: " + responseCode);
                con.disconnect();
                return null;
            }

            InputStream inStr = con.getInputStream();
            InputStreamReader istreamReader = new InputStreamReader(inStr, encode);
            BufferedReader buffStr = new BufferedReader(istreamReader);

            String str = null;
            while ((str = buffStr.readLine()) != null) {
                contentBuffer.append(str).append(System.lineSeparator());
            }
            inStr.close();
        } catch (IOException e) {
            e.printStackTrace();
            contentBuffer = null;
            System.out.println("error: " + url.toString());
        } finally {
            con.disconnect();
        }
        assert contentBuffer != null;
        String cb = contentBuffer.toString();
        return contentBuffer.toString();
    }

    public static String getHtmlContent(String url, String encode) {

        try {
            URL rUrl = new URL(url);
            return getHtmlContent(rUrl, encode);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String argsp[]) {
        //程序入口，传入网页链接，和网页编码
        System.out.println(getHtmlContent("", "utf-8"));
    }

}