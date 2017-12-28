package com.assigment.ams.amstestassigment.di.main_screen;

import com.assigment.ams.amstestassigment.di.scope.FragmentScope;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListFragment;

import dagger.Subcomponent;

/**
 * Created by truerall on 12/28/17.
 */
@Subcomponent(modules = {MainScreenModule.class})
@FragmentScope
public interface MainScreenComponent {

    void inject(UsersListFragment usersListFragment);

}
