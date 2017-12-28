package com.assigment.ams.amstestassigment.di.main_screen;

import android.app.Application;

import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.di.scope.FragmentScope;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by truerall on 12/28/17.
 */
@Module
public class MainScreenModule {

    @Provides
    @FragmentScope
    UsersListPresenter provideUsersListPresenter(UsersRepository usersRepository) {
        return new UsersListPresenter(usersRepository);
    }
}
