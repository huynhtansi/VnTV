package com.htsi.vntv.data.service;

import com.htsi.vntv.data.model.response.CategoriesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:50 PM
 * Project: VnTV
 */

public interface TVChannelService {

    @GET("/tv_channels/categories")
    Call<CategoriesResponse> getCategories();
}
