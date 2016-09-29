package com.htsi.vntv.di.component;

import com.htsi.vntv.di.module.AppModule;
import com.htsi.vntv.ui.activity.BaseActivity;
import com.htsi.vntv.ui.fragment.BaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:26 PM
 * Project: VnTV
 */
@Singleton
@Component( modules = {
        AppModule.class
})
public interface AppComponent {

    void inject(BaseActivity pActivity);
    void inject(BaseFragment pBaseFragment);
}