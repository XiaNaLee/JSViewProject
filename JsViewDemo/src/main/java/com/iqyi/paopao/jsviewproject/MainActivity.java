package com.iqyi.paopao.jsviewproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        int viewId = view.getId();
        if (viewId == R.id.button2) {
            Intent intent = new Intent(MainActivity.this, Demo1Activity.class);
            startActivity(intent);
        } else if (viewId == R.id.button3) {
            Intent intent = new Intent(MainActivity.this, Demo2Activity.class);
            startActivity(intent);
        } else if (viewId == R.id.button4) {
            Intent intent = new Intent(MainActivity.this, Demo3Activity.class);
            startActivity(intent);
        } else if (viewId == R.id.button5) {
            Intent intent = new Intent(MainActivity.this, Demo4Activity.class);
            startActivity(intent);
        }
    }
}
