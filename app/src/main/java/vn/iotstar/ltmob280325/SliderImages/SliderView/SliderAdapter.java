package vn.iotstar.ltmob280325.SliderImages.SliderView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

import vn.iotstar.ltmob280325.R;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.SliderHolder> {
    private Context context;
    private ArrayList<Integer> ints;

    public SliderAdapter(Context context, ArrayList<Integer> ints) {
        this.context = context;
        this.ints = ints;
    }

    public class SliderHolder extends SliderViewAdapter.ViewHolder {
        private ImageView img;

        public SliderHolder(View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

    @Override
    public SliderHolder onCreateViewHolder(ViewGroup parent) {
        return new SliderHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(SliderHolder viewHolder, int position) {
        Glide.with(context).load(ints.get(position)).into(viewHolder.img);
    }

    @Override
    public int getCount() {
        return ints != null ? ints.size() : 0;
    }
}
