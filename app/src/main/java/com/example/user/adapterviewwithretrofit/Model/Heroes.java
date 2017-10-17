package com.example.user.adapterviewwithretrofit.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by user on 25/9/17.
 */

public class Heroes
{

    @SerializedName("heroes")
    private ArrayList<Hero> heros;

    public Heroes(){

    }

    public ArrayList<Hero> getHeros(){
        return heros;
    }


}
