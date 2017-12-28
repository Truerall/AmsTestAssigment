package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.os.Bundle;
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
import com.assigment.ams.amstestassigment.presentation.main_screen.listener.ItemAdapterListener;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UsersListFragment extends Fragment implements UsersListContract.View, ItemAdapterListener<User> {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    @BindView(R.id.swr_users)
    SwipeRefreshLayout swrUsers;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    MainScreenComponent mainScreenComponent;

    @Inject UsersListPresenter usersListPresenter;

    private Unbinder unbinder; //TODO move to super
    private UsersListAdapter adapter;

    public UsersListFragment() {
    }

    public static Fragment newInstance() {
        return new UsersListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mainScreenComponent = App.getInstance().getAppComponent().plus(new MainScreenModule());
        mainScreenComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initRecycleView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        usersListPresenter.start(this);
    }

    private void initRecycleView(){
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        adapter = new UsersListAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    //TODO move to super
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        usersListPresenter.stop();
        unbinder.unbind();
    }

    @Override
    public void setData(List<User> data) {
        adapter.setData(data);
    }

    @Override
    public void onError() {

    }

    @Override
    public void showEmptyState() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onItemShowDetails(User item) {
        Utils.DBG("Details of > "+item.getFirstName());
    }

    @Override
    public void onItemDelete(User item) {
        Utils.DBG("Delete the > "+item.getFirstName());
    }
}
