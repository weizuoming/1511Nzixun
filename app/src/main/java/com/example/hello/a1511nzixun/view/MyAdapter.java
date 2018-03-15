package com.example.hello.a1511nzixun.view;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hello.a1511nzixun.R;
import com.example.hello.a1511nzixun.model.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

/**
 * Created by 韦作铭 on 2018/3/15.
 */

public class MyAdapter extends BaseAdapter {
    private Bean bean;
    private Context context;

    public MyAdapter(Context context, Bean bean) {
        this.context=context;
        this.bean=bean;
    }

    @Override
    public int getCount() {
        return bean.getData().size();
    }

    @Override
    public Object getItem(int i) {
        return bean.getData().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        if (view==null){
            view = View.inflate(context, R.layout.item_layout, null);
        }

        SimpleDraweeView sdv = view.findViewById(R.id.sdv);
        TextView tv1 = view.findViewById(R.id.tv1);
        TextView tv2 = view.findViewById(R.id.tv2);
        TextView tv3 = view.findViewById(R.id.tv3);
        SimpleDraweeView sdv1 = view.findViewById(R.id.sdv1);

        Bean.DataBean dataBean = bean.getData().get(i);
        String content = dataBean.getContent();
        String createTime = dataBean.getCreateTime();
        Bean.DataBean.UserBean user = dataBean.getUser();
        String icon = (String) user.getIcon();
        String nickname = user.getNickname();

        tv1.setText(nickname);
        tv2.setText(createTime);
        tv3.setText(content);

        String imgUrls = (String) dataBean.getImgUrls();

        if (imgUrls==null || "".equals(imgUrls) ){
            sdv1.setVisibility(View.GONE);
        }else {
            sdv1.setVisibility(View.VISIBLE);
            sdv1.setImageURI(Uri.parse(imgUrls));
        }

        if (icon==null || "".equals(icon)){

        }else {
            sdv.setImageURI(Uri.parse(icon));
        }

        return view;
    }
}
