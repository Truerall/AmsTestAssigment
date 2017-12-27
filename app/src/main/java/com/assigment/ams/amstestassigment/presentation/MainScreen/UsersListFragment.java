package com.assigment.ams.amstestassigment.presentation.MainScreen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.assigment.ams.amstestassigment.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class UsersListFragment extends Fragment {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;
    @BindView(R.id.swr_users)
    SwipeRefreshLayout swrUsers;

    private Unbinder unbinder; //TODO move to super

    public UsersListFragment() {
    }

    public static Fragment newInstance() {
        return new UsersListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list_main, container, false);
        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    //TODO move to super
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
