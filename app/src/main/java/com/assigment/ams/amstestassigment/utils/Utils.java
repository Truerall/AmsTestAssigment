package com.assigment.ams.amstestassigment.utils;

import android.util.Log;

import com.assigment.ams.amstestassigment.App;
import com.assigment.ams.amstestassigment.BuildConfig;

/**
 * Created by truerall on 12/27/17.
 */

public class Utils {
    private static final String TAG = "AMS";

    /**
     * Logs the info only in debug mode, so even if you will forget to delete this log,
     * production build's log still be clean.
     *
     * @param message actual message
     */
    public static void DBG(String message) {
        if (BuildConfig.DEBUG_FEATURES) Log.i(TAG, message);
    }

    public static String getString(int stringId){
        return App.getInstance().getResources().getString(stringId);
    }

}
