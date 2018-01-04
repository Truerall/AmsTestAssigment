package com.assigment.ams.amstestassigment.presentation.common;

/**
 * Created by truerall on 1/3/18.
 */

public class BaseContract {

    public interface BaseView {

        void onError();

        void showEmptyState();

        void showProgress();
    }


    public interface BasePresenter<V> {

        void start(V view);

        void stop();

        void getData();

    }
}
