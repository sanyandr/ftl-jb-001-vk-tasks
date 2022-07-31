package com.alexenderboot.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.concurrent.TimeUnit;

public class JsonVKService {
    private Retrofit retrofit;
    private static JsonVKService instance;
    private static final String BASE_URL = "https://api.vk.com/";
    private JsonVKService() {
        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5, TimeUnit.SECONDS)
                .connectTimeout(5, TimeUnit.SECONDS)
                .build();

        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static JsonVKService getInstance() {
        if (instance == null) {
            instance = new JsonVKService();
        }
        return instance;
    }

    public JsonVKApi getJSONApi() {
        return retrofit.create(JsonVKApi.class);

    }

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
}
