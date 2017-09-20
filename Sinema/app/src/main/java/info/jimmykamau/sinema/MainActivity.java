package info.jimmykamau.sinema;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import info.jimmykamau.sinema.pojos.DiscoverBaseDto;
import info.jimmykamau.sinema.pojos.DiscoverResponseDto;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injection.getProviderInstance().setAppContext(this);
        setContentView(R.layout.activity_main);
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        Injection.getProviderInstance().getDiscoverRepository().getDiscover("popularity.desc", "False", "1").enqueue(new Callback<DiscoverBaseDto>() {
            @Override
            public void onResponse(final Call<DiscoverBaseDto> call, final Response<DiscoverBaseDto> response) {
                if (response.isSuccessful()) {
                    if (response.body() != null) {
                        for (DiscoverResponseDto discoverResponseDto : response.body().getResults()) {
                            Timber.d(discoverResponseDto.getOriginalTitle());
                        }
                    } else {
                        Timber.d("Response is empty");
                    }
                }
            }

            @Override
            public void onFailure(final Call<DiscoverBaseDto> call, final Throwable t) {
                Timber.d("Failed");
            }
        });
    }
}
