package com.assigment.ams.amstestassigment.di.details_screen;

import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.assigment.ams.amstestassigment.di.scope.FragmentScope;
import com.assigment.ams.amstestassigment.domain.use_case.details_screen.GetUserDetailsUseCase;
import com.assigment.ams.amstestassigment.domain.use_case.main_screen.GetUsersUseCase;
import com.assigment.ams.amstestassigment.domain.use_case.main_screen.RemoveUserUseCase;
import com.assigment.ams.amstestassigment.presentation.details_screen.UserDetailsPresenter;
import com.assigment.ams.amstestassigment.presentation.main_screen.UsersListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by truerall on 12/28/17.
 */
@Module
public class DetailsScreenModule {

    @Provides
    @FragmentScope
    UserDetailsPresenter provideUsersListPresenter(GetUserDetailsUseCase getUserDetailsUseCase) {
        return new UserDetailsPresenter(getUserDetailsUseCase);
    }

    @Provides
    @FragmentScope
    GetUserDetailsUseCase provideGetUsersUseCase(UsersRepository usersRepository) {
        return new GetUserDetailsUseCase(usersRepository);
    }
}
