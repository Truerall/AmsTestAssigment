package com.assigment.ams.amstestassigment.presentation.details_screen;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.common.BaseContract;
import com.assigment.ams.amstestassigment.presentation.common.BaseDataView;

/**
 * Created by truerall on 12/28/17.
 */

public interface UserDetailsContract {
    interface View extends BaseDataView<User> {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {
        void getData(int id);
    }
}
