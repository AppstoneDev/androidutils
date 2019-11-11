package utils;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import in.appstone.androidutils.R;

/**
 * Created by Manabendu on 2019-07-23
 */
public class ThemeColorizer {

    public static void seViewTextColor(Context context, TextView view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorWhite, null));
        } else {
            view.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));
        }
    }

    public static void setViewEditTextColor(Context context, EditText view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setTextColor(context.getResources().getColor(R.color.colorWhite));
        } else {
            view.setTextColor(context.getResources().getColor(R.color.colorBlack));
        }
    }

    public static void setViewBackgroundColor(Context context, View view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorBlack));
        } else {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
        }
    }

    public static void setCheckBoxBackgroundColor(Context context, CheckBox view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorBlack));
            view.setTextColor(context.getResources().getColor(R.color.colorWhite));
        } else {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            view.setTextColor(context.getResources().getColor(R.color.colorBlack));
        }
    }

    public static void setVectorIconTint(Context context, ImageView view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setColorFilter(ContextCompat.getColor(context, R.color.colorWhite), android.graphics.PorterDuff.Mode.SRC_IN);

        } else {
            view.setColorFilter(ContextCompat.getColor(context, R.color.colorBlack), android.graphics.PorterDuff.Mode.SRC_IN);

        }
    }
}
