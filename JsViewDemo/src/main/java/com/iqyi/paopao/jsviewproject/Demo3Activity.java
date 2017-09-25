package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

public class Demo3Activity extends Activity {

    private List<String> datas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo3);

        datas = new ArrayList<>();
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=733226887,3131487055&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2129390034,2297929709&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=464871635,3825712800&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2040801164,951544642&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=852686279,2090412269&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1055767145,1482547224&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=914486193,3483630599&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4031956454,726072657&fm=200&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3379898938,1852859788&fm=11&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1293277274,3365578558&fm=11&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=733226887,3131487055&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=2129390034,2297929709&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=464871635,3825712800&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2040801164,951544642&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=852686279,2090412269&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1055767145,1482547224&fm=11&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=914486193,3483630599&fm=11&gp=0.jpg");
        datas.add("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=4031956454,726072657&fm=200&gp=0.jpg");
        datas.add("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3379898938,1852859788&fm=11&gp=0.jpg");
        datas.add("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1293277274,3365578558&fm=11&gp=0.jpg");


        ListView listView = (ListView) findViewById(R.id.lv3);
        listView.setAdapter(new CustomAdapter());

    }


    private class CustomAdapter extends BaseAdapter {

        private LayoutInflater ml;

        public CustomAdapter() {
            ml = LayoutInflater.from(Demo3Activity.this);
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

            ViewHolder v;
            if (convertView == null) {
                convertView = ml.inflate(
                        R.layout.activity_demo1, null);
                v = new ViewHolder();
                v.sd = (SimpleDraweeView) convertView.findViewById(R.id.sd);
                GenericDraweeHierarchy genericDraweeHierarchy =  v.sd.getHierarchy();
                RoundingParams roundingParams = new RoundingParams();
                roundingParams.setRoundAsCircle(true);
                genericDraweeHierarchy.setRoundingParams(roundingParams);
                v.sd.setHierarchy(genericDraweeHierarchy);
                convertView.setTag(v);
            } else {
                v = (ViewHolder) convertView.getTag();
            }

            v.sd.setImageURI(datas.get(position));
            return convertView;
        }

        private class ViewHolder {
            public SimpleDraweeView sd;

        }
    }


}
