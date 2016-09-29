package com.htsi.vntv.data.repository;

import com.htsi.vntv.data.model.response.CategoriesResponse;

import retrofit2.Call;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:57 PM
 * Project: VnTV
 */

public interface TVChannelRepository {

    Call<CategoriesResponse> getCategories();
}
