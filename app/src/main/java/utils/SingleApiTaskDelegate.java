package utils;

import java.util.HashMap;

public interface SingleApiTaskDelegate {
    void onTaskCompleted(String response);

    void onErrorOccured(String error);
}
