package com.assigment.ams.amstestassigment.di;

import com.assigment.ams.amstestassigment.App;
import com.assigment.ams.amstestassigment.di.main_screen.MainScreenComponent;
import com.assigment.ams.amstestassigment.di.main_screen.MainScreenModule;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by truerall on 12/27/17.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    MainScreenComponent plus(MainScreenModule mainScreenModule);

    void inject(App app);

    void inject(UsersListActivity usersListActivity);
}
