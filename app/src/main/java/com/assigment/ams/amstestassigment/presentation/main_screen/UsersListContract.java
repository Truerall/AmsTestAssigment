package com.assigment.ams.amstestassigment.presentation.main_screen;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.common.BaseContract;
import com.assigment.ams.amstestassigment.presentation.common.BaseDataView;

import java.util.List;

/**
 * Created by truerall on 12/28/17.
 */

public interface UsersListContract {
    interface View extends BaseDataView<List<User>> {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getData();
    }
}
