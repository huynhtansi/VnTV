package com.htsi.vntv.app;

import android.app.Application;

import com.htsi.vntv.di.component.AppComponent;
import com.htsi.vntv.di.component.DaggerAppComponent;
import com.htsi.vntv.di.module.AppModule;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:00 PM
 * Project: VnTV
 */

public class VNTVApplication extends Application {

    private static VNTVApplication mInstance;
    private AppComponent mAppComponent;

    public VNTVApplication() {
        mInstance = this;
    }

    public static VNTVApplication getInstance() {
        return mInstance;
    }

    public AppComponent getAppComponent() {
        return mAppComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //Dagger
        this.mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();


    }
}
