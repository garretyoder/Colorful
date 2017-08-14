package org.polaric.colorful.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.widget.Toolbar;

import org.polaric.colorful.ColorfulActivity;

import static org.polaric.colorful.sample.MainActivity.recreateActivity;

/**
 * Created on 2017/8/14.
 * Hello, friend.
 */


public class SettingActivity extends ColorfulActivity {

    private static final String KEY_PRIMARY_COLOR = "primary_color";
    private static final String KEY_ACCENT_COLOR = "accent_color";

    public static final String PREFS_FRAGMENT_TAG = "prefs_fragment";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setSupportActionBar(((Toolbar) findViewById(R.id.toolbar)));
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Create the prefs fragment in code to
        // ensure it's created before PreferenceDialogFragment
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.main, new PrefsFragment(), PREFS_FRAGMENT_TAG)
                    .disallowAddToBackStack()
                    .commit();
        }
    }

    /**
     * {@link android.support.v7.preference.Preference} is used.
     */
    public static class PrefsFragment extends PreferenceFragmentCompat
            implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            getPreferenceManager().setStorageDeviceProtected();
            addPreferencesFromResource(R.xml.setting);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            // By default, do not recreate the parent activity
            getActivity().setResult(RESULT_CANCELED);
        }

        @Override
        public void onResume() {
            super.onResume();
            refresh();
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object newValue) {
            switch (preference.getKey()) {
                case KEY_PRIMARY_COLOR:
                case KEY_ACCENT_COLOR:
                    recreateActivity(getActivity(), SettingActivity.class);
                    break;
            }
            // Set result so parent knows to refresh itself
            getActivity().setResult(RESULT_OK);
            return true;
        }

        private void refresh() {
            final Preference pcp = findPreference(KEY_PRIMARY_COLOR);
            pcp.setOnPreferenceChangeListener(this);

            final Preference acp = findPreference(KEY_ACCENT_COLOR);
            acp.setOnPreferenceChangeListener(this);
        }
    }
}
