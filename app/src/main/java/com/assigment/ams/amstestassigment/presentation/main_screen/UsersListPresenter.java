package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.support.annotation.NonNull;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.domain.use_case.main_screen.GetUsersUseCase;
import com.assigment.ams.amstestassigment.domain.use_case.main_screen.RemoveUserUseCase;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by truerall on 12/28/17.
 */

public class UsersListPresenter implements UsersListContract.Presenter {

    private GetUsersUseCase getUsersUseCase;
    private RemoveUserUseCase removeUserUsecase;
    private UsersListContract.View view;

    public UsersListPresenter(GetUsersUseCase getUsersUseCase, RemoveUserUseCase removeUserUsecase) {
        this.getUsersUseCase = getUsersUseCase;
        this.removeUserUsecase = removeUserUsecase;
    }

    public void start(@NonNull UsersListContract.View view) {
        this.view = view;
        getData();
    }

    public void stop() {
        this.view = null;
    }

    @Override
    public void getData() {
        view.showProgress();
        getUsersUseCase.executeUseCase(getDataObserver(), false);
    }

    void deleteUser(@NonNull User user) {
        removeUserUsecase.executeUseCase(user);
    }

    void refreshUserList() {
        getUsersUseCase.executeUseCase(getDataObserver(), true);
    }

    private DisposableSingleObserver<List<User>> getDataObserver() {
        return new DisposableSingleObserver<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                // check if view updatable after on pause
                //TODO isAttached ? possible - view null
                // Make super class, thar will setFlag - retained if null. on start will check flag/flags and show results
                view.setData(users);
                view.hideProgress();
            }

            @Override
            public void onError(Throwable e) {
                //TODO Error handling layer
                view.onError();
            }
        };
    }
}
