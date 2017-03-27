package cn.zhuangyan.retrofitdemo.network.api;

import cn.zhuangyan.retrofitdemo.model.MailListReturn;
import cn.zhuangyan.retrofitdemo.model.ResultReturn;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.Header;
import retrofit.http.POST;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by zhuangyan on 17-3-27.
 */

public interface MailListApi {
    @GET("/api/users/")
    Observable<MailListReturn> maillist(@Header("Authorization") String token,@Query("name") String keyword);
}
