package com.example.duryab.bb.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duryab.bb.R;
import com.example.duryab.bb.UserRegister;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by abc on 1/20/18.
 *
 * @package pk.edu.pucit.mobilecomputing.database.Adapters
 * @project Database
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<UserRegister> userInfos;
    Context context;

    public DataAdapter(Context context, List<UserRegister> userInfos) {
        this.userInfos = userInfos;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.homefeed,parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        UserRegister ui = userInfos.get(position);
        Toast.makeText(context, ""+ui.getEmail(), Toast.LENGTH_SHORT).show();
        holder.blood.setText(ui.getBlood()+"");
        holder.name.setText(ui.getName()+"");
        holder.phone.setText(ui.getPhone()+"");
        holder.addr.setText(ui.getAddress()+"");
       // holder.ll_ui.setBackgroundColor(position%2==1?Color.RED:Color.GREEN);
    }


    @Override
    public int getItemCount() {
        return userInfos.size();
    }


    /**
     * DataAdapter.ViewHolder Class is below It will be used for designing
     * and setting the data entries in the adapter for recyclerview
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView phone;
        public TextView name;
        public TextView blood;
        public TextView addr;
        public LinearLayout ll_ui;

        public ViewHolder(View view) {
            super(view);
            blood = (TextView) view.findViewById(R.id.blood);
            name = (TextView) view.findViewById(R.id.name);
            phone = (TextView) view.findViewById(R.id.phone);
            addr = (TextView) view.findViewById(R.id.Add);
           // ll_ui = (LinearLayout) view.findViewById(R.id.ll_ui_layout);
        }
    }


}
