package com.example.hello.a1511nzixun.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by 辛政维 on 2018/3/15.
 */

public abstract class BasePresenter<T> {

    protected Reference<T> weakReference;

    public void attchView(T view){
        weakReference = new WeakReference<>(view);
    }

    public T getView(){
        return weakReference.get();
    }

    public boolean isViewAttached(){
        return weakReference != null && weakReference.get() != null;
    }

    public void detachView(){
        if (weakReference != null){
            weakReference.clear();
            weakReference = null;
        }
    }

}
