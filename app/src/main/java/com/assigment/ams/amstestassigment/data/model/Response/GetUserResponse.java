package com.assigment.ams.amstestassigment.data.model.Response;

import com.assigment.ams.amstestassigment.data.model.User;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by truerall on 12/28/17.
 */

public class GetUserResponse {
    @SerializedName("items")
    private final ArrayList<User> usersArrayList;

    public GetUserResponse(ArrayList<User> usersArrayList) {
        this.usersArrayList = usersArrayList;
    }

    public ArrayList<User> getUsersArrayList() {
        return usersArrayList;
    }
}
