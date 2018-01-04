package com.assigment.ams.amstestassigment.di.details_screen;

import com.assigment.ams.amstestassigment.di.main_screen.MainScreenModule;
import com.assigment.ams.amstestassigment.di.scope.FragmentScope;
import com.assigment.ams.amstestassigment.presentation.details_screen.UserDetailsFragment;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListFragment;

import dagger.Subcomponent;

/**
 * Created by truerall on 12/28/17.
 */
@Subcomponent(modules = {DetailsScreenModule.class})
@FragmentScope
public interface DetailsScreenComponent {

    void inject(UserDetailsFragment detailsFragment);

}
