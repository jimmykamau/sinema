package info.jimmykamau.sinema;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Injection.getProviderInstance().setAppContext(this);
        Config config = Injection.getConfigInstance();
        setContentView(R.layout.activity_main);
    }
}
