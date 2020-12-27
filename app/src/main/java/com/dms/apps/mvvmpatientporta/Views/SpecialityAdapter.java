package com.dms.apps.mvvmpatientporta.Views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dms.apps.mvvmpatientporta.Model.SpecialityModel;
import com.dms.apps.mvvmpatientporta.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SpecialityAdapter extends RecyclerView.Adapter<SpecialityAdapter.MyViewHolder> {
    private Context context;
    private List<SpecialityModel> specialityModels;

    public SpecialityAdapter(Context context, List<SpecialityModel> specialityModels) {
        this.context = context;
        this.specialityModels = specialityModels;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.speciality_layout,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.specTv.setText(specialityModels.get(position).getNameEn());
    }

    @Override
    public int getItemCount() {
        return specialityModels.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView specTv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            specTv = itemView.findViewById(R.id.specTv);
        }
    }
}
