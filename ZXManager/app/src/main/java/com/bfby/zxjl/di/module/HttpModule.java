package com.bfby.zxjl.di.module;

import android.util.Log;

import com.bfby.zxjl.MyApplication;
import com.bfby.zxjl.common.util.SSLSocketClient;
import com.bfby.zxjl.data.http.ApiService;
import com.bfby.zxjl.di.component.Constants;
import com.google.gson.Gson;
import java.util.concurrent.TimeUnit;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class HttpModule {
    private static final String TAG = "HttpModule";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Gson gson, MyApplication context) {
        //新建log拦截器
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.e("RxRetrofit", "Retrofit====Message:" + message);
            }
        });
        //开发模式记录整个body
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等

        OkHttpClient.Builder okClient = new OkHttpClient.Builder()
                //HeadInterceptor实现了Interceptor，用来往Request Header添加一些业务相关数据，如APP版本，token信息
                // .addInterceptor(new HeadInterceptor())
                // .addInterceptor(commonParamsInterceptor)
                //.addInterceptor(new LoggingInterceptor())
                .addInterceptor(logging)
                // 连接超时时间设置
                .connectTimeout(10, TimeUnit.SECONDS)
                // 读取超时时间设置
                .readTimeout(10, TimeUnit.SECONDS)
                .sslSocketFactory(SSLSocketClient.getSSLSocketFactory())
                .hostnameVerifier(SSLSocketClient.getHostnameVerifier());


        return okClient.build();
    }

    @Provides
    @Singleton
    Retrofit provodeRetrofit(OkHttpClient okHttpClient) {

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient);

        return builder.build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit) {
        // LogUtil.e( "provideApiService: " + retrofit);
        return retrofit.create(ApiService.class);


    }


}
