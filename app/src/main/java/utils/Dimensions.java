package utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class Dimensions {

    public static int pxToDp(int px, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int dpToPx(int dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    private static Point displaySize;

    public static int[] getDisplayDimensForAdapter(Context mContext) {
        int[] displayDimens = new int[2];

        if (displaySize == null) {
            WindowManager wm = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);

            if (wm != null) {
                Display display = wm.getDefaultDisplay();
                displaySize = new Point();
                display.getSize(displaySize);
            }
        }

        displayDimens[0] = displaySize.x;
        displayDimens[1] = displaySize.y;

        return displayDimens;
    }
}
