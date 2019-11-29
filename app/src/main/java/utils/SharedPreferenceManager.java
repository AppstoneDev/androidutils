package utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Manabendu on 2019-07-23
 */
public class SharedPreferenceManager {
    private static String SHARED_PREF_NAME;
    private static SharedPreferenceManager mInstance;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context mContext;


    @SuppressLint("CommitPrefEdits")
    public SharedPreferenceManager(Context context, String prefName) {
        mContext = context;
        SHARED_PREF_NAME = prefName;
        preferences = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        editor = preferences.edit();
    }

    public SharedPreferences.Editor getEditor() {
        return preferences.edit();
    }

    public void setString(String key, String value) {
        getEditor().putString(key, value).apply();
    }

    public String getString(String key) {
        return preferences.getString(key, "");
    }

    public void setBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    public boolean getBoolean(String key) {
        return preferences.getBoolean(key, false);
    }

    public void setInt(String key, int value) {
        getEditor().putInt(key, value).apply();
    }

    public int getInt(String key) {
        return preferences.getInt(key, -1);
    }

    public void setLong(String key,long value){
        getEditor().putLong(key,value).apply();
    }

    public long getLong(String key){
        return  preferences.getLong(key,-9223372036854775807L);
    }


}
