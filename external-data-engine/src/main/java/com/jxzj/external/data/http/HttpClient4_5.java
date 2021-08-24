package com.jxzj.external.data.http;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClient4_5 {

    public static String doGet(String url) {

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        String result = "";
        try {
            // 通过默认配置创建一个httpClient实例
            httpClient = HttpClients.createDefault();
            // 创建HttpGet远程实例
            HttpGet httpGet = new HttpGet(url);
            // 设置请求头信息，鉴权
            httpGet.setHeader("Authorization", "Bearer da3efcbf-0845-4fe3-8aba-ee040be542c0");
            // 配置请求参数
            RequestConfig build = RequestConfig.custom().setConnectTimeout(16 * 1000)
                .setConnectionRequestTimeout(16 * 1000).setSocketTimeout(10 * 1000).build();
            httpGet.setConfig(build);
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        String doGet = HttpClient4_5.doGet("wwww.baidu.com");
        System.out.println(doGet);
    }

}
