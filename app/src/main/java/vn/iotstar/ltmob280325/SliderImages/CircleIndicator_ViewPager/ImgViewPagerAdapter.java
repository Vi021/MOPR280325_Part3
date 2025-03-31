package vn.iotstar.ltmob280325.SliderImages.CircleIndicator_ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.SliderImages.ImageModel;

public class ImgViewPagerAdapter extends PagerAdapter {
    private ArrayList<ImageModel> imgs;

    public ImgViewPagerAdapter(ArrayList<ImageModel> imgs) {
        this.imgs = imgs;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_image, container, false);
        ImageView img = view.findViewById(R.id.img);
        img.setImageResource(imgs.get(position).getImgId());
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public int getCount() {
        return imgs != null? imgs.size() : 0;
    }
}
