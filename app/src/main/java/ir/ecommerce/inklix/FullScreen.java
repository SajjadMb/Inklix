package ir.ecommerce.inklix;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class FullScreen extends AppCompatActivity {

    private android.support.v4.app.FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        fragmentManager = getSupportFragmentManager();
        EntranceFragment entranceFragment = new EntranceFragment();
        fragmentManager.beginTransaction().replace(R.id.user_fragment_container,entranceFragment).commit();
    }
}
