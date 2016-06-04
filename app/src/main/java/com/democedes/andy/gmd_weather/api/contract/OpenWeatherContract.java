package com.democedes.andy.gmd_weather.api.contract;

/**
 * Created by Andy on 6/2/2016.
 */
import com.democedes.andy.gmd_weather.api.model.WeatherReport;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Query;

public interface OpenWeatherContract {
    @GET("/data/2.5/weather")
    void getWeatherForCityName(
            @Query("q") String cityName,
            Callback<WeatherReport> callback);

}
