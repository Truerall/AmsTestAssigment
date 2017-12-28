package com.assigment.ams.amstestassigment.presentation.main_screen;

import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;

/**
 * Created by truerall on 12/28/17.
 */

public class UsersListPresenter {

    public UsersListPresenter(UsersRepository usersRepository) {
        usersRepository.printImReady();
        usersRepository.printUsersList();
    }
}
