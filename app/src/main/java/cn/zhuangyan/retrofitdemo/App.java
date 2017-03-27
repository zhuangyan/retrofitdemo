package cn.zhuangyan.retrofitdemo;

import android.app.Application;

/**
 * Created by zhuangyan.
 */
public class App extends Application {
    private static App INSTANCE;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
    }
}
