package com.misagani.teslashowcase;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder>
{
    private ArrayList<Tesla> listTesla;
    private Context context;

    CardViewAdapter(Context context)
    {
        this.context = context;
    }

    private ArrayList<Tesla> getListTesla()
    {
        return listTesla;
    }

    public void setListTesla(ArrayList<Tesla> listTesla)
    {
        this.listTesla = listTesla;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewViewHolder holder, int position)
    {
        Tesla p = getListTesla().get(position);

        Target<GlideDrawable> into = Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnShare.setOnClickListener(new CustomOnItemClickListener(position, new CustomOnItemClickListener.OnItemClickCallback()
        {
            @Override
            public void onItemClicked(View view, int position)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, "Let's buying some Tesla!");
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Share To"));
            }
        }));
    }

    @Override
    public int getItemCount()
    {
        return getListTesla().size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgPhoto;
        TextView tvName, tvRemarks;
        Button btnShare;
        CardViewViewHolder(View itemView)
        {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }

    public static class CustomOnItemClickListener implements View.OnClickListener
    {
        private int position;
        private OnItemClickCallback onItemClickCallback;
        CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback)
        {
            this.position = position;
            this.onItemClickCallback = onItemClickCallback;
        }

        @Override
        public void onClick(View view)
        {
            onItemClickCallback.onItemClicked(view, position);
        }

        public interface OnItemClickCallback
        {
            void onItemClicked(View view, int position);
        }
    }
}