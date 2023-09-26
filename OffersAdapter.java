package com.example.fooddelimain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class OffersAdapter extends RecyclerView.Adapter<OffersAdapter.OffersViewHolder> {
    private final ArrayList<Offers_Item> mExampleList;

    @NonNull
    @NotNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.offers,parent,false);
        return new OffersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull OffersAdapter.OffersViewHolder holder, int position) {
        Offers_Item currentItem = mExampleList.get(position);
        holder.mOffersImage.setImageResource(currentItem.getImageResource());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public OffersAdapter(ArrayList<Offers_Item> exampleList){
        mExampleList = exampleList;
    }


    public static class OffersViewHolder extends RecyclerView.ViewHolder {
        public ImageView mOffersImage;
        public OffersViewHolder(View view) {
            super(view);
            mOffersImage = view.findViewById(R.id.offers_image);

        }
    }
}
