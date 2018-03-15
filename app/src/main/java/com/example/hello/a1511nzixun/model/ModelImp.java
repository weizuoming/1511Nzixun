package com.example.hello.a1511nzixun.model;

import java.util.Map;

/**
 * Created by 辛政维 on 2018/3/15.
 */

public interface ModelImp {

    void getDataFromNet(String url, Map<String, String> map);
    void unsubcribe();

}
