package com.techadvisor.techadvisor.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.techadvisor.techadvisor.POJO.SmartPhone;
import com.techadvisor.techadvisor.POJO.WeightedSmartPhone;
import com.techadvisor.techadvisor.R;

import java.util.ArrayList;


/**
 * Created by test on 10/14/2018.
 */

public class SmartphoneRecyclerAdapter extends RecyclerView.Adapter<SmartphoneRecyclerAdapter.ListViewHolder> {

    Context context;
   ArrayList<WeightedSmartPhone> smartPhones;


    public SmartphoneRecyclerAdapter(Context context, ArrayList<WeightedSmartPhone> smartPhones) {
        this.context = context;
        this.smartPhones = smartPhones;
    }

    @Override

    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.smartphonerecyclerlayout,parent,false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        WeightedSmartPhone smartPhone = smartPhones.get(position);
        holder.tvTitle.setText(smartPhone.getName());
        holder.tvPrice.setText(smartPhone.getPrice().toString());


    }

    @Override
    public int getItemCount() {
        return smartPhones.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        View mainView;
        ImageView ivPhoto;
        TextView tvPrice,tvTitle;
        public ListViewHolder(View itemView) {
            super(itemView);
            mainView = itemView;
            ivPhoto = (ImageView) itemView.findViewById(R.id.iv_smartImageview);
            tvPrice = (TextView) itemView.findViewById(R.id.tv_price);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_smartName);
        }
    }
}
