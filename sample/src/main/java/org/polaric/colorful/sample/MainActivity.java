package org.polaric.colorful.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import org.polaric.colorful.ColorPickerDialog;
import org.polaric.colorful.Colorful;
import org.polaric.colorful.ColorfulActivity;

import java.security.SecureRandom;

import static org.polaric.colorful.Colorful.ThemeColor;

public class MainActivity extends ColorfulActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));
    }

    public void onRandomTheme(final View view) {
        Colorful.config(this)
                .primaryColor(pickRandomThemeColor())
                .accentColor(pickRandomThemeColor())
                .translucent(pickRandomBoolean())
                .dark(pickRandomBoolean())
                .apply();
        recreateActivity(MainActivity.this, MainActivity.class);
    }

    public void onPickTheme(final View view) {
        final ColorPickerDialog dialog = new ColorPickerDialog(this);
        dialog.setOnColorSelectedListener(new ColorPickerDialog.OnColorSelectedListener() {
            @Override
            public void onColorSelected(Colorful.ThemeColor color) {
                Colorful.config(MainActivity.this)
                        .primaryColor(pickRandomThemeColor())
                        .apply();
                recreateActivity(MainActivity.this, MainActivity.class);
            }
        });
        dialog.show();
    }

    public void onPreference(final View view) {
        startActivity(new Intent(this, SettingActivity.class));
    }

    private SecureRandom mRandom = new SecureRandom();

    private ThemeColor pickRandomThemeColor() {
        final ThemeColor[] colors = ThemeColor.values();
        return colors[mRandom.nextInt(colors.length)];
    }

    private Boolean pickRandomBoolean() {
        return mRandom.nextBoolean();
    }

    public static void recreateActivity(final Activity activity, final Class<?> cls) {
        // recreate();
        // simply calling recreate() works but will cause an ugly black blinking

        final Intent intent = new Intent(activity, cls);
        activity.startActivity(intent);
        activity.finish();
        // this is important for seamless transition
        activity.overridePendingTransition(0, 0);
    }
}
