package com.example.hello.a1511nzixun.presenter;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/15.
 */

public interface PresenterImp {

    void getDataFromNet(String url, Map<String, String> map);
    void unsubcribe();

    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);

}
