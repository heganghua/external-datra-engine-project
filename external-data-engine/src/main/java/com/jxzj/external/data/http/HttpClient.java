package com.jxzj.external.data.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

    public static String doGet(String httpUrl) {

        HttpURLConnection conn = null;
        InputStream is = null;
        BufferedReader br = null;
        String result = null;

        try {
            URL url = new URL(httpUrl);
            // 通过远程url连接对象打开一个连接，强制转换成HTTPURLConnection对象
            conn = (HttpURLConnection)url.openConnection();
            // 设置连接方式：get
            conn.setRequestMethod("GET");
            // 设置连接主机服务器的超时时间：15秒
            conn.setConnectTimeout(15 * 1000);
            // 设置读取远程返回的数据时间
            conn.setReadTimeout(6 * 1000);
            // 发送请求下·
            conn.connect();

            System.out.println("==========================");
            System.out.println(HttpURLConnection.HTTP_OK);
            System.out.println(conn.getResponseCode());
            System.out.println("==========================");

            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                is = conn.getInputStream();
                // 封装输入流，并指定字符集
                br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String temp = null;
                while ((temp = br.readLine()) != null) {
                    sbf.append(temp).append("\r\n");
                }
                result = sbf.toString();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            conn.disconnect();
        }
        return result;
    }

    public static void main(String[] args) {
        String res = HttpClient.doGet("https://www.baidu.com");
        System.out.println(res);
    }

}
