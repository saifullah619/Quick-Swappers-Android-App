package com.saifullahdar.assignment;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

public final class screen10 extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_screen10);
        ActionBar a= getSupportActionBar();
        a.hide();

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            String name,location,description;
            Bitmap image;

            image = (Bitmap) getIntent().getParcelableExtra("Image");
            ImageView imageView = findViewById(R.id.img2);
            Drawable myDrawable = new BitmapDrawable(getResources(), image);
//            imageView.setImageResource(myDrawable);
            imageView.setImageBitmap(image);


            name = extras.getString("Name");
            TextView tt = findViewById(R.id.pname);
            tt.setText(name);

            location = extras.getString("Location");
            TextView textView2 = findViewById(R.id.loc);
            textView2.setText(location);

            description = extras.getString("Description");
            TextView textView3 = findViewById(R.id.desc);
            textView3.setText(description);


        }
    }
}
