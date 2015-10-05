package com.hitherejoe.tabby.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

import timber.log.Timber;

public class LoadTimeCallback extends CustomTabsCallback {

    private long mTime;
    private Activity mActivity;

    @Override
    public void onNavigationEvent(int navigationEvent, Bundle extras) {
        Timber.d("Navigation Event: %d", navigationEvent);
        switch (navigationEvent) {
            case NAVIGATION_STARTED:
                mTime = System.nanoTime();
                break;
            case NAVIGATION_FINISHED:
                mTime = System.nanoTime() - mTime;
                Timber.d("Time %d ns", mTime);
                break;
        }
    }

    public void setActivity(Activity activity) {
        mActivity = activity;
    }

    public void clear() {
        mActivity = null;
    }

    public void showTime() {
        if (mActivity != null) {
            Toast.makeText(mActivity,
                    String.format("Loaded in %d ms", TimeUnit.NANOSECONDS.toMillis(mTime)),
                    Toast.LENGTH_SHORT).show();
        }
    }
}
