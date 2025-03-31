package vn.iotstar.ltmob280325.SliderImages.CircleIndicator_ViewPager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;
import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.SliderImages.ImageModel;

public class CIVPFragment extends Fragment {
    private ViewPager vPager;
    private CircleIndicator crcInd;
    private ArrayList<ImageModel> imgs;

    private Runnable runnable() {
        return () -> {
            if (vPager.getCurrentItem() == imgs.size() - 1) {
                vPager.setCurrentItem(0);
            } else {
                vPager.setCurrentItem(vPager.getCurrentItem() + 1);
            }
        };
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_civp, container, false);

        vPager = view.findViewById(R.id.vPager);
        crcInd = view.findViewById(R.id.crcInd);
        imgs = getImages();

        ImgViewPagerAdapter imgViewPagerAdapter = new ImgViewPagerAdapter(imgs);
        vPager.setAdapter(imgViewPagerAdapter);
        crcInd.setViewPager(vPager);

        Handler handler = new Handler();
        handler.postDelayed(runnable(), 3000);

        vPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

            @Override
            public void onPageSelected(int position) {
                handler.removeCallbacks(runnable());
                handler.postDelayed(runnable(), 3000);
            }

            @Override
            public void onPageScrollStateChanged(int state) { }
        });

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

    @Override
    public void onResume() {
        super.onResume();
        new Handler().postDelayed(runnable(), 3000);
    }

    @Override
    public void onPause() {
        super.onPause();
    }
}