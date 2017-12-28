package com.assigment.ams.amstestassigment.di;

import android.app.Application;

import com.assigment.ams.amstestassigment.BuildConfig;
import com.assigment.ams.amstestassigment.data.repository.api.UsersApiService;
import com.assigment.ams.amstestassigment.data.repository.repositories.UsersRepository;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by truerall on 12/27/17.
 */

@Module
public class AppModule {

    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return application;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    UsersRepository provideRepository(UsersApiService service) {
        return new UsersRepository(service);
    }

    @Provides
    @Singleton
    UsersApiService provideUsersApiService(Retrofit apiClient) {
        return apiClient.create(UsersApiService.class);
    }
}
