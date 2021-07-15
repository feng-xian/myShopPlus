package com.yl.myshop.plus.business;

import com.google.common.collect.Maps;
import com.yl.myshop.plus.commons.utils.okhttp3.MapperUtils;
import com.yl.myshop.plus.commons.utils.okhttp3.OkHttpClientUtil;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author : YeLei
 * @Date : 2021/5/7 19:31
 * @Version : 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OkHttp3Test {


    
    @Test
    public void OkHttp3Get(){
        String url = "https://www.baidu.com";
        OkHttpClient httpClient = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        Call call = httpClient.newCall(request);
        try {
            Response response = call.execute();
            String body = response.body().string();
            System.out.println(body);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPost() {
        String url = "http://localhost:9001/oauth/token";
        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("username", "admin")
                .add("password", "123456")
                .add("grant_type", "password")
                .add("client_id", "client")
                .add("client_secret", "secret")
                .build();
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            System.out.println(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testOkHttpUtil(){
        String url = "http://localhost:9001/oauth/token";
        HashMap<String, String> hashMap = Maps.newHashMap();
        hashMap.put("username","admin");
        hashMap.put("password","123456");
        hashMap.put("grant_type","password");
        hashMap.put("client_id","client");
        hashMap.put("client_secret","secret");
        Response response = OkHttpClientUtil.getInstance().postData(url, hashMap);
        try {
            String resp = response.body().string();
            Map<String, Object> json2map = MapperUtils.json2map(resp);
            System.out.println("result is : "+json2map.get("access_token"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
