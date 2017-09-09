package info.jimmykamau.sinema;

/**
 * Created by jimmykamau on 06/09/2017.
 */

public class Injection {
    private static Provider provider;
    private static Config config;

    public static Provider getProviderInstance() {
        if (provider == null) {
            synchronized (Injection.class) {
                if (provider == null) {
                    provider = new Provider();
                }
            }
        }
        return provider;
    }

    public static Config getConfigInstance() {
        if (config == null) {
            synchronized (Injection.class) {
                if (config == null) {
                    config = new Config();
                }
            }
        }
        return config;
    }
}
