package com.assigment.ams.amstestassigment.presentation.details_screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.assigment.ams.amstestassigment.R;

public class UserDetailsActivity extends AppCompatActivity {
    public static final String KEY_USER_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(UserDetailsFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = UserDetailsFragment.newInstance(getUserId());
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.container, fragment, UserDetailsFragment.class.getSimpleName()).commit();
        }
    }

    private int getUserId() {
        if (getIntent().getExtras() != null) {
            return getIntent().getIntExtra(KEY_USER_ID, -1);
        }
        return -1;
    }
}
