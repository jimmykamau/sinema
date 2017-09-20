package info.jimmykamau.sinema.repository;

import info.jimmykamau.sinema.pojos.DiscoverBaseDto;
import retrofit2.Call;

/**
 * Created by jimmykamau on 09/09/2017.
 */

public interface DiscoverRepository {

    Call<DiscoverBaseDto> getDiscover(String sort_by, String include_adult, String page);
}
