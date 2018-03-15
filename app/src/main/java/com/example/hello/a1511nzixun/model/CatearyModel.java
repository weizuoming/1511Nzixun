package com.example.hello.a1511nzixun.model;


import com.example.hello.a1511nzixun.presenter.CatePresenter;
import com.example.hello.a1511nzixun.util.RetrofitUtil;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

/**
 * Created by 辛政维 on 2018/3/15.
 */

public class CatearyModel implements ModelImp {
    private CatePresenter catePresenter;
    private Disposable d;

    public CatearyModel(CatePresenter catePresenter) {
        this.catePresenter=catePresenter;
    }
    @Override
    public void getDataFromNet(String url, Map<String, String> map) {

        RetrofitUtil.getService().doGet(url,map)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        CatearyModel.this.d=d;
                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        catePresenter.onSuccess(responseBody);
                    }

                    @Override
                    public void onError(Throwable e) {
                        catePresenter.onError(e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }

    @Override
    public void unsubcribe() {

        d.dispose();

    }
}
