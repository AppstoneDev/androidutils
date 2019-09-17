package utils;

import java.util.HashMap;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface Api {


    @FormUrlEncoded
    @POST
    Observable<String> getReponse(@Url String url, @HeaderMap HashMap<String, String> headers, @FieldMap HashMap<String, Object> params);
}
