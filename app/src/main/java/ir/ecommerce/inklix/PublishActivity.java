package ir.ecommerce.inklix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.asksira.bsimagepicker.BSImagePicker;
import com.bumptech.glide.Glide;

import java.util.List;

public class PublishActivity extends AppCompatActivity implements BSImagePicker.OnSingleImageSelectedListener,
        BSImagePicker.OnMultiImageSelectedListener{

    private ImageView ivImage ;
    Button nextStep;
    String uriString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publish);
        ivImage = (ImageView) findViewById(R.id.iv_image);
        nextStep = (Button) findViewById(R.id.btn_publish);

        findViewById(R.id.tv_single_selection).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BSImagePicker pickerDialog = new BSImagePicker.Builder("ir.ecommerce.dapp.fileprovider")
                        .build();
                pickerDialog.show(getSupportFragmentManager(), "picker");
            }
        });

        nextStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext() , PostDetail.class);
                intent.putExtra("imageUri" , uriString);
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    public void onSingleImageSelected(Uri uri) {
        Glide.with(PublishActivity.this).load(uri).into(ivImage);
        uriString = uri.toString();
        nextStep.setEnabled(true);
    }

    @Override
    public void onMultiImageSelected(List<Uri> uriList) {

    }
}