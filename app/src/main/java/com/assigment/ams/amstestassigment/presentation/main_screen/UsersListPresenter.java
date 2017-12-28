package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.support.annotation.NonNull;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.List;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by truerall on 12/28/17.
 */

public class UsersListPresenter implements UsersListContract.Presenter {

    private UsersRepository usersRepository;
    private UsersListContract.View view;

    public UsersListPresenter(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
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
        usersRepository.getUsersList(new DisposableSingleObserver<List<User>>() {
            @Override
            public void onSuccess(List<User> users) {
                // check if view updatable after on pause
                //TODO isAttached ? possible - view null
                // Make super class, thar will setFlag - retained if null. on start will check flag/flags and show results
                view.setData(users);
                Utils.DBG("Users size >>> "+ users.size());
            }

            @Override
            public void onError(Throwable e) {
                view.onError();
            }
        });
    }

    void deleteUser(User user){
        usersRepository.removeUserById(user.getUserID());
        usersRepository.printListSize();
    }
}
