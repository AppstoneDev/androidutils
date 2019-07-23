package utils;

import java.util.HashMap;


abstract public class ApiCaller {
    abstract protected String getURL();

    abstract protected HashMap<String, Object> getParams();

    protected Api api;
    private static ApiCaller mInstance;

    protected Api getAPI() {
        api = new ApiHandler().getApi();
        return api;
    }



    protected boolean parseJSONResponse(String response) {
        return true;
    }




}
