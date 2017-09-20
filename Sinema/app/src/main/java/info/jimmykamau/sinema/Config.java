package info.jimmykamau.sinema;

/**
 * Created by jimmykamau on 06/09/2017.
 */

public class Config {

    private static final String HTTP_PREFIX = "http://";
    private static final String HTTPS_PREFIX = "https://";
    private static final String TMDB_API_KEY = BuildConfig.TMDB_KEY;
    private static final String TMDB_API_VERSION = "3";
    private static final String TMDB_BASE_URL = HTTPS_PREFIX + "api.themoviedb.org/" + TMDB_API_VERSION;

    private String getHttpPrefix() {
        return HTTP_PREFIX;
    }

    public String getHttpsPrefix() {
        return HTTPS_PREFIX;
    }

    public String getTmdbApiKey() {
        return TMDB_API_KEY;
    }

    public String getTmdbBaseUrl() {
        return TMDB_BASE_URL;
    }

    public String getTmdbApiVersion() {
        return TMDB_API_VERSION;
    }
}
