package com.tencent.rtmp.demo.ui;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.util.Log;

import com.tencent.bugly.crashreport.CrashReport;
import com.tencent.rtmp.TXRtmpApi;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        this.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle bundle) {
                Log.d("------>", "onActivityCreated:" + activity);
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
        int[] sdkVer = TXRtmpApi.getSDKVersion();
        if (sdkVer != null && sdkVer.length >= 3) {
            if (sdkVer[0] > 0 && sdkVer[1] > 0) {
                CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(getApplicationContext());
                strategy.setAppVersion(String.format("%d.%d.%d", sdkVer[0], sdkVer[1], sdkVer[2]));
                CrashReport.initCrashReport(getApplicationContext(), strategy);

                Log.d("rtmpsdk", "init crash report");
            }
        }

    }
}