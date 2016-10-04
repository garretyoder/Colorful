package org.polaric.colorful.sample;

import android.app.Application;

import org.polaric.colorful.Colorful;

public class SampleApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Colorful.Default.primaryColor(Colorful.ThemeColor.RED);
        Colorful.Default.accentColor(Colorful.ThemeColor.BLUE);
        Colorful.init(this);
    }
}
