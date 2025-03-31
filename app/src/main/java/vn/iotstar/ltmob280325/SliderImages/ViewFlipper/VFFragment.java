package vn.iotstar.ltmob280325.SliderImages.ViewFlipper;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import vn.iotstar.ltmob280325.R;

public class VFFragment extends Fragment {
    ViewFlipper vFlipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vf, container, false);

        vFlipper = view.findViewById(R.id.vFlipper);

        return view;
    }

    private void vFlipperAction() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("http://app.iotstar.vn:8081/appfoods/flipper/quangcao.png");
        strings.add("http://app.iotstar.vn:8081/appfoods/flipper/coffe.jpg");
        strings.add("http://app.iotstar.vn:8081/appfoods/flipper/companypizza.jpeg");
        strings.add("http://app.iotstar.vn:8081/appfoods/flipper/themoingon.jpeg");

        int count = strings.size();
        for (int i = 0; i < count; i++) {
            ImageView imageView = new ImageView(getContext());
            Glide.with(requireContext()).load(strings.get(i)).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            vFlipper.addView(imageView);
        }
        vFlipper.setFlipInterval(3000);
        vFlipper.setAutoStart(true);

        Animation slide_in_right = AnimationUtils.loadAnimation(getContext(), R.anim.slide_in_right);
        Animation slide_out_right = AnimationUtils.loadAnimation(getContext(), R.anim.slide_out_right);
        vFlipper.setInAnimation(slide_in_right);
        vFlipper.setOutAnimation(slide_out_right);
    }
}