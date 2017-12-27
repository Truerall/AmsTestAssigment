package com.assigment.ams.amstestassigment.data.repository.repositories;

import com.assigment.ams.amstestassigment.data.model.Response.GetUserResponse;
import com.assigment.ams.amstestassigment.utils.Utils;
import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;

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
        this.apiService = apiService;
        usersList = new ArrayList<>();
        Single<GetUserResponse> single = apiService.getUsers();

        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new DisposableSingleObserver<GetUserResponse>() {
                @Override
                public void onSuccess(GetUserResponse response) {

                    for (User user: response.getUsersArrayList()) {
                        Utils.DBG(user.toString());
                    }
                }

                @Override
                public void onError(Throwable e) {
                    Utils.DBG("Error "+e.getMessage());
                }
            });


        //TODO usersList

    }

    public void printImReady(){
        Utils.DBG("Repository is ready ");
    }
}
