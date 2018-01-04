package com.assigment.ams.amstestassigment.presentation.details_screen;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.presentation.details_screen.models.UserDetailViewModel;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by truerall on 12/27/17.
 */

public class UserDetailsAdapter extends RecyclerView.Adapter<UserDetailsAdapter.ViewHolder> {
    private List<UserDetailViewModel> mDataSet;

    public void addData(List<UserDetailViewModel> mDataSet) {
        this.mDataSet.addAll(mDataSet);
        notifyDataSetChanged();
    }

    public void setData(List<UserDetailViewModel> mDataSet) {
        this.mDataSet = mDataSet;
        notifyDataSetChanged();
    }

    @Override
    public UserDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail_pair, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final UserDetailViewModel user = mDataSet.get(position);

        holder.tvLabel.setText(user.getLabel());
        holder.tvData.setText(user.getData());
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_label)
        AppCompatTextView tvLabel;
        @BindView(R.id.tv_data)
        AppCompatTextView tvData;

        ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }
    }
}


