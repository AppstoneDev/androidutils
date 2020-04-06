package utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.ArrayList;

import in.appstone.androidutils.R;

public class PhotoImageGrid {

    public static void drawImageGrid(Context context, LinearLayout mainView, ArrayList<String> images) {
        int size = images.size();

        int[] screenDimensions = Dimensions.getDisplayDimensForAdapter(context);

        int screenWidth = screenDimensions[0];

        int margin10 = Dimensions.dpToPx(10, context);
        int margin5 = Dimensions.dpToPx(5, context);


        if (mainView != null) {
            mainView.removeAllViews();
            if (size == 1) {
                Glide.with(context.getApplicationContext())
                        .asBitmap()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .load(images.get(0))
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                                int w = bitmap.getWidth();
                                int singleImageHeight = bitmap.getHeight();

                                LinearLayout singleLayout = new LinearLayout(context);
                                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, singleImageHeight);
                                params.setMargins(margin10, margin10, margin10, margin10);
                                singleLayout.setLayoutParams(params);
                                singleLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));

                                View singleView = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                                ImageView mIvImage = singleView.findViewById(R.id.mImageView);
                                mIvImage.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                Glide.with(context).load(images.get(0)).into(mIvImage);

                                singleLayout.addView(singleView);
                                mainView.addView(singleLayout);
                            }
                        });
            } else if (size == 2) {
                LinearLayout firstLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, screenWidth);
                params.weight = 0.5f;
                params.setMargins(margin10, margin10, margin5, margin10);
                firstLayout.setLayoutParams(params);
                firstLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));


                LinearLayout secondLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0, screenWidth);
                params2.weight = 0.5f;
                params2.setMargins(margin5, margin10, margin10, margin10);
                secondLayout.setLayoutParams(params2);
                secondLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));

                View view = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                ImageView mIvImage = view.findViewById(R.id.mImageView);
                Glide.with(context).load(images.get(0)).into(mIvImage);
                firstLayout.addView(view);


                View view2 = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                ImageView mIvImage2 = view2.findViewById(R.id.mImageView);
                Glide.with(context).load(images.get(1)).into(mIvImage2);
                secondLayout.addView(view2);

                mainView.addView(firstLayout);
                mainView.addView(secondLayout);
            } else {

                int splitHeight = (int) screenWidth / 2;

                LinearLayout firstLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, screenWidth);
                params.weight = 0.5f;
                params.setMargins(margin10, margin10, margin5, margin10);
                firstLayout.setLayoutParams(params);
                firstLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));

                LinearLayout secondLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(0, screenWidth);
                params2.weight = 0.5f;
                params2.setMargins(margin5, margin10, margin10, margin10);
                secondLayout.setLayoutParams(params2);
                secondLayout.setOrientation(LinearLayout.VERTICAL);

                LinearLayout firstChildLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(splitHeight, 0);
                params3.weight = 0.5f;
                firstChildLayout.setLayoutParams(params3);
                firstChildLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));

                LinearLayout secondChildLayout = new LinearLayout(context);
                LinearLayout.LayoutParams params4 = new LinearLayout.LayoutParams(splitHeight, 0);
                params4.weight = 0.5f;
                params4.setMargins(5, 5, 5, 5);
                secondChildLayout.setLayoutParams(params4);
                secondChildLayout.setBackgroundColor(ResourcesCompat.getColor(context.getResources(), R.color.colorBlack, null));


                View view = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                ImageView mIvImage = view.findViewById(R.id.mImageView);
                Glide.with(context).load(images.get(0)).into(mIvImage);
                firstLayout.addView(view);

                View view2 = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                ImageView mIvImage2 = view2.findViewById(R.id.mImageView);
                Glide.with(context).load(images.get(1)).into(mIvImage2);
                firstChildLayout.addView(view2);

                View view3 = LayoutInflater.from(context).inflate(R.layout.cell_blog_image, null);
                ImageView mIvImage3 = view3.findViewById(R.id.mImageView);
                Glide.with(context).load(images.get(2)).into(mIvImage3);
                if (size > 3) {
                    RelativeLayout mRlAlpha = view3.findViewById(R.id.rl_img_alpha);
                    TextView mTvCount = view3.findViewById(R.id.tvCount);

                    mRlAlpha.setVisibility(View.VISIBLE);
                    mTvCount.setVisibility(View.VISIBLE);

                    mTvCount.setText(String.valueOf(size - 3).concat(" +"));
                }

                secondChildLayout.addView(view3);
                secondLayout.addView(firstChildLayout);
                secondLayout.addView(secondChildLayout);

                mainView.addView(firstLayout);
                mainView.addView(secondLayout);
            }
        }

    }
}
