package com.lanou3g.dllo.athm.controler.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lanou3g.dllo.athm.R;
import com.lanou3g.dllo.athm.utils.CarToast;

public class MainActivity extends AppCompatActivity {
   private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.tv);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CarToast.shortMsg("哈哈哈");
            }
        });
    }
}
