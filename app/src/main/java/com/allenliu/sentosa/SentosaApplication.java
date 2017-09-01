package com.allenliu.sentosa;

import android.app.Application;

import sg.fooyo.sdkosp.sdk.FooyoSDK;


/**
 * Created by allenliu on 2017/7/31.
 */

public class SentosaApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FooyoSDK.init(this,true);
    }
}
