package com.assigment.ams.amstestassigment.di.main_screen;

import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.di.scope.FragmentScope;
import com.assigment.ams.amstestassigment.domain.use_case.GetUsersUseCase;
import com.assigment.ams.amstestassigment.domain.use_case.RemoveUserUseCase;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by truerall on 12/28/17.
 */
@Module
public class MainScreenModule {

    @Provides
    @FragmentScope
    UsersListPresenter provideUsersListPresenter(GetUsersUseCase getUsersUseCase, RemoveUserUseCase removeUserUseCase) {
        return new UsersListPresenter(getUsersUseCase, removeUserUseCase);
    }

    @Provides
    @FragmentScope
    GetUsersUseCase provideGetUsersUseCase(UsersRepository usersRepository) {
        return new GetUsersUseCase(usersRepository);
    }
    @Provides
    @FragmentScope
    RemoveUserUseCase provideRemoveUserUseCase(UsersRepository usersRepository) {
        return new RemoveUserUseCase(usersRepository);
    }
}
