package com.assigment.ams.amstestassigment.data.repository.repositories;

import android.support.annotation.Nullable;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;

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
    }

    public void requestUsersList(DisposableSingleObserver<List<User>> observer) {
        apiService.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(response -> Single.fromCallable(() -> {
                    usersList = response.getUsersArrayList();
                    return response.getUsersArrayList();
                }))
                .map(users -> {
                    Collections.sort(users, (o1, o2) -> o1.getLastName().compareToIgnoreCase(o2.getLastName()));
                    return users;
                })
                .subscribe(observer);
    }

    public void getUsersList(DisposableSingleObserver<List<User>> observer) {
        if (usersList != null) {
            getListFromCache(observer);
        } else {
            requestUsersList(observer);
        }
    }

    private void getListFromCache(DisposableSingleObserver<List<User>> observer) {
        Single.just(usersList).subscribe(observer);
    }

    public void removeUserById(int userId) {
        for (User user : usersList) {
            if (user.getUserID() == userId) {
                usersList.remove(user);
                return;
            }
        }
    }

    @Nullable
    public User getUserById(int userId) {
        for (User user : usersList) {
            if (user.getUserID() == userId) {
                return user;
            }
        }
        return null;
    }
}
