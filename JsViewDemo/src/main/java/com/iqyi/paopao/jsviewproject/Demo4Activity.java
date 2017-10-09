package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.eclipsesource.v8.V8;
import com.eclipsesource.v8.V8Array;
import com.eclipsesource.v8.V8Object;
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
        setTitle("列表jsGenerateView");

        datas = new ArrayList<>();
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3687352270,1420167656&fm=27&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3037530008,1348733218&fm=27&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1803912284,1630642523&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2956344980,2083665809&fm=27&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2126593976,2544983032&fm=27&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3494374167,3965802318&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3214293127,1624548564&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3998983078,1771214757&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3656258293,215667308&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=2785681579,1798643838&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=633906328,1828877766&fm=27&gp=0.jpg");
        datas.add("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=3028319274,2765486413&fm=11&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2462728309,3100060121&fm=27&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2052905881,926545977&fm=27&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3301025250,1597782248&fm=27&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1398217826,619748703&fm=11&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=54669225,1566763439&fm=27&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3829776286,95595474&fm=27&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2242716576,3793457633&fm=27&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=308846034,1574217073&fm=27&gp=0.jpg");



        mV8 = J2V8Core.getRuntime();


        ListView listView = (ListView) findViewById(R.id.lv3);
        listView.setAdapter(new CustomAdapter());

    }

    private List<WindowJsObj> mWindowJsObjs = new ArrayList<>();
    private List<V8Object> mV8Objects = new ArrayList<>();


    private class CustomAdapter extends BaseAdapter {

        public CustomAdapter() {
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

            long startTime = System.currentTimeMillis();

            if (convertView == null) {
                WindowJsObj windowV8Obj = new WindowJsObj(mV8, parent);
                mWindowJsObjs.add(windowV8Obj);
                mV8.add("window", windowV8Obj.getObject());
                mV8.add("position", position);

                J2V8Core.run(parent.getContext(), "listview.js");
                convertView = windowV8Obj.getRootView();
                convertView.setTag(windowV8Obj);

                V8Object hockeyTeam = mV8.getObject("hockeyTeam");
                mV8Objects.add(hockeyTeam);
                convertView.setTag(R.id.item, hockeyTeam);
                convertView.setTag(R.id.position, position);

            } else {
                WindowJsObj windowV8Obj = (WindowJsObj) convertView.getTag();
                int pos = (int) convertView.getTag(R.id.position);
                mV8.add("window", windowV8Obj.getObject());
                mV8.add("position", pos);
            }


            V8Object hockeyTeam = (V8Object) convertView.getTag(R.id.item);
            V8Array parameters = new V8Array(mV8).push(datas.get(position)).push(
                    String.valueOf(position));
            hockeyTeam.executeVoidFunction("setData", parameters);
            parameters.release();
            long endTime = System.currentTimeMillis();
            Log.d("Demo4Activity", "duration=" + (endTime - startTime));
            return convertView;
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        for (WindowJsObj w : mWindowJsObjs) {
            w.clean();
        }
        for (V8Object v8Object : mV8Objects) {
            v8Object.release();
        }
        mV8.release();
    }
}
