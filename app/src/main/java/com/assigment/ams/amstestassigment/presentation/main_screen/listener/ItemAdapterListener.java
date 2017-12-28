package com.assigment.ams.amstestassigment.presentation.main_screen.listener;

/**
 * Created by truerall on 12/28/17.
 */

public interface ItemAdapterListener<T> {

    void onItemShowDetails(T item);

    void onItemDelete(T item, int position);
}
