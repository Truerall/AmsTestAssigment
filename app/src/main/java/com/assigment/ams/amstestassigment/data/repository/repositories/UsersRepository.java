package com.assigment.ams.amstestassigment.data.repository.repositories;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.ArrayList;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by truerall on 12/27/17.
 */

public class UsersRepository {

    private UsersApiService apiService;
    private ArrayList<User> usersList;

    //TODO Repository State

    public UsersRepository(UsersApiService apiService) {
        Utils.DBG("UserRepository constructor called");
        this.apiService = apiService;
        usersList = new ArrayList<>();
        //requestUsersList();
    }

    private Single<ArrayList<User>> requestUsersList(DisposableSingleObserver<ArrayList<User>> observer) {
        Single<ArrayList<User>> single = apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> Single.just(response.getUsersArrayList()));
        single.subscribe(observer);
        return single;
    }

    public Single<ArrayList<User>> getUsersList(DisposableSingleObserver<ArrayList<User>> observer){
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
