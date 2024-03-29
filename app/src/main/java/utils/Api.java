package utils;

import androidx.annotation.RawRes;

import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface Api {


    @FormUrlEncoded
    @POST
    Observable<String> getReponse(@Url String url, @HeaderMap HashMap<String, String> headers, @FieldMap HashMap<String, Object> params);


    @GET
    Observable<String> performGetMethodRAW(@Url String url, @HeaderMap HashMap<String, String> headers, @QueryMap HashMap<String, Object> body);

    @POST
    Observable<String> performPostMethodRAW(@Url String url, @HeaderMap HashMap<String, String> headers, @Body RequestBody body);

    @PUT
    Observable<String> performPutMethodRAW(@Url String url, @HeaderMap HashMap<String, String> headers, @FieldMap HashMap<String, Object> params);

    @PATCH
    Observable<String> performPatchMethodRAW(@Url String url, @HeaderMap HashMap<String, String> headers, @Body RequestBody body);

    @HTTP(method = "DELETE", hasBody = true)
    Observable<String> performDeleteMethodRAW(@Url String url, @HeaderMap HashMap<String, String> headers, @Body RequestBody body);


    @Multipart
    @POST
    Observable<String> uploadFiles(@Url String url, @HeaderMap HashMap<String, String> headers, @Part MultipartBody.Part[] file);

    @Multipart
    @POST
    Observable<String> uploadMultipleFiles(@Url String url, @HeaderMap HashMap<String, String> headers, @Part MultipartBody.Part[] file, @PartMap HashMap<String, RequestBody> data);

    @Multipart
    @POST
    Observable<String> uploadMultipleFilesNormal(@Url String url, @HeaderMap HashMap<String, String> headers, @Part MultipartBody.Part[] file, @PartMap HashMap<String, RequestBody> data);


    public enum APIMETHODS {
        GET, POST, PUT, DELETE, POST_IMAGE, PATCH
    }

}
