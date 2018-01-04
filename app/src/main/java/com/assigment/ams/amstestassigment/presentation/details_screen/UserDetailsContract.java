package com.assigment.ams.amstestassigment.presentation.details_screen;

import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.ViewModel.UserDetailsPair;
import com.assigment.ams.amstestassigment.presentation.common.BaseContract;
import com.assigment.ams.amstestassigment.presentation.common.BaseDataView;

import java.util.List;

/**
 * Created by truerall on 12/28/17.
 */

public interface UserDetailsContract {
    interface View extends BaseDataView<UserDetailsPair> {

    }

    interface Presenter extends BaseContract.BasePresenter<View> {

    }
}
