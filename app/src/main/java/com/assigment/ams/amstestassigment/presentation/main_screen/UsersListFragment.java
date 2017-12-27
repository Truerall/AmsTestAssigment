package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assigment.ams.amstestassigment.App;
import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UsersListFragment extends Fragment {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    @BindView(R.id.swr_users)
    SwipeRefreshLayout swrUsers;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject UsersRepository repository;

    private Unbinder unbinder; //TODO move to super

    public UsersListFragment() {
    }

    public static Fragment newInstance() {
        return new UsersListFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        App.getInstance().getAppComponent().inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        repository.printImReady();
        Utils.DBG("onCreateView log works fine");
        return view;
    }

    //TODO move to super
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
