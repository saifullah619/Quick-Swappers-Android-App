package com.saifullahdar.assignment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRVAdapter extends RecyclerView.Adapter<MyRVAdapter.MyViewHolder>  {

    List<Add> adds;
    Context c;

    public MyRVAdapter(List<Add> adds, Context c){
        this.c = c ;
        this.adds = adds;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflator = LayoutInflater.from(parent.getContext());
        View obj = inflator.inflate(R.layout.card,parent,false);
        return new MyViewHolder(obj);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder,int position) {
        holder.name.setText(adds.get(holder.getAdapterPosition()).getProduct_name());
        holder.image.setImageDrawable(adds.get(holder.getAdapterPosition()).getImage());
        holder.location.setText(adds.get(holder.getAdapterPosition()).getLocation());
        holder.price.setText(adds.get(holder.getAdapterPosition()).getPrice());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(c, screen10.class);
                Bitmap bmp = ((BitmapDrawable)(adds.get(holder.getAdapterPosition()).getImage())).getBitmap();

                i.putExtra("Name", adds.get(holder.getAdapterPosition()).getProduct_name());
                i.putExtra("Location", adds.get(holder.getAdapterPosition()).getLocation());
                i.putExtra("Price", adds.get(holder.getAdapterPosition()).getPrice());
                i.putExtra("Description", adds.get(holder.getAdapterPosition()).getDescription());
                i.putExtra("Image", bmp);
                c.startActivity(i);
            }
        });

        holder.view.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Intent i = new Intent(c, screen9.class);
                i.putExtra("Position", holder.getAdapterPosition());
                ((Activity) c).startActivityForResult(i, 9);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return adds.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,price,location;
        View view;
        public MyViewHolder(@NonNull View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.addName) ;
            price = itemView.findViewById(R.id.addPrice);
            location = itemView.findViewById(R.id.addLoc);
            image = itemView.findViewById(R.id.addImg);
            view = itemView;
        }

    }
}
