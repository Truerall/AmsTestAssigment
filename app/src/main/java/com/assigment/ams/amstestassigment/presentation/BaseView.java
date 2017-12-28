package com.assigment.ams.amstestassigment.presentation;

/**
 * Created by truerall on 12/28/17.
 */

public interface BaseView<T> {

    void setData(T data);

    void onError();

    void showEmptyState();

    void showProgress();
}
