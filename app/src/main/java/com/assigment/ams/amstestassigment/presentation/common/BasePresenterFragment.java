package com.assigment.ams.amstestassigment.presentation.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;
import android.view.ViewStub;

import com.assigment.ams.amstestassigment.R;

import javax.inject.Inject;

import butterknife.Unbinder;

/**
 * Created by truerall on 1/3/18.
 */

public abstract class BasePresenterFragment<P extends BaseContract.BasePresenter> extends Fragment implements BaseContract.BaseView {

    private Unbinder unbinder;
    private ViewStub vsError;
    private ViewStub vsEmpty;
    private ViewStub vsLoading;
    private int vsErrorId = R.id.vs_error;
    private int vsEmptyId = R.id.vs_empty;
    private int vsLoadingId = R.id.vs_loading;

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
        if (unbinder == null) throw new RuntimeException("Please use attachUnbinder(Undbinder unbinder) in onCreateView before use of fragment to avoid memory leaks");
        initViewStubs(view);
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

    private void initViewStubs(View view){
        vsError = view.findViewById(vsErrorId);
        vsEmpty = view.findViewById(vsEmptyId);
        vsLoading = view.findViewById(vsLoadingId);

        if (vsError == null || vsEmpty == null || vsLoading == null){
            throw new RuntimeException("Please provide state layouts for fragment using setters( aka setErrorViewId(int id) or use default ids for layouts [R.id.vs_error, R.id.vs_empty, R.id.vs_loading])");
        }
    }

    public void setVsErrorId(int vsErrorId) {
        this.vsErrorId = vsErrorId;
    }

    public void setVsEmptyId(int vsEmptyId) {
        this.vsEmptyId = vsEmptyId;
    }

    public void setVsLoadingId(int vsLoadingId) {
        this.vsLoadingId = vsLoadingId;
    }

    @Override
    public void onError() {
        onError(null);
    }

    @Override
    public void onError(String message) {
        vsEmpty.setVisibility(View.GONE);
        vsLoading.setVisibility(View.GONE);

        vsError.setVisibility(View.VISIBLE);
        if(message != null)((AppCompatTextView)vsError.findViewById(R.id.tv_error_message)).setText(message);
    }

    @Override
    public void showEmptyState() {
        showEmptyState(null);
    }

    @Override
    public void showEmptyState(String message) {
        vsError.setVisibility(View.GONE);
        vsLoading.setVisibility(View.GONE);

        vsEmpty.setVisibility(View.VISIBLE);
        if(message != null)((AppCompatTextView)vsEmpty.findViewById(R.id.tv_empty_message)).setText(message);
    }

    @Override
    public void showProgress() {
        vsError.setVisibility(View.GONE);
        vsEmpty.setVisibility(View.GONE);
        vsLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        vsLoading.setVisibility(View.GONE);
    }
}
