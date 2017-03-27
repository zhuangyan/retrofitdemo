package cn.zhuangyan.retrofitdemo.network.api;

import cn.zhuangyan.retrofitdemo.model.ResultReturn;

import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;
import rx.Observable;

/**
 * Created by zhuangyan.
 */
public interface RegisterApi {
    @FormUrlEncoded
    @POST("/api/reg/")
    Observable<ResultReturn> register(@Field("realname") String name, @Field("email") String email,
                                      @Field("mobile") String contact, @Field("password") String password,
                                      @Field("smsid") String smsid, @Field("code") String code);
}
