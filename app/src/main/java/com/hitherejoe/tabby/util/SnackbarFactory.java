package com.hitherejoe.tabby.util;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.view.ViewGroup;

import com.hitherejoe.tabby.R;

public class SnackbarFactory {

    public static Snackbar createSnackbar(View parent, String message) {
        Snackbar snackbar = Snackbar.make(parent, message, Snackbar.LENGTH_SHORT);
        Resources resources = parent.getContext().getResources();
        ViewGroup group = (ViewGroup) snackbar.getView();
        group.setBackgroundColor(resources.getColor(R.color.primary));
        return snackbar;
    }
}