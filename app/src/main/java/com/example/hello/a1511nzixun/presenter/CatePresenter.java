package com.example.hello.a1511nzixun.presenter;


import com.example.hello.a1511nzixun.model.CatearyModel;
import com.example.hello.a1511nzixun.view.Iview;

import java.util.Map;

import okhttp3.ResponseBody;

/**
 * Created by 韦作铭 on 2018/3/15.
 */

public class CatePresenter extends BasePresenter implements PresenterImp {

    private Iview iview;
    private final CatearyModel catearyModel;

    public CatePresenter(Iview iview) {
        this.iview=iview;
        catearyModel = new CatearyModel(this);
    }

    @Override
    public void getDataFromNet(String url, Map<String, String> map) {
        catearyModel.getDataFromNet(url,map);
    }

    @Override
    public void unsubcribe() {
        catearyModel.unsubcribe();
    }

    @Override
    public void onSuccess(ResponseBody responseBody) {
        iview.onSuccess(responseBody);
    }

    @Override
    public void onError(Throwable throwable) {
        iview.onError(throwable);
    }
}
