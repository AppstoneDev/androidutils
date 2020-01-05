package utils;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

import com.google.android.material.tabs.TabLayout;

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
            view.setHintTextColor(context.getResources().getColor(R.color.colorWhite));
        } else {
            view.setTextColor(context.getResources().getColor(R.color.colorBlack));
            view.setHintTextColor(context.getResources().getColor(R.color.colorBlack));
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

    public static void setTextViewHintViewColor(Context context, TextView view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorHalfWhite, null));
        } else {
            view.setTextColor(ResourcesCompat.getColor(context.getResources(), R.color.colorHalfGrey, null));
        }
    }

    public static void setTabLayoutColor(Context context, TabLayout view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorBlack));
            view.setTabTextColors(context.getResources().getColor(R.color.colorHalfWhite), context.getResources().getColor(R.color.colorWhite));
        } else {
            view.setBackgroundColor(context.getResources().getColor(R.color.colorWhite));
            view.setTabTextColors(context.getResources().getColor(R.color.colorHalfGrey), context.getResources().getColor(R.color.colorBlack));
        }
    }

    public static void setDividerColor(Context context, View view, boolean isDarkMode) {
        if (isDarkMode) {
            view.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorDividerWhite, null));
        } else {
            view.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorDividerGrey, null));
        }
    }
}
