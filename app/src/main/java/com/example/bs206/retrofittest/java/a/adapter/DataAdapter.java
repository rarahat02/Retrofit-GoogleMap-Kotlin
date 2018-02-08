package com.example.bs206.retrofittest.java.a.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bs206.retrofittest.java.a.model.Data;

import com.example.bs206.retrofittest.R;

import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.DataViewHolder>
{

    private List<Data> datas;
    private int rowLayout;
    private Context context;


    public static class DataViewHolder extends RecyclerView.ViewHolder
    {
        TextView sl;
        TextView district;
        TextView address;


        public DataViewHolder(View v)
        {
            super(v);
            sl = v.findViewById(R.id.sl);
            district = v.findViewById(R.id.district);
            address =  v.findViewById(R.id.address);
        }


    }

    public DataAdapter(List<Data> datas, int rowLayout, Context context) {
        this.datas = datas;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public DataAdapter.DataViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new DataViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position)
    {
        holder.sl.setText(datas.get(position).getSlNum().toString());
        holder.district.setText(datas.get(position).getDistrict());
        holder.address.setText(datas.get(position).getAddress());

    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}