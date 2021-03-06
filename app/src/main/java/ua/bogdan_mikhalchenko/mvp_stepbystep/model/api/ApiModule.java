package ua.bogdan_mikhalchenko.mvp_stepbystep.model.api;

import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;

/**
 * Created by Shipohvost on 11.05.2017.
 */

public class ApiModule {
    private static final boolean ENABLE_AUTH = false;
    private static final String AUTH_64 = "***"; //your code here
    public static final String BASE_URL = "https://api.github.com/";

    public static ApiInterface getApiInterface() {

        OkHttpClient httpClient = new OkHttpClient();
        httpClient.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {

                Request original = chain.request();
                Request request = original.newBuilder()
                        .header("Authorization", "Basic " + AUTH_64)
                        .method(original.method(), original.body())
                        .build();
                return chain.proceed(request);
            }
        });

        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create());
        if (ENABLE_AUTH) builder.client(httpClient);

            ApiInterface apiInterface = builder.build().create(ApiInterface.class);

        return apiInterface;

    }

}
