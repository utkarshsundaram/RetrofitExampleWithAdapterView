package com.example.user.adapterviewwithretrofit.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by user on 25/9/17.
 */

public class Hero
{

    @SerializedName("name")
    private String name;

    @SerializedName("imageurl")
    private String url;

    public Hero(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }



}
