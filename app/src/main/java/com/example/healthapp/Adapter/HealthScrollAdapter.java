package com.example.healthapp.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthapp.Model.HealthScroll;
import com.example.healthapp.R;

import java.util.List;

public class HealthScrollAdapter extends RecyclerView.Adapter<HealthScrollAdapter.HealthViewHolder> {
    private List<HealthScroll> healthScrollList;
    public HealthScrollAdapter(List<HealthScroll> healthScrollList){
this.healthScrollList=healthScrollList;
    }
    @NonNull
    @Override
    public HealthViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.healthitem_layout,parent,false);
        return new HealthViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull HealthViewHolder holder, int position) {
        holder.image.setImageResource(healthScrollList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return healthScrollList.size();
    }

    public class HealthViewHolder extends RecyclerView.ViewHolder{
        private ImageView image;
        public HealthViewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.image_scr);

        }
    }
}
