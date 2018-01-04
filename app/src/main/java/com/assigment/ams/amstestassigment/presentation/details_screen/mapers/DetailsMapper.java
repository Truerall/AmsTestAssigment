package com.assigment.ams.amstestassigment.presentation.details_screen.mapers;

import com.assigment.ams.amstestassigment.R;
import com.assigment.ams.amstestassigment.data.model.User;
import com.assigment.ams.amstestassigment.presentation.details_screen.models.UserDetailViewModel;
import com.assigment.ams.amstestassigment.utils.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by truerall on 1/4/18.
 */

public class DetailsMapper {
    public static List<UserDetailViewModel> mapBaseAttributes(User user) {
        List<UserDetailViewModel> list = new ArrayList<>(3);
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_user_name), user.getUserName()));
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_first_name), user.getFirstName()));
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_last_name), user.getLastName()));
        return list;
    }

    public static List<UserDetailViewModel> mapSecondaryAttributes(User user) {
        List<UserDetailViewModel> list = new ArrayList<>(4);
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_street_name), user.getStreetName()));
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_house_number), String.valueOf(user.getHouseNumber())));
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_country), user.getCountry()));
        list.add(new UserDetailViewModel(Utils.getString(R.string.tv_city), user.getCity()));

        return list;
    }
}
