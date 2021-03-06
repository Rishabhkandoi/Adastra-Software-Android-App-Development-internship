package com.example.hp.chhabras.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hp.chhabras.Model.Dialog_select_outlet_structure;
import com.example.hp.chhabras.R;
import com.example.hp.chhabras.Util.CustomItemClickListener;

import java.util.List;

/**
 * Created by hp on 26-06-2018.
 */

public class Dialog_select_outlet_adapter extends RecyclerView.Adapter<Dialog_select_outlet_adapter.MyViewHolder> {

    private List<Dialog_select_outlet_structure> moreList;
    private Context context;
    public int mSelectedItem = -1;
    CustomItemClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView area_name, area_address;
        public RadioButton radio_select_outlet;

        public MyViewHolder(View view) {
            super(view);
            context = itemView.getContext();
            area_name = (TextView) view.findViewById(R.id.area_name);
            area_address = (TextView) view.findViewById(R.id.area_address);
            radio_select_outlet = (RadioButton) view.findViewById(R.id.radio_select_outlet);

            View.OnClickListener clickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyDataSetChanged();

                    listener.onClick(moreList.get(mSelectedItem).getAreaAddress());
                }
            };
            itemView.setOnClickListener(clickListener);
            radio_select_outlet.setOnClickListener(clickListener);
        }
    }

    public void setClickListener(CustomItemClickListener itemClickListener) {
        this.listener = itemClickListener;
    }

    public Dialog_select_outlet_adapter(Context mContext, List<Dialog_select_outlet_structure> moreList) {
        this.moreList = moreList;
        this.context = mContext;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dialog_select_outlet_structure, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Dialog_select_outlet_structure members = moreList.get(position);
        holder.area_name.setText(members.getAreaName());
        holder.area_address.setText(members.getAreaAddress());
        holder.radio_select_outlet.setChecked(position == mSelectedItem);
    }

    @Override
    public int getItemCount() {
        return moreList.size();
    }
}