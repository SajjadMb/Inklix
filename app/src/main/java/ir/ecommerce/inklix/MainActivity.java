package ir.ecommerce.inklix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.asksira.bsimagepicker.BSImagePicker;

import java.util.List;


public class MainActivity extends AppCompatActivity implements BSImagePicker.OnSingleImageSelectedListener,
        BSImagePicker.OnMultiImageSelectedListener {

    //...

    @Override
    public void onSingleImageSelected(Uri uri) {
        //Do something with your Uri
    }

    @Override
    public void onMultiImageSelected(List<Uri> uriList) {
        //Do something with your Uri list
    }

    private android.support.v4.app.FragmentManager fragmentManager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    NewsFragment newsFragment = new NewsFragment();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, newsFragment).commit();
                    return true;
                case R.id.navigation_publish:
                    Intent intent = new Intent(getApplicationContext(),PublishActivity.class);
                    startActivity(intent);
                    return true;
                case R.id.navigation_profile:
                    ProfileFragment profileFragment = new ProfileFragment();
                    fragmentManager.beginTransaction().replace(R.id.fragment_container, profileFragment).commit();
                    return true;
            }
            return false;
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();

        NewsFragment newsFragment = new NewsFragment();
        fragmentManager.beginTransaction().replace(R.id.fragment_container, newsFragment).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);



    }

}
