package com.assigment.ams.amstestassigment.presentation.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

import javax.inject.Inject;

import butterknife.Unbinder;

/**
 * Created by truerall on 1/3/18.
 */

public abstract class BasePresenterFragment<P extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView {

    private Unbinder unbinder;
    @Inject P presenter;

    protected void attachUnbinder(Unbinder unbinder){
        this.unbinder = unbinder;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (unbinder == null) throw new RuntimeException("Please use attachUnbinder(unbinder) in onCreateView before use of fragment to avoid memory leaks");
        presenter.start(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.stop();
        unbinder.unbind();
    }

    public P getPresenter() {
        return presenter;
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

}
