package org.polaric.colorful.sample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.polaric.colorful.ColorfulActivity;

public class MainActivity extends ColorfulActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));
    }
}
