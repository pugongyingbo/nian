package com.it.zzb.nian;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.List;

/**
 * Created by zzb on 2017/12/30.
 */

public class OneAdapter extends RecyclerView.Adapter<OneAdapter.ViewHolder> {

    private Context context;

    private List<String> dataList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView) view;
            textView = view.findViewById(R.id.info);
        }
    }
    public OneAdapter(List<String> data){
        dataList = data;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context == null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String oneData = dataList.get(position);
        holder.textView.setText(oneData);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
