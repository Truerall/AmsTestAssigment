package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.model.User;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by truerall on 12/27/17.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> {
    private List<User> mDataSet;

    public UsersListAdapter() {
        this.mDataSet = new ArrayList<>();
    }

    public void setData(List<User> mDataSet){
        this.mDataSet = mDataSet;
        notifyDataSetChanged();
    }
    @Override
    public UsersListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mDataSet.get(position);
        holder.tvFirstName.setText(user.getFirstName());
        holder.tvLastName.setText(user.getLastName());
        Glide.with(holder.ivAvatar.getContext()).load(user.getImgUrl()).into(holder.ivAvatar);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.iv_avatar) AppCompatImageView ivAvatar;
        @BindView(R.id.tv_first_name) TextView tvFirstName;
        @BindView(R.id.tv_last_name) TextView tvLastName;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }
    }
}


