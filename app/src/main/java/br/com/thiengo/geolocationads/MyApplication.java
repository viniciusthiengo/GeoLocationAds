package br.com.thiengo.geolocationads;

import android.app.Application;

import com.inlocomedia.android.InLocoMedia;
import com.inlocomedia.android.InLocoMediaOptions;

/**
 * Created by viniciusthiengo on 10/10/16.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        InLocoMediaOptions options = InLocoMediaOptions.getInstance(this);
        options.setAdsKey("4fc9f3d2d646e4864c711850021c83a133ca56ffc13dffcfb9cead042f942f50");
        options.setLogEnabled(true);
        //options.setDevelopmentDevices("");

        InLocoMedia.init(this, options);
    }
}
