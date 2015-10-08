package com.hitherejoe.tabby.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.customtabs.CustomTabsCallback;
import android.widget.Toast;

import com.hitherejoe.tabby.R;

import java.util.concurrent.TimeUnit;

import timber.log.Timber;

public class LoadTimeCallback extends CustomTabsCallback {

    private long mTime;
    private Activity mActivity;
    private boolean hasLoaded;

    @Override
    public void onNavigationEvent(int navigationEvent, Bundle extras) {
        Timber.d("Navigation Event: %d", navigationEvent);
        switch (navigationEvent) {
            case NAVIGATION_STARTED:
                hasLoaded = false;
                mTime = System.nanoTime();
                Timber.d("start %d", mTime);
                break;
            case NAVIGATION_FINISHED:
                hasLoaded = true;
                Timber.d("finished %d", mTime);
                mTime = System.nanoTime() - mTime;
                Timber.d("Time to load %d ns", mTime);
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
        if (hasLoaded && mActivity != null) {
            Toast.makeText(mActivity,
                    mActivity.getString(R.string.toast_load_time,
                            TimeUnit.NANOSECONDS.toMillis(mTime) / 1000d),
                    Toast.LENGTH_LONG).show();
            hasLoaded = false;
        }
    }
}
