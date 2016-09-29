package com.htsi.vntv.ui.view;

import android.content.Context;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:41 PM
 * Project: VnTV
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    void showRetry();
    void hideRetry();
    Context getContext();
}
