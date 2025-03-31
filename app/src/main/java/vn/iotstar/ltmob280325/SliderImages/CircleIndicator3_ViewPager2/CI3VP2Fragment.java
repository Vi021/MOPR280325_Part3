package vn.iotstar.ltmob280325.SliderImages.CircleIndicator3_ViewPager2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator3;
import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.SliderImages.ImageModel;

public class CI3VP2Fragment extends Fragment {
    private ViewPager2 vPager2;
    private CircleIndicator3 crcInd3;
    private ArrayList<ImageModel> imgs;

    private Runnable runnable() {
        return () -> {
            if (vPager2.getCurrentItem() == imgs.size() - 1) {
                vPager2.setCurrentItem(0);
            } else {
                vPager2.setCurrentItem(vPager2.getCurrentItem() + 1);
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ci3vp2, container, false);

        vPager2 = view.findViewById(R.id.vPager2);
        crcInd3 = view.findViewById(R.id.crcInd3);
        imgs = getImages();

        ImgViewPager2Adapter imgViewPager2Adapter = new ImgViewPager2Adapter(imgs);
        vPager2.setAdapter(imgViewPager2Adapter);
        crcInd3.setViewPager(vPager2);

        vPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                Handler handler = new Handler();
                handler.removeCallbacks(runnable());
                handler.postDelayed(runnable(), 3000);
            }
        });

        //vPager2.setPageTransformer(new ZoomOutPageTransformer());
        vPager2.setPageTransformer(new DepthPageTransformer());

        return view;
    }

    private ArrayList<ImageModel> getImages() {
        ArrayList<ImageModel> imgs = new ArrayList<>();
        imgs.add(new ImageModel(R.drawable.pic1));
        imgs.add(new ImageModel(R.drawable.pic2));
        imgs.add(new ImageModel(R.drawable.pic3));
        imgs.add(new ImageModel(R.drawable.pic4));
        imgs.add(new ImageModel(R.drawable.pic5));

        return imgs;
    }

    public class ZoomOutPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.85f;
        private static final float MIN_ALPHA = 0.5f;

        @Override
        public void transformPage(@NonNull View page, float position) {
            int pageWidth = page.getWidth();
            int pageHeight = page.getHeight();
            if (position < -1) {            // (inf; -1) this page is off-screen to the left
                page.setAlpha(0f);
            } else if (position <= 1) {     // [-1; 1] modify the default slide transition to shrink the page as well
                float scaleFactor = Math.max(MIN_SCALE, 1-Math.abs(position));
                float vertMargin = pageHeight * (1-scaleFactor) / 2;
                float horzMargin = pageWidth * (1-scaleFactor) / 2;
                if (position <= 0) {
                    page.setTranslationX(horzMargin - vertMargin/2);
                } else {
                    page.setTranslationX(-horzMargin + vertMargin/2);
                }
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            } else {                        // (1; inf) this page is off-screen to the right
                page.setAlpha(0f);
            }
        }
    }

    public class DepthPageTransformer implements ViewPager2.PageTransformer {
        private static final float MIN_SCALE = 0.75f;

        @Override
        public void transformPage(@NonNull View page, float position) {
            int pageWidth = page.getWidth();
            if (position < -1) {            // (inf; -1) this page is off-screen to the left
                page.setAlpha(0f);
            } else if (position <= 0) {     // [-1; 0] set default transition when moving to the left page
                page.setAlpha(1f);
                page.setTranslationX(0f);
                page.setTranslationZ(0f);
                page.setScaleX(1f);
                page.setScaleY(1f);
            } else if (position <= 1) {     // [0; 1]
                // fade the page out
                page.setAlpha(1 - position);
                // counteract the default slide transition
                page.setTranslationX(pageWidth * -position);
                // move it behind the left page
                page.setTranslationZ(-1f);
                // scale the page down (between MIN_SCALE and 1)
                float scaleFactor = MIN_SCALE + (1-MIN_SCALE)*(1-Math.abs(position));
                page.setScaleX(scaleFactor);
                page.setScaleY(scaleFactor);
            } else {                        // (1; inf) this page is off-screen to the right
                page.setAlpha(0f);
            }
        }
    }
}