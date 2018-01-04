package com.assigment.ams.amstestassigment.domain.use_case;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

/**
 * Created by truerall on 1/4/18.
 */

public class GetUsersUseCase {
    private UsersRepository usersRepository;

    @Inject
    public GetUsersUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void executeUseCase(DisposableSingleObserver<List<User>> disposableSingleObserver, boolean forceUpdate) {
        if (forceUpdate) {
            usersRepository.requestUsersList(disposableSingleObserver);
        } else {
            usersRepository.getUsersList(disposableSingleObserver);
        }
    }
}
