package vn.iotstar.ltmob280325.SliderImages.CircleIndicator3_ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import vn.iotstar.ltmob280325.R;
import vn.iotstar.ltmob280325.SliderImages.ImageModel;

public class ImgViewPager2Adapter extends RecyclerView.Adapter<ImgViewPager2Adapter.ImgViewHolder> {
    private ArrayList<ImageModel> imgs;

    public ImgViewPager2Adapter(ArrayList<ImageModel> imgs) {
        this.imgs = imgs;
    }

    public class ImgViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;

        public ImgViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.img);
        }
    }

    @NonNull
    @Override
    public ImgViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ImgViewHolder holder, int position) {
        ImageModel img = imgs.get(position);
        if (img != null) holder.img.setImageResource(img.getImgId());
    }

    @Override
    public int getItemCount() {
        return imgs != null? imgs.size() : 0;
    }
}
