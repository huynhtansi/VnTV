package com.htsi.vntv.data.repository;

import com.htsi.vntv.data.model.response.CategoriesResponse;
import com.htsi.vntv.data.service.TVChannelService;

import retrofit2.Call;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:57 PM
 * Project: VnTV
 */

public class TVChannelRepositoryImp implements TVChannelRepository {

    private TVChannelService mTVChannelService;

    public TVChannelRepositoryImp(TVChannelService pTVChannelService) {
        mTVChannelService = pTVChannelService;
    }

    @Override
    public Call<CategoriesResponse> getCategories() {
        return mTVChannelService.getCategories();
    }
}
