package com.assigment.ams.amstestassigment.presentation.details_screen;

import android.support.annotation.NonNull;

import com.assigment.ams.amstestassigment.domain.use_case.details_screen.GetUserDetailsUseCase;

/**
 * Created by truerall on 12/28/17.
 */

public class UserDetailsPresenter implements UserDetailsContract.Presenter {

    private GetUserDetailsUseCase getUserDetailsUseCase;
    private UserDetailsContract.View view;

    public UserDetailsPresenter(GetUserDetailsUseCase getUserDetailsUseCase) {
        this.getUserDetailsUseCase = getUserDetailsUseCase;
    }

    public void start(@NonNull UserDetailsContract.View view) {
        this.view = view;
    }

    public void stop() {
        this.view = null;
    }

    @Override
    public void getData(int id) {
        if (id == -1) view.onError();
        view.showProgress();
        view.setData(getUserDetailsUseCase.executeUseCase(id));
    }
}
