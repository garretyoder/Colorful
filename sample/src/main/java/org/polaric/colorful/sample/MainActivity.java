package org.polaric.colorful.sample;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import org.polaric.colorful.CActivity;

public class MainActivity extends CActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));
    }
}
