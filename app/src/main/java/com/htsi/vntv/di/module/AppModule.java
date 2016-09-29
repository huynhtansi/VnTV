package com.htsi.vntv.di.module;

import android.content.Context;

import com.htsi.vntv.BuildConfig;
import com.htsi.vntv.app.VNTVApplication;
import com.htsi.vntv.data.repository.TVChannelRepository;
import com.htsi.vntv.data.repository.TVChannelRepositoryImp;
import com.htsi.vntv.data.service.TVChannelService;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:22 PM
 * Project: VnTV
 */
@Module
public class AppModule {

    private final VNTVApplication mVNTVApplication;

    public AppModule(VNTVApplication pVNTVApplication) {
        mVNTVApplication = pVNTVApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.mVNTVApplication;
    }

    @Provides
    @Singleton
    @Named("REST_ADAPTER")
    Retrofit provideRestAdapter() {
        OkHttpClient client = new OkHttpClient.Builder().build();
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BuildConfig.BASE_URL);
        return builder.build();
    }

    @Provides
    @Singleton
    TVChannelService provideTVChannelService(@Named("REST_ADAPTER") Retrofit pRetrofit) {
        return pRetrofit.create(TVChannelService.class);
    }

    @Provides
    @Singleton
    TVChannelRepository provideTVChannelRepository(TVChannelService pTVChannelService) {
        return new TVChannelRepositoryImp(pTVChannelService);
    }
}
