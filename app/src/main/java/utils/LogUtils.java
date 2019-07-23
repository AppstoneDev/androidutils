package utils;

import android.util.Log;

public class LogUtils {


    public void printInfo(String TAG, String message) {
        if (message.length() > 4000) {
            int chunkCount = message.length() / 4000;
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= message.length()) {
                    Log.i(TAG, message.substring(4000 * i));
                } else {
                    Log.i(TAG, message.substring(4000 * i, max));
                }
            }
        } else {
            Log.i(TAG, message);
        }
    }

    public void printError(String TAG, String message){
        if (message.length() > 4000) {
            int chunkCount = message.length() / 4000;
            for (int i = 0; i <= chunkCount; i++) {
                int max = 4000 * (i + 1);
                if (max >= message.length()) {
                    Log.e(TAG, message.substring(4000 * i));
                } else {
                    Log.e(TAG, message.substring(4000 * i, max));
                }
            }
        } else {
            Log.e(TAG, message);
        }
    }
}
