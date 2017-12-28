package com.assigment.ams.amstestassigment.presentation;

/**
 * Created by truerall on 12/28/17.
 */

public interface BasePresenter<T extends BaseView> {

    void start(T view);

    void stop();

    void getData();

}
