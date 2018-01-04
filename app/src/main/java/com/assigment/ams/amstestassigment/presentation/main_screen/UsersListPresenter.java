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
    private DisposableSingleObserver<List<User>> observer;

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
        if (view.isAvailable()) view.showProgress();
        if (observer == null || observer.isDisposed()) {
            getUsersUseCase.executeUseCase(getDataObserver(), false);
        }
    }

    void deleteUser(@NonNull User user) {
        removeUserUsecase.executeUseCase(user);
    }

    void refreshUserList() {
        getUsersUseCase.executeUseCase(getDataObserver(), true);
    }

    private DisposableSingleObserver<List<User>> getDataObserver() {
        observer = new DisposableSingleObserver<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                if (view.isAvailable()) view.setData(users);
                observer.dispose();
            }

            @Override
            public void onError(Throwable e) {
                view.onError();
                observer.dispose();
            }
        };
        return observer;
    }
}
