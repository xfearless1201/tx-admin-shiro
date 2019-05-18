package com.cn.tianxia.admin.common;

import java.util.concurrent.TimeUnit;

/**
 *
 * @ClassName OkHttpClient
 * @Description   http实例
 * @author Jacky
 * @Date 2019年5月6日 下午17:08:53
 * @version 1.0.0
 *
 */
public enum OkHttpClient {
    CLIENT;

    private okhttp3.OkHttpClient clientInstance;

    private Integer connectTimeout_time = 10;
    private Integer writeTimeout_time = 10;
    private Integer readTimeout_time = 30;

    OkHttpClient() {
        clientInstance = new okhttp3.OkHttpClient.Builder()
                .connectTimeout(connectTimeout_time, TimeUnit.SECONDS)
                .writeTimeout(writeTimeout_time, TimeUnit.SECONDS)
                .readTimeout(readTimeout_time, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)//当为true时,会进行而多次重连,timeOut会失效，可能导致当前用户线程占有过久
                .build();
    }

    public okhttp3.OkHttpClient getClientInstance() {
        return clientInstance;
    }

}
