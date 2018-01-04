package com.assigment.ams.amstestassigment.domain.use_case.main_screen;

import android.support.annotation.NonNull;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;

import javax.inject.Inject;

/** Created by truerall on 1/4/18.
 */

public class RemoveUserUseCase {
    private UsersRepository usersRepository;

    @Inject
    public RemoveUserUseCase(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public void executeUseCase(@NonNull User user) {
        usersRepository.removeUserById(user.getUserID());
    }
}
