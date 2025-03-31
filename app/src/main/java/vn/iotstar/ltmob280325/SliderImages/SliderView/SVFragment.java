package vn.iotstar.ltmob280325.SliderImages.SliderView;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

import vn.iotstar.ltmob280325.R;

public class SVFragment extends Fragment {
    private SliderView sliderView;
    private ArrayList<Integer> ints;
    private SliderAdapter sliderAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sv, container, false);

        sliderView = view.findViewById(R.id.imageSlider);
        ints = new ArrayList<>();
        ints.add(R.drawable.pic1);
        ints.add(R.drawable.pic2);
        ints.add(R.drawable.pic3);
        ints.add(R.drawable.pic4);
        ints.add(R.drawable.pic5);

        sliderAdapter = new SliderAdapter(getContext(), ints);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_RIGHT);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM);
        sliderView.setIndicatorSelectedColor(getResources().getColor(R.color.red));
        sliderView.setIndicatorUnselectedColor(getResources().getColor(R.color.gray));
        sliderView.startAutoCycle();
        sliderView.setScrollTimeInSec(5);

        return view;
    }
}