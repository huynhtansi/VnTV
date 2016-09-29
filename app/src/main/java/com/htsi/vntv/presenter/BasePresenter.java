package com.htsi.vntv.presenter;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:42 PM
 * Project: VnTV
 */


public interface BasePresenter<ViewType> {

    void setView(ViewType pView);
}