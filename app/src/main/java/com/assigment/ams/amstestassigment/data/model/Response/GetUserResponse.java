package com.assigment.ams.amstestassigment.data.model.Response;

import com.assigment.ams.amstestassigment.data.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by truerall on 12/28/17.
 */

public class GetUserResponse {
    @SerializedName("items")
    private final List<User> usersArrayList;

    public GetUserResponse(List<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    public List<User> getUsersArrayList() {
        return usersArrayList;
    }
}
