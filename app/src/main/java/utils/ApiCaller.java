package utils;

import java.util.HashMap;


abstract public class ApiCaller {
    abstract public String getURL();

    abstract public HashMap<String, Object> getParams();

    private Api api;
    private static ApiCaller mInstance;

    public Api getAPI() {
        api = new ApiHandler().getApi();
        return api;
    }



    protected boolean parseJSONResponse(String response) {
        return true;
    }




}
