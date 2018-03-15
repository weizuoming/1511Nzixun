package com.example.hello.a1511nzixun.view.frament;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.hello.a1511nzixun.R;
import com.example.hello.a1511nzixun.model.Bean;
import com.example.hello.a1511nzixun.presenter.CatePresenter;
import com.example.hello.a1511nzixun.view.Iview;
import com.example.hello.a1511nzixun.util.Constant;
import com.example.hello.a1511nzixun.view.MyAdapter;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.ResponseBody;

/**
 * Created by 韦作铭 on 2018/3/15.
 */

public class FragmentDuanZi extends Fragment implements Iview {
    private ListView lv;
    private CatePresenter catePresenter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout_duanzi,container,false);
        lv = view.findViewById(R.id.lv);
        catePresenter = new CatePresenter(this);
        catePresenter.attchView(this);
        getData();
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
    @Override
    public void onSuccess(ResponseBody responseBody) {

        try {
            Bean bean = new Gson().fromJson(responseBody.string(), Bean.class);
            lv.setAdapter(new MyAdapter(getActivity(),bean));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onError(Throwable throwable) {

    }

    public void getData() {

        HashMap<String,String> map=new HashMap<>();
        map.put("page","1");
        map.put("appVersion","100");
        catePresenter.getDataFromNet(Constant.CATEGARY_URL,map);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        catePresenter.unsubcribe();
    }
}
