package com.example.lab02;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class Lab02_3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab02_3);

        TabHost tabHost = findViewById(R.id.host);
        tabHost.setup();

        TabHost.TabSpec spec = tabHost.newTabSpec("tab1");
        spec.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_icon1, null));
        spec.setContent(R.id.tab_content1);
        tabHost.addTab(spec);

        TabHost.TabSpec spec2 = tabHost.newTabSpec("tab2");
        spec2.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_icon2, null));
        spec2.setContent(R.id.tab_content2);
        tabHost.addTab(spec2);

        TabHost.TabSpec spec3 = tabHost.newTabSpec("tab3");
        spec3.setIndicator(null, ResourcesCompat.getDrawable(getResources(), R.drawable.tab_icon3, null));
        spec3.setContent(R.id.tab_content3);
        tabHost.addTab(spec3);



    }
}
