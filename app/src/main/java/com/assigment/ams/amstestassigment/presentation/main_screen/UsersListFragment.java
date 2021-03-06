package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assigment.ams.amstestassigment.App;
import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.di.main_screen.MainScreenComponent;
import com.assigment.ams.amstestassigment.di.main_screen.MainScreenModule;
import com.assigment.ams.amstestassigment.presentation.common.BasePresenterFragment;
import com.assigment.ams.amstestassigment.presentation.details_screen.UserDetailsActivity;
import com.assigment.ams.amstestassigment.presentation.main_screen.listener.ItemAdapterListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UsersListFragment extends BasePresenterFragment<UsersListPresenter> implements UsersListContract.View, ItemAdapterListener<User>, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    @BindView(R.id.swr_users)
    SwipeRefreshLayout swrUsers;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    MainScreenComponent mainScreenComponent;

    private UsersListAdapter adapter;

    public static Fragment newInstance() {
        return new UsersListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new UsersListAdapter(this);
        mainScreenComponent = App.getInstance().getAppComponent().plus(new MainScreenModule());
        mainScreenComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        attachUnbinder(ButterKnife.bind(this, view));
        initRecycleView();
        swrUsers.setOnRefreshListener(this);
        return view;
    }

    private void initRecycleView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(@NonNull List<User> data) {
        hideProgress();
        if (data.isEmpty()) showEmptyState();
        if (swrUsers.isRefreshing()) swrUsers.setRefreshing(false);
        adapter.setData(data);
    }

    @Override
    public void onItemShowDetails(User user) {
        Intent intent = new Intent(getActivity(), UserDetailsActivity.class);
        int id = user.getUserID();
        intent.putExtra(UserDetailsActivity.KEY_USER_ID, id);
        startActivity(intent);
    }

    @Override
    public void onItemDelete(User user, int position) {
        getPresenter().deleteUser(user);
        adapter.notifyItemRemoved(position);
        if (adapter.isDataSetEmpty()) {
            showEmptyState();
        }
    }

    @Override
    public void onRefresh() {
        getPresenter().refreshUserList();
        showProgress();
        swrUsers.setRefreshing(false);
    }

    @Override
    public void onError() {
        super.onError();
        if (swrUsers.isRefreshing()) swrUsers.setRefreshing(false);
    }
}
