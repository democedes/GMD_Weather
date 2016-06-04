package com.democedes.andy.gmd_weather.helper;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;

import com.democedes.andy.gmd_weather.R;
import com.democedes.andy.gmd_weather.ui.GMDWeather;

public class ResourcesHelper {
    private static DisplayMetrics metrics = new DisplayMetrics();
    private static Point screenSize = new Point();

    static {
        setScreenSize();
    }

    public static void setScreenSize() {
        ((WindowManager) GMDWeather.getApplication().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getMetrics(metrics);
        screenSize.x = ((WindowManager) GMDWeather.getApplication().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getWidth();
        screenSize.y = ((WindowManager) GMDWeather.getApplication().getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()
                .getHeight();
    }

    public static Point getScreenSize() {
        return screenSize;
    }

    public static boolean isLandscape() {
        setScreenSize();
        return (screenSize.x > screenSize.y);
    }

    public static DisplayMetrics getMetrics() {
        return metrics;
    }

    public static String getString(int resource) {
        return GMDWeather.getApplication().getString(resource);
    }

    public static String getString(int resource, Object... formatArgs) {
        return GMDWeather.getApplication().getString(resource, formatArgs);
    }

    public static Resources getResources() {
        return GMDWeather.getApplication().getResources();
    }

    public static String[] getStringArray(int resource) {
        return GMDWeather.getApplication().getResources().getStringArray(resource);
    }

    public static int getDimensionPixelSize(int resource) {
        GMDWeather app = GMDWeather.getApplication();
        TypedValue rawValue = new TypedValue();
        app.getResources().getValue(resource, rawValue, true);
        if (rawValue.type == TypedValue.TYPE_FIRST_INT) {
            return app.getResources().getInteger(resource);
        } else {
            return app.getResources().getDimensionPixelSize(resource);
        }
    }

    public static Drawable getDrawable(int resource) {
        return GMDWeather.getApplication().getResources().getDrawable(resource);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public static void setBackgroundDrawable(View view, Drawable drawable) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
            view.setBackgroundDrawable(drawable);
        } else {
            view.setBackground(drawable);
        }
    }

    public static Drawable getCurrentWeatherDrawable(String weatherType) {
        if (Constants.WeatherType.RAIN.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_rain);
        } else if (Constants.WeatherType.CLEAR.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_sun);
        } else if (Constants.WeatherType.CLOUDS.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_cloud);
        } else if (Constants.WeatherType.DRIZZLE.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_drizzle);
        } else if (Constants.WeatherType.THUDERSTORM.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_storm);
        } else if (Constants.WeatherType.HAZE.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_haze);
        } else if (Constants.WeatherType.SNOW.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.ic_snow);
        } else {
            return getDrawable(R.drawable.ic_cloud);
        }
    }

    public static Drawable changeCurrentBackground(String weatherType) {
        if (Constants.WeatherType.RAIN.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_rain);
        } else if (Constants.WeatherType.CLEAR.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_sun);
        } else if (Constants.WeatherType.CLOUDS.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_cloud);
        } else if (Constants.WeatherType.DRIZZLE.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_drizzle);
        } else if (Constants.WeatherType.THUDERSTORM.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_storm);
        } else if (Constants.WeatherType.HAZE.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_haze);
        } else if (Constants.WeatherType.SNOW.equalsIgnoreCase(weatherType)) {
            return getDrawable(R.drawable.bg_snow);
        } else {
            return getDrawable(R.drawable.bg_cloud);
        }
    }
}
