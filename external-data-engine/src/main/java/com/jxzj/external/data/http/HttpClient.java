package com.jxzj.external.data.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

    public static String doPost(String HttpUrl, String param) {
        HttpURLConnection conn = null;
        InputStream in = null;
        OutputStream os = null;
        BufferedReader br = null;
        String result = null;

        try {
            URL url = new URL(HttpUrl);
            conn = (HttpURLConnection)url.openConnection();
            // 设置请求方式
            conn.setRequestMethod("POST");
            // 设置请求连接时间
            conn.setConnectTimeout(15 * 1000);
            // 设置服务器返回数据超时时间
            conn.setReadTimeout(6 * 1000);
            // 默认为 false；当向远程服务器传输数据时，需要设置为true
            conn.setDoOutput(true);
            // 默认为true； 当向远程服务读取数据时，需要设置为true
            conn.setDoInput(true);
            // 设置传入参数的格式，请求参数应该是 name1=value&name2=value2&name3=value3
            conn.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 获取一个连接对象的输出流
            os = conn.getOutputStream();
            // 通过输出流对象将参数写出去/传输出去，通过字节方式写出
            os.write(param.getBytes());
            if (HttpURLConnection.HTTP_OK == conn.getResponseCode()) {
                in = conn.getInputStream();
                br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
                String line = null;
                StringBuffer sb = new StringBuffer();
                while ((line = br.readLine()) != null) {
                    sb.append(line).append("\r\n");
                }
                result = sb.toString();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 关闭资源
            if (null != br) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (null != os) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            conn.disconnect();
        }
        return result;
    }

    public static void main(String[] args) {
        String res = HttpClient.doGet("http://www.zongheng.com/");
        System.out.println(res);
    }

}
