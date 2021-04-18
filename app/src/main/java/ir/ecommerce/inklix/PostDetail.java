package ir.ecommerce.inklix;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class PostDetail extends AppCompatActivity {

    String imageUri;

    ImageView imageView;
    EditText edt_title , edt_caption;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        edt_title = (EditText) findViewById(R.id.edt_title);
        edt_caption = (EditText) findViewById(R.id.edt_caption);
        imageView = (ImageView) findViewById(R.id.image_vw);
        TextView publish = (TextView) findViewById(R.id.txt_publish);

        setupToolbar();

        imageUri = getIntent().getExtras().getString("imageUri");
        Glide.with(PostDetail.this).load(imageUri).into(imageView);

        publish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "publish clicked",
                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private void setupToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Show menu icon
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_arrow_back);
        ab.setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                Intent intent = new Intent(getApplicationContext() , PublishActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
