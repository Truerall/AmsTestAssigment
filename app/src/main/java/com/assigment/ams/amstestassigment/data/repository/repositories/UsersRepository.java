package com.assigment.ams.amstestassigment.data.repository.repositories;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.ArrayList;
import java.util.Collections;
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
        this.apiService = apiService;
        usersList = new ArrayList<>();
    }

    private Single<List<User>> requestUsersList(DisposableSingleObserver<List<User>> observer) {
        Single<List<User>> single = apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> Single.fromCallable(() -> {
                    usersList = response.getUsersArrayList();
                    return response.getUsersArrayList();
                }))
                .map(users -> {
                    Collections.sort(users, (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
                    return users;
                });
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

    public void printListSize() {
        Utils.DBG("Repo Size > "+usersList.size());
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

    public void removeUserById(int userId){
        for(User user: usersList){
            if(user.getUserID() == userId) {
                usersList.remove(user);
                return;
            }
        }
    }
}
