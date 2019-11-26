package com.bfby.zxjl.di.component;

import com.bfby.zxjl.MyApplication;
import com.bfby.zxjl.data.http.ApiService;
import com.bfby.zxjl.di.module.AppModule;
import com.bfby.zxjl.di.module.HttpModule;
import com.google.gson.Gson;
import javax.inject.Singleton;

import dagger.Component;


@Component(modules = {AppModule.class, HttpModule.class})
@Singleton
public interface AppComponent {

    ApiService getApiService();

    MyApplication getApplication();

    Gson getGson();
}
