package com.democedes.andy.gmd_weather.api;

import com.democedes.andy.gmd_weather.api.baseapi.BaseApi;
import com.democedes.andy.gmd_weather.api.baseapi.BaseApiCall;
import com.democedes.andy.gmd_weather.api.baseapi.CachePolicy;
import com.democedes.andy.gmd_weather.api.baseapi.CallId;
import com.democedes.andy.gmd_weather.api.contract.OpenWeatherContract;
import com.democedes.andy.gmd_weather.api.model.WeatherReport;
import com.democedes.andy.gmd_weather.helper.Constants;

import retrofit.Callback;
import retrofit.RequestInterceptor;

public class OpenWeatherApi extends BaseApi<OpenWeatherContract> {

    public OpenWeatherApi(String baseUrl) {
        super(baseUrl, OpenWeatherContract.class);
    }

    @Override
    protected void onRequest(RequestInterceptor.RequestFacade request) {
        request.addQueryParam(Constants.OpenWeatherApi.APP_ID_QUERY_PARAM, Constants.OpenWeatherApi.API_KEY);
        request.addQueryParam(Constants.OpenWeatherApi.UNITS_QUERY_PARAM, Constants.OpenWeatherApi.METRIC);
    }

    public void getWeatherForCityName(String cityName, CallId callId, Callback<WeatherReport> callback) {
        CachePolicy cachePolicy = CachePolicy.CACHE_ELSE_NETWORK;
        cachePolicy.setCacheKey(String.format("weather_report_for_%1$s", cityName));
        cachePolicy.setCacheTTL(Constants.Time.TEN_MINUTES);

        BaseApiCall<WeatherReport> apiCall = registerCall(callId, cachePolicy, callback, WeatherReport.class);

        if (apiCall != null && apiCall.requiresNetworkCall()) {
            getService().getWeatherForCityName(cityName, apiCall);
        }
    }

}
