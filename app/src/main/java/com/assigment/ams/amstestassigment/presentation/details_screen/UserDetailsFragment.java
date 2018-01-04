package com.assigment.ams.amstestassigment.presentation.details_screen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.assigment.ams.amstestassigment.App;
import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.di.details_screen.DetailsScreenComponent;
import com.assigment.ams.amstestassigment.di.details_screen.DetailsScreenModule;
import com.assigment.ams.amstestassigment.presentation.common.BasePresenterFragment;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserDetailsFragment extends BasePresenterFragment<UserDetailsPresenter> implements UserDetailsContract.View {

    @BindView(R.id.rv_main)
    RecyclerView recyclerView;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    DetailsScreenComponent detailsScreenComponent;

    private UsersListAdapter adapter;

    public static Fragment newInstance(int userId) {
        Fragment frg = new UserDetailsFragment();
        Bundle args = new Bundle();
        args.putInt(UserDetailsActivity.KEY_USER_ID, userId);
        frg.setArguments(args);
        return frg;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //adapter = new UsersListAdapter(this);
        detailsScreenComponent = App.getInstance().getAppComponent().plus(new DetailsScreenModule());
        detailsScreenComponent.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_details, container, false);
        attachUnbinder(ButterKnife.bind(this, view));
        //initRecycleView();
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        int currentUserId = -1;
        if (getArguments() != null) {
            currentUserId = (int) getArguments().get(UserDetailsActivity.KEY_USER_ID);
        }
        getPresenter().getData(currentUserId);
    }

    private void initRecycleView() {
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void setData(@NonNull User user) {
        hideProgress();
        Toast.makeText(getActivity(), "User got> " + user.getFirstName(), Toast.LENGTH_SHORT).show();
        // TODO mego mapping
        //adapter.setData(data);
    }
}
