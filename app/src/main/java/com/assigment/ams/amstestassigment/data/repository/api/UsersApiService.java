package com.assigment.ams.amstestassigment.data.repository.api;

import com.assigment.ams.amstestassigment.data.model.Response.GetUserResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * Created by truerall on 12/27/17.
 */

public interface UsersApiService {

    @GET("demo/users")
    Single<GetUserResponse> getUsers();
}
