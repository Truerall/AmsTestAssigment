package com.assigment.ams.amstestassigment.data.repository.api;

import android.database.Observable;

import com.assigment.ams.amstestassigment.data.model.User;

import java.util.ArrayList;

import retrofit2.http.GET;

/**
 * Created by truerall on 12/27/17.
 */

public interface UsersApi { //https://v2.24coms.com:8443/

    @GET("demo/users")
    Observable<ArrayList<User>> getUsers();

    @GET("demo/users/{userId}/picture")
    Observable<String> getPictureByUserId(String userId);
}
