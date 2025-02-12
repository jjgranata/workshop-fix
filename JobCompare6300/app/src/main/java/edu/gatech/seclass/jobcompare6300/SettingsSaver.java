package edu.gatech.seclass.jobcompare6300;

import android.content.Context;
import android.content.SharedPreferences;

public class SettingsSaver {
    private static final String PREFS_NAME = "JobComparisonSettings";
    private SharedPreferences settings;

    public SettingsSaver(Context context) {
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    public void saveSetting(String key, String value) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getSetting(String key, String defaultValue) {
        return settings.getString(key, defaultValue);
    }

    // Add methods for other types of settings if needed
}
