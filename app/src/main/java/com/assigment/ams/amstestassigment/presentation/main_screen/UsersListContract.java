package com.assigment.ams.amstestassigment.presentation.main_screen;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.BasePresenter;
import com.assigment.ams.amstestassigment.presentation.BaseView;

import java.util.List;

/**
 * Created by truerall on 12/28/17.
 */

public interface UsersListContract {
    interface View extends BaseView<List<User>> {

    }

    interface Presenter extends BasePresenter<View> {

    }
}
