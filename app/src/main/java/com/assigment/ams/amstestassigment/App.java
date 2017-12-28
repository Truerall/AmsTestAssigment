package com.assigment.ams.amstestassigment;

import android.app.Application;

import com.assigment.ams.amstestassigment.di.AppComponent;
import com.assigment.ams.amstestassigment.di.AppModule;
import com.assigment.ams.amstestassigment.di.DaggerAppComponent;

/**
 * Created by truerall on 12/27/17.
 */

public class App extends Application {

    private static App instance;
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        initAppComponent();
    }

    public static App getInstance() {
        return instance;
    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        appComponent.inject(this);
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
