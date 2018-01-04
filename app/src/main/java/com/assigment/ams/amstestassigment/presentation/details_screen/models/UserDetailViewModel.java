package com.assigment.ams.amstestassigment.presentation.details_screen.models;

/**
 * Created by truerall on 1/4/18.
 */

public class UserDetailViewModel {
    private final String label;
    private final String data;

    public UserDetailViewModel(String label, String data) {
        this.label = label;
        this.data = data;
    }

    public String getLabel() {
        return label;
    }

    public String getData() {
        return data;
    }
}
