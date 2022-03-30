package com.example.wlasne;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;
public class galeria extends AppCompatActivity {
    private ImageSwitcher simpleImageSwitcher;
    private Button btnNext, btnBack,cofnij;

    int imageIds[] = {R.drawable.citrina, R.drawable.download, R.drawable.duck, };
    int count = imageIds.length;
    int currentIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galeria);
        Button gallery = findViewById(R.id.selectimg);
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
            }
        });

        btnNext = (Button) findViewById(R.id.next);
        btnBack = findViewById(R.id.back);
        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.podglad);
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        simpleImageSwitcher.setImageResource(imageIds[currentIndex]);

        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);
        cofnij= findViewById(R.id.cofij2);
        cofnij.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cofnij = new Intent(galeria.this, MainActivity.class);
                startActivity(cofnij);
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                simpleImageSwitcher.setInAnimation(galeria.this,R.anim.from_right);
                simpleImageSwitcher.setOutAnimation(galeria.this,R.anim.to_left);
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                simpleImageSwitcher.setInAnimation(galeria.this,R.anim.from_left);
                simpleImageSwitcher.setOutAnimation(galeria.this,R.anim.to_right);
                currentIndex--;
                if (currentIndex < 0)
                    currentIndex = count-1;
                simpleImageSwitcher.setImageResource(imageIds[currentIndex]);
            }
        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && data != null)
        {
            Uri selectedImage = data.getData();
            ImageSwitcher wybierz =findViewById(R.id.podglad);
            wybierz.setImageURI(selectedImage);
        }
    }
}