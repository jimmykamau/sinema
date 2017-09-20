package info.jimmykamau.sinema.repository.impl;

import info.jimmykamau.sinema.Injection;
import info.jimmykamau.sinema.pojos.DiscoverBaseDto;
import info.jimmykamau.sinema.repository.DiscoverRepository;
import info.jimmykamau.sinema.repository.rest.DiscoverRestService;
import retrofit2.Call;

/**
 * Created by jimmykamau on 09/09/2017.
 */

public class DiscoverRepositoryImpl implements DiscoverRepository {

    private DiscoverRestService discoverRestService;

    public DiscoverRepositoryImpl(DiscoverRestService discoverRestService) {
        this.discoverRestService = discoverRestService;
    }

    @Override
    public Call<DiscoverBaseDto> getDiscover(String sort_by, String include_adult, String page) {
        return discoverRestService.getDiscover(Injection.getConfigInstance().getTmdbApiKey(), sort_by, include_adult, page);
    }
}
