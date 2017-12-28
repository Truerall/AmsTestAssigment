package com.assigment.ams.amstestassigment.data.repository.repositories;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by truerall on 12/27/17.
 */

public class UsersRepository {

    private UsersApiService apiService;
    private List<User> usersList;

    //TODO Repository State

    public UsersRepository(UsersApiService apiService) {
        Utils.DBG("UserRepository constructor called");
        this.apiService = apiService;
        usersList = new ArrayList<>();
        //requestUsersList();
    }

    private Single<List<User>> requestUsersList(DisposableSingleObserver<List<User>> observer) {
        Single<List<User>> single = apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> Single.just(response.getUsersArrayList()));
        single.subscribe(observer);
        return single;
    }

    public Single<List<User>> getUsersList(DisposableSingleObserver<List<User>> observer){
        if(!usersList.isEmpty()) {
            return Single.just(usersList);
        } else {
            return requestUsersList(observer);
        }
    }

    public void printImReady() {
        Utils.DBG("Repository is ready ");
    }

    public void printUsersList() {
        if (usersList == null) {
            Utils.DBG("List is empty");
            return;
        }
        for (User user : usersList) {
            Utils.DBG(user.toString());
        }
    }
}
