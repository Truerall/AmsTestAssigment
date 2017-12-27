package com.assigment.ams.amstestassigment;

import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListActivity;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListFragment;

import javax.inject.Singleton;

import dagger.Component;

/** Created by truerall on 12/27/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(App app);

    void inject(UsersListActivity usersListActivity);

    void inject(UsersListFragment userListFragment);
}
