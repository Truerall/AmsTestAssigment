package com.assigment.ams.amstestassigment.data.repository.api;

import com.assigment.ams.amstestassigment.data.model.Response.GetUserResponse;
import com.assigment.ams.amstestassigment.data.model.User;

import java.util.ArrayList;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by truerall on 12/27/17.
 */

public interface UsersApiService { //https://v2.24coms.com:8443/

    @GET("demo/users")
    Single<GetUserResponse> getUsers();

    @GET("demo/users/{userId}/picture")
    Single<String> getPictureByUserId(String userId);
}
