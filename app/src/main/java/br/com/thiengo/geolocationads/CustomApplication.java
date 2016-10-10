package br.com.thiengo.geolocationads;

import android.app.Application;

import com.inlocomedia.android.InLocoMedia;
import com.inlocomedia.android.InLocoMediaOptions;

/**
 * Created by viniciusthiengo on 10/10/16.
 */

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        InLocoMediaOptions options = InLocoMediaOptions.getInstance(this);
        options.setAdsKey("In Loco APP ID");
        options.setLogEnabled(true);
        options.setDevelopmentDevices("Device ID");

        InLocoMedia.init(this, options);
    }
}
