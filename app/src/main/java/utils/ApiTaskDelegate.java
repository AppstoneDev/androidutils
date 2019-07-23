package utils;

import java.util.HashMap;

public interface ApiTaskDelegate {
    void onTaskCompleted(HashMap<String, String> observables);

    void onErrorOccured(String error);
}
