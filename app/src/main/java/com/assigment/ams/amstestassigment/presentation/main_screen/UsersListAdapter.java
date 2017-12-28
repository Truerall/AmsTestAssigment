package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.main_screen.listener.InnerViewHolderClickListener;
import com.assigment.ams.amstestassigment.presentation.main_screen.listener.ItemAdapterListener;
import com.assigment.ams.amstestassigment.utils.Utils;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * Created by truerall on 12/27/17.
 */

public class UsersListAdapter extends RecyclerView.Adapter<UsersListAdapter.ViewHolder> implements InnerViewHolderClickListener {
    private List<User> mDataSet;
    private ItemAdapterListener<User> itemAdapterListener;


    UsersListAdapter(ItemAdapterListener<User> itemAdapterListener) {
        this.mDataSet = new ArrayList<>();
        this.itemAdapterListener = itemAdapterListener;
    }

    public void addData(List<User> mDataSet){
        this.mDataSet.addAll(mDataSet);
        notifyDataSetChanged();
    }

    public void setData(List<User> mDataSet){
        this.mDataSet = mDataSet;
        notifyDataSetChanged();
    }
    @Override
    public UsersListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_users_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.setItemAdapterListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final User user = mDataSet.get(position);

        Glide.with(holder.ivAvatar.getContext()).load(user.getImgUrl()).into(holder.ivAvatar);

        holder.tvFirstName.setText(user.getFirstName());
        holder.tvLastName.setText(user.getLastName());

        holder.ivDelete.setOnClickListener(holder);
        holder.cvContainer.setOnClickListener(holder);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    @Override
    public void onClick(int id, int position) {
        switch (id){
            case NO_POSITION:
                break;
            case R.id.cv_container:
                Utils.DBG("click details at position "+position);
                itemAdapterListener.onItemShowDetails(mDataSet.get(position));
                break;
            case R.id.iv_delete_user:
                Utils.DBG("click DELETE at position "+position);
                itemAdapterListener.onItemDelete(mDataSet.get(position), position);
                break;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.cv_container) CardView cvContainer;
        @BindView(R.id.iv_avatar) AppCompatImageView ivAvatar;
        @BindView(R.id.tv_first_name) TextView tvFirstName;
        @BindView(R.id.tv_last_name) TextView tvLastName;
        @BindView(R.id.iv_delete_user) AppCompatImageView ivDelete;

        InnerViewHolderClickListener innerViewHolderClickListener;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this,v);
        }

        void setItemAdapterListener(InnerViewHolderClickListener innerViewHolderClickListener){
            this.innerViewHolderClickListener = innerViewHolderClickListener;
        };

        @Override
        public void onClick(View v) {
            innerViewHolderClickListener.onClick(v.getId(), getAdapterPosition());
        }
    }

}


