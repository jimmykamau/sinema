package info.jimmykamau.sinema.repository.rest;

import info.jimmykamau.sinema.pojos.DiscoverBaseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jimmykamau on 09/09/2017.
 */

public interface DiscoverRestService {

    String API_KEY = "api_key";
    String SORT_BY = "sort_by";
    String INCLUDE_ADULT = "include_adult";
    String PAGE = "page";

    @GET("discover/movie")
    Call<DiscoverBaseDto> getDiscover(@Query(API_KEY) String api_key, @Query(SORT_BY) String sort_by,
                                      @Query(INCLUDE_ADULT) String include_adult, @Query(PAGE) String page);
}
