package com.example.user.adapterviewwithretrofit.RetrofitService;

import com.example.user.adapterviewwithretrofit.Model.Heroes;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by user on 25/9/17.
 */

public interface ApiService
{
    @GET("heroes.php")
    Call<Heroes> getHeroes();
}
