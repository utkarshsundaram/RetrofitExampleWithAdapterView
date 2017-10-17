package com.example.user.adapterviewwithretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterViewFlipper;
import android.widget.Toast;

import com.example.user.adapterviewwithretrofit.Adapter.MyAdpaterFlipper;
import com.example.user.adapterviewwithretrofit.Model.Hero;
import com.example.user.adapterviewwithretrofit.Model.Heroes;
import com.example.user.adapterviewwithretrofit.RetrofitService.ApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.example.user.adapterviewwithretrofit.utils.Constants.BASE_URL;

public class MainActivity extends AppCompatActivity {
    private AdapterViewFlipper adapterViewFlipper;
    public static String TAG=MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapterViewFlipper=(AdapterViewFlipper)findViewById(R.id.adapterViewFlipper);
      /*  Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService service =retrofit.create(ApiService.class);

        Call<Heroes>call=service.getHeroes();
        call.enqueue(new Callback<Heroes>() {
            @Override
            public void onResponse(Call<Heroes> call, Response<Heroes> response) {
                ArrayList<Hero>getHeros = response.body().getHeros();

                //creating adapter object
                MyAdpaterFlipper adapter = new MyAdpaterFlipper(getApplicationContext(), getHeros);

                //adding it to adapterview flipper
                adapterViewFlipper.setAdapter(adapter);
                adapterViewFlipper.setFlipInterval(1000);
                adapterViewFlipper.startFlipping();
                Log.d(TAG,"retrofit has worked");
            }

            @Override
            public void onFailure(Call<Heroes> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d(TAG,""+t.getMessage());
            }

        });
    }
}
