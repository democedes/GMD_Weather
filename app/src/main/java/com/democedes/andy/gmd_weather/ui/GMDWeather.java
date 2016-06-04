package com.democedes.andy.gmd_weather.ui;

/**
 * Created by Andy on 6/2/2016.
 */

import android.app.Application;

import com.democedes.andy.gmd_weather.api.OpenWeatherApi;
import com.democedes.andy.gmd_weather.db.CachingDbHelper;
import com.democedes.andy.gmd_weather.helper.Constants;

public class GMDWeather extends Application {
    private static GMDWeather instance;
    private CachingDbHelper cachingDbHelper;
    private OpenWeatherApi openWeatherApi;

    @Override
    public void onCreate() {
        super.onCreate();
        this.instance = this;
        this.openWeatherApi = new OpenWeatherApi(Constants.OpenWeatherApi.URL);
        this.cachingDbHelper = new CachingDbHelper(getApplicationContext());
    }

    public static GMDWeather getApplication() {
        return instance;
    }

    public CachingDbHelper getCachingDbHelper() {
        return cachingDbHelper;
    }

    public OpenWeatherApi getOpenWeatherApi() {
        return openWeatherApi;
    }
}