package cn.zhuangyan.retrofitdemo.network.api;

import com.squareup.okhttp.RequestBody;

import cn.zhuangyan.retrofitdemo.model.LoginReturn;

import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.Headers;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by zhuangyan.
 */
public interface LoginApi {
    @FormUrlEncoded
    @POST("/api/api-token-auth/")
    Observable<LoginReturn> login(@Field("username") String email, @Field("password") String password);

    @Headers({"Content-Type: application/json","Accept: application/json"})
    @POST("/api/api-token-auth/")
    Observable<LoginReturn> login(@Body RequestBody body);
}
