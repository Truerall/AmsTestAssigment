package com.assigment.ams.amstestassigment.presentation.main_screen;

import android.view.View;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.ArrayList;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by truerall on 12/28/17.
 */

public class UsersListPresenter {

    private UsersRepository usersRepository;
    private View view;

    public UsersListPresenter(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void start(View view){
        this.view = view;
        getData();
    }

    public void stop(){
        this.view = null;
    }

    private void getData(){
        usersRepository.getUsersList(new DisposableSingleObserver<ArrayList<User>>() {
            @Override
            public void onSuccess(ArrayList<User> users) {
                Utils.DBG("disposable success");
                for(User user: users){
                    Utils.DBG(user.getImgUrl());
                }
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }
}
