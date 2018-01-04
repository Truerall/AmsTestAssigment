package com.assigment.ams.amstestassigment.domain.use_case.details_screen;

import android.support.annotation.NonNull;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.observers.DisposableSingleObserver;

/** Created by truerall on 1/4/18.
 */

public class GetUserDetailsUseCase {
    private UsersRepository usersRepository;

    @Inject
    public GetUserDetailsUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public User executeUseCase(int userId) {
        return usersRepository.getUserById(userId);
    }
}
