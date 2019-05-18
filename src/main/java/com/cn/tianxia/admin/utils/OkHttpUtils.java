package com.cn.tianxia.admin.utils;


import com.cn.tianxia.admin.common.OkHttpClient;
import com.google.gson.Gson;
import okhttp3.*;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Jacky
 * @version 1.0.0
 * @ClassName OkHttpClient
 * @Description httpUtils
 * @Date 2019年5月6日 下午17:08:53
 */
@Component
public class OkHttpUtils {

    private static final Logger logger = LoggerFactory.getLogger(OkHttpUtils.class);

    static class Gist {
        Map<String, GistFile> files;
    }

    static class GistFile {
        String content;
    }


    private final static okhttp3.OkHttpClient client = OkHttpClient.CLIENT.getClientInstance();
    private final static MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private final Gson gson = new Gson();


    public static String sendMapPost(String url, Map<String, String> map) throws Exception {
        logger.info("sendGet(Map<String, String > map  =  {}, url = {} -start", map, url);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "application/x-www-form-urlencoded")
                .add("charset", "UTF-8");
        return sendMapPost(url, map, builder.build());
    }

    public static String sendJsonPost(String url, String requestParams) throws Exception {
        logger.info("sendJsonPost(request params  =  {}, url = {} -start", requestParams, url);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "application/json")
                .add("charset", "UTF-8");
        return sendJsonPost(url, requestParams, builder.build());
    }


    public static String sendGet(String url) throws Exception {
        logger.info("sendGet(String url =  {} -start", url);
        Headers.Builder builder = new Headers.Builder();
        builder.add("User-Agent", "application/x-www-form-urlencoded")
                .add("charset", "UTF-8")
                .add("Connection", "close");
        return sendGet(url, builder.build());
    }


    public static String sendGet(String url, Headers headers) throws Exception {
        logger.info("sendGet(String url =  {} -start", url);
        if (StringUtils.isBlank(url))
            throw new Exception("GET 请求URL不能为空！");

        Request request = new Request.Builder()
                .addHeader("User-Agent", "application/x-www-form-urlencoded")
                .addHeader("charset", "UTF-8")
                //.addHeader("Connection", "close")
                .headers(headers)
                .get()
                .url(url)
                .build();
        String returnJson = null;
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response.code());

            if (response.body() != null) {
                returnJson = IOUtils.toString(response.body().byteStream(), Consts.UTF_8);
            }
            if (StringUtils.isEmpty(returnJson))
                return null;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);

        } catch (Exception e) {
            logger.error("发送HTTP GET请求异常！", e);
            throw e;
        }
        logger.info("sendGet(String url)  - return -end {}", returnJson);
        return returnJson;

    }


    public Map<String, String> sendGetByGson(String url) throws Exception {
        logger.info("sendGet(String url = {} -start", url);
        Request request = new Request.Builder()
                .addHeader("User-Agent", "application/x-www-form-urlencoded")
                .addHeader("charset", "UTF-8")
                .url(url)
                .build();
        Map<String, String> map = new HashMap<>();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response.code());

            Gist gist;
            if (response.body() != null) {
                gist = gson.fromJson(response.body().charStream(), Gist.class);
            } else {
                return null;
            }
            for (Map.Entry<String, GistFile> entry : gist.files.entrySet()) {
                map.put(entry.getKey(), entry.getValue().content);
            }

            logger.info("sendGetByGson(String url) -return -end {}", map);

        }catch (IOException e){
            logger.error(e.getMessage(),e);
            throw  e;
        } catch (Exception e) {
            logger.error("发送GET 请求异常！", e);
            throw e;
        }

        return map;

    }

    public static String sendJsonPost(String url, String requestParam, Headers headers) throws Exception {
        if (StringUtils.isBlank(requestParam) || StringUtils.isBlank(url))
            throw new RuntimeException("post 请求参数或请求URL不能为空！");
        RequestBody requestBody = RequestBody.create(JSON, requestParam);
        return sendPost(url, requestBody, headers);

    }

    public static String sendMapPost(String url, Map<String,String> requestMap, Headers headers) throws Exception {
        logger.info("sendMapPost(Map<String, String > map  =  {}, url = {} -start", requestMap, url);
        if (StringUtils.isEmpty(url) || requestMap.isEmpty())
            throw new Exception("POST 请求URL或请求参数不能为空！");
        RequestBody requestBody = RequestBody.create(JSON, requestMap.toString());
        return sendPost(url, requestBody, headers);
    }


    public static String sendPost(String url, RequestBody requestBody, Headers headers) throws Exception {
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .headers(headers)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful())
                throw new IOException("Unexpected code " + response.code());

            InputStream inputStream;
            if (response.body() != null) {
                inputStream = response.body().byteStream();
            } else {
                return null;
            }
            String returnJson = IOUtils.toString(inputStream, Consts.UTF_8);

            if (StringUtils.isEmpty(returnJson)) throw new NullPointerException();

            logger.info("sendPost(Map<String, String > map , String url) - return -end {}", returnJson);
            return returnJson;
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
            throw e;
        } catch (Exception e) {
            logger.error("发送HTTPPOST请求错误！", e);
            throw e;
        }


    }
}
