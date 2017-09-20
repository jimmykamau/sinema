package info.jimmykamau.sinema.repository.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import info.jimmykamau.sinema.Injection;
import info.jimmykamau.sinema.pojos.DiscoverBaseDto;
import info.jimmykamau.sinema.pojos.DiscoverResponseDto;
import info.jimmykamau.sinema.repository.DiscoverRepository;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jimmykamau on 20/09/2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class DiscoverRepositoryImplTest {

    @Mock
    DiscoverRepository discoverRestService;
    DiscoverBaseDto discoverBaseDto;
    List<DiscoverResponseDto> discoverResponseDtos;


    @Captor
    private ArgumentCaptor<Callback<DiscoverBaseDto>> callbackArgumentCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        discoverRestService = Injection.getProviderInstance().getDiscoverRepository();
        discoverBaseDto = new DiscoverBaseDto();
        discoverResponseDtos = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getDiscover() throws Exception {
        String dummyApiString = Mockito.anyString();
        discoverResponseDtos.add(new DiscoverResponseDto());
        Response<DiscoverBaseDto> response = Response.success(discoverBaseDto);

        Mockito.verify(discoverRestService).getDiscover(dummyApiString, dummyApiString, dummyApiString)
                .enqueue(callbackArgumentCaptor.capture());
        callbackArgumentCaptor.getValue().onResponse(null, response);
    }

}