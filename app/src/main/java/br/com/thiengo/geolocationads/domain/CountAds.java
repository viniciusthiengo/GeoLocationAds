package br.com.thiengo.geolocationads.domain;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by viniciusthiengo on 10/10/16.
 */

public class CountAds {

    public static void incrementCounter(Context context){
        SharedPreferences sp = context.getSharedPreferences("sp_db", Context.MODE_PRIVATE);
        int count = sp.getInt("count", 0);
        count++;
        sp.edit().putInt("count", count).apply();
    }

    public static boolean isUpToShowAd( Context context ){
        SharedPreferences sp = context.getSharedPreferences("sp_db", Context.MODE_PRIVATE);
        int count = sp.getInt("count", 0);
        return count % 3 == 0;
    }
}
