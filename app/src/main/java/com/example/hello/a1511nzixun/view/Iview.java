package com.example.hello.a1511nzixun.view;

import okhttp3.ResponseBody;

/**
 * Created by 韦作铭 on 2018/3/15.
 */

public interface Iview {
    void onSuccess(ResponseBody responseBody);
    void onError(Throwable throwable);
}
