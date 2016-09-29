package com.htsi.vntv.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by htsi.
 * Since: 9/29/16 on 5:53 PM
 * Project: VnTV
 */

public class Category {
    @SerializedName("category_id")
    private String id;

    @SerializedName("category_name")
    private String name;
}
