package info.jimmykamau.sinema;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import info.jimmykamau.sinema.repository.DiscoverRepository;
import info.jimmykamau.sinema.repository.impl.DiscoverRepositoryImpl;
import info.jimmykamau.sinema.repository.rest.DiscoverRestService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import timber.log.Timber;

/**
 * Created by jimmykamau on 06/09/2017.
 */

public class Provider {

    private Context appContext = null;
    private volatile Retrofit retrofitInstance;
    private volatile OkHttpClient okHttpClient;
    private volatile DiscoverRestService discoverRestService = null;

    public void setAppContext(Context context) {
        this.appContext = context;
    }

    public synchronized Retrofit getRetrofitInstance() {
        Timber.d("Get Retrofit instance");
        if (retrofitInstance == null) {
            retrofitInstance = new Retrofit.Builder().client(getOkHttpClient())
                    .baseUrl(Injection.getConfigInstance().getTmdbBaseUrl() + "/")
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
        }
        return retrofitInstance;
    }

    public synchronized OkHttpClient getOkHttpClient() {
        Timber.d("Get OkHttp Client");
        if (okHttpClient == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            if (BuildConfig.DEBUG) {
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            }
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .readTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .writeTimeout(Constants.NETWORK_TIMEOUT_SECONDS, TimeUnit.SECONDS)
                    .addInterceptor(httpLoggingInterceptor).build();
        }
        return okHttpClient;
    }

    public synchronized DiscoverRestService getDiscoverRestService() {
        if (discoverRestService == null) {
            discoverRestService = getRetrofitInstance().create(DiscoverRestService.class);
        }
        return discoverRestService;
    }

    public DiscoverRepository getDiscoverRepository() {
        return new DiscoverRepositoryImpl(getDiscoverRestService());
    }
}
