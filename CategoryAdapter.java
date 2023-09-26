package com.example.fooddelimain;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private final ArrayList<CategoryItem> mExampleList;

    @NonNull
    @NotNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_image,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CategoryAdapter.CategoryViewHolder holder, int position) {
        CategoryItem currentItem = mExampleList.get(position);
        holder.mCategoryImage.setImageResource(currentItem.getImageResource());
        holder.mText1.setText(currentItem.getText1());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

    public CategoryAdapter(ArrayList<CategoryItem> exampleList){
        mExampleList = exampleList;
    }


    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        public ImageView mCategoryImage;
        public TextView mText1;
        public CategoryViewHolder(View view) {
            super(view);
            mCategoryImage = view.findViewById(R.id.category_image);
            mText1 = view.findViewById(R.id.category_foodname);

        }
    }
}
