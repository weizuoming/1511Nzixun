package com.example.hello.a1511nzixun.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;

import com.example.hello.a1511nzixun.R;
import com.example.hello.a1511nzixun.view.frament.FragmentDuanZi;
import com.example.hello.a1511nzixun.view.frament.FragmentFaXian;
import com.example.hello.a1511nzixun.view.frament.FragmentHome;
import com.example.hello.a1511nzixun.view.frament.FragmentShiPin;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup radioGroup;
    private FragmentHome fragmentHome;
    private FragmentDuanZi fragmentDuanZi;
    private FragmentFaXian fragmentFaXian;
    private FragmentShiPin fragmentShiPin;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radio_group);


        //管理者...开启事务(一个事务只能执行一次)....默认的是要显示第一个首页
        manager = getSupportFragmentManager();

        fragmentHome = new FragmentHome();

        //添加这个方法在使用的时候同一个fragment只能添加一次,否则会报错...结合着show和hide方法去使用
        manager.beginTransaction().add(R.id.frame, fragmentHome).commit();


        //监听事件
        radioGroup.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {

        //事务的对象
        FragmentTransaction transaction = manager.beginTransaction();

        //首先隐藏所有的fragment ...前提是不为空
        //在刚开始点击的时候,先判断fragment是否为空,,,如果不为空先让他隐藏
        if (fragmentHome != null) {
            transaction.hide(fragmentHome);
        }
        if (fragmentDuanZi != null) {
            transaction.hide(fragmentDuanZi);
        }
        if (fragmentFaXian != null) {
            transaction.hide(fragmentFaXian);
        }
        if (fragmentShiPin != null) {
            transaction.hide(fragmentShiPin);
        }


        switch (checkedId) {//点击选中某个button的时候要么去显示要么去添加,,,没有去添加,,,有则显示出来
            case R.id.radio_01:
                //manager.beginTransaction().replace(arg0, arg1).commit()
                if (fragmentHome == null) {
                    fragmentHome = new FragmentHome();
                    transaction.add(R.id.frame, fragmentHome);
                }else {
                    transaction.show(fragmentHome);
                }
                break;
            case R.id.radio_02:
                if (fragmentDuanZi == null) {
                    fragmentDuanZi = new FragmentDuanZi();
                    transaction.add(R.id.frame, fragmentDuanZi);
                }else {
                    transaction.show(fragmentDuanZi);
                }
                break;
            case R.id.radio_03:
                if (fragmentFaXian == null) {
                    fragmentFaXian = new FragmentFaXian();
                    transaction.add(R.id.frame, fragmentFaXian);
                }else {
                    transaction.show(fragmentFaXian);
                }
                break;
            case R.id.radio_04:
                if (fragmentShiPin == null) {
                    fragmentShiPin = new FragmentShiPin();
                    transaction.add(R.id.frame, fragmentShiPin);
                }else {
                    transaction.show(fragmentShiPin);
                }
                break;

            default:
                break;
        }



        //只能提交一次
        transaction.commit();
    }
}
