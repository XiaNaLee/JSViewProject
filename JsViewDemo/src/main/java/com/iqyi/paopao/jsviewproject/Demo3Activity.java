package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
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
        setTitle("列表native view");


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

            long startTime = System.currentTimeMillis();

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

            long endTime = System.currentTimeMillis();
            Log.d("Demo3Activity", "duration=" + (endTime - startTime));
            return convertView;
        }

        private class ViewHolder {
            public SimpleDraweeView sd;

        }
    }


}
