package com.misagani.teslashowcase;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class DetailsActivity extends RecyclerView.Adapter<DetailsActivity.CategoryViewHolder>
{
    private Context context;

    private ArrayList<Tesla> getDetailTesla()
    {
        return detailTesla;
    }

    public void setDetailTesla(ArrayList<Tesla> detailTesla)
    {
        this.detailTesla = detailTesla;
    }

    private ArrayList<Tesla>detailTesla;

    DetailsActivity(Context context)
    {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemRow;
        itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_details, parent, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position)
    {
        holder.tvName.setText(getDetailTesla().get(position).getName());
        holder.tvRemarks.setText(getDetailTesla().get(position).getRemarks());
        holder.tvAccel.setText(getDetailTesla().get(position).getAcc());
        holder.tvDetail.setText(getDetailTesla().get(position).getDetails());
        holder.tvRange.setText(getDetailTesla().get(position).getRange());
        holder.tvDrive.setText(getDetailTesla().get(position).getDrive());
        holder.tvSeating.setText(getDetailTesla().get(position).getSeat());

        Glide.with(context)
             .load(getDetailTesla().get(position).getPhoto())
             .override(220, 220)
             .fitCenter()
             .into(holder.imgPhoto);
    }

    @Override
    public int getItemCount()
    {
        return getDetailTesla().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder
    {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        TextView tvAccel;
        TextView tvDetail;
        TextView tvRange;
        TextView tvDrive;
        TextView tvSeating;

        CategoryViewHolder(View itemView)
        {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_detail_name);
            tvRemarks = itemView.findViewById(R.id.tv_detail_remarks);
            imgPhoto = itemView.findViewById(R.id.img_detail_photo);
            tvAccel = itemView.findViewById(R.id.tv_detail_accel);
            tvDetail = itemView.findViewById(R.id.tv_detail_detail);
            tvRange = itemView.findViewById(R.id.tv_detail_range);
            tvDrive = itemView.findViewById(R.id.tv_detail_drive);
            tvSeating = itemView.findViewById(R.id.tv_detail_seating);
        }
    }
}