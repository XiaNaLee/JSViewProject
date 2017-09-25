package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.iqyi.paopao.jsviewsdk.core.J2V8Core;
import com.iqyi.paopao.jsviewsdk.v8object.WindowJsObj;

import java.util.ArrayList;
import java.util.List;

public class Demo4Activity extends Activity {

    private List<String> datas;

    private V8 mV8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo3);

        datas = new ArrayList<>();
        datas.add(
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=733226887,"
                        + "3131487055&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2129390034,"
                        + "2297929709&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=464871635,"
                        + "3825712800&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2040801164,"
                        + "951544642&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=852686279,"
                        + "2090412269&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1055767145,"
                        + "1482547224&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=914486193,"
                        + "3483630599&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4031956454,"
                        + "726072657&fm=200&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3379898938,"
                        + "1852859788&fm=11&gp=0.jpg");
        datas.add(
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1293277274,"
                        + "3365578558&fm=11&gp=0.jpg");
        datas.add(
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=733226887,"
                        + "3131487055&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2129390034,"
                        + "2297929709&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=464871635,"
                        + "3825712800&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2040801164,"
                        + "951544642&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=852686279,"
                        + "2090412269&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1055767145,"
                        + "1482547224&fm=11&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=914486193,"
                        + "3483630599&fm=11&gp=0.jpg");
        datas.add(
                "https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4031956454,"
                        + "726072657&fm=200&gp=0.jpg");
        datas.add(
                "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3379898938,"
                        + "1852859788&fm=11&gp=0.jpg");
        datas.add(
                "https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1293277274,"
                        + "3365578558&fm=11&gp=0.jpg");


        mV8 = J2V8Core.getRuntime();


        ListView listView = (ListView) findViewById(R.id.lv3);
        listView.setAdapter(new CustomAdapter());

    }

    private List<WindowJsObj> mWindowJsObjs = new ArrayList<>();


    private class CustomAdapter extends BaseAdapter {

        private LayoutInflater ml;

        public CustomAdapter() {
            ml = LayoutInflater.from(Demo4Activity.this);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            if (convertView == null) {
                WindowJsObj mWindowV8Obj = new WindowJsObj(mV8, parent);
                mWindowJsObjs.add(mWindowV8Obj);
                mV8.add("window", mWindowV8Obj.getObject());
                J2V8Core.run(parent.getContext(), "test.js");
                convertView = mWindowV8Obj.getRootView();

                convertView.setTag(mWindowV8Obj);
            }

            WindowJsObj windowJsObj = (WindowJsObj) convertView.getTag();

            V8Array parameters = new V8Array(mV8);
            parameters.push(datas.get(position));
            mV8.executeVoidFunction("setData", parameters);
            parameters.release();
            return convertView;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (WindowJsObj w : mWindowJsObjs) {
            w.clean();
        }
        mV8.release();
    }
}
