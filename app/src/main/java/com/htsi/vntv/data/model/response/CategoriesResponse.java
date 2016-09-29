package com.htsi.vntv.data.model.response;

import com.google.gson.annotations.SerializedName;
import com.htsi.vntv.data.model.Category;

import java.util.List;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:52 PM
 * Project: VnTV
 */

public class CategoriesResponse {

    @SerializedName("data")
    private List<Category> datas;

    @SerializedName("message")
    private String message;

    @SerializedName("status")
    private int status;
}
