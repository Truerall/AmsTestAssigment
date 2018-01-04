package com.assigment.ams.amstestassigment.presentation.details_screen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListFragment;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentByTag(UsersListFragment.class.getSimpleName());
        if (fragment == null) {
            fragment = UsersListFragment.newInstance();
            FragmentTransaction transaction = fm.beginTransaction();
            transaction.add(R.id.container, fragment, UsersListFragment.class.getSimpleName()).commit();
        }
    }
}
