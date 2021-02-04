package in.indianmeme.app;

import android.app.Application;
import android.content.Intent;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyApp extends Application {

    private static Retrofit retrofit;
    private static Gson gson;
    private static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASR_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        gson = new GsonBuilder().setLenient().create();

    }

    public static MyApp getInstance() {
        return instance;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }

    public static Gson getGson() {
        return gson;
    }


}
