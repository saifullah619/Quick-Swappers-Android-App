package com.saifullahdar.assignment;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

public final class screen8 extends AppCompatActivity {
    boolean imageSet = false;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_screen8);

        ActionBar a = getSupportActionBar();
        a.hide();

        Button b = findViewById(R.id.btnAdd);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText t1 = findViewById(R.id.editText_name);
                String name = t1.getText().toString();
                EditText t2 = findViewById(R.id.editText_location);
                String location = t2.getText().toString();
                EditText t3 = findViewById(R.id.editText_tags);
                String tags = t3.getText().toString();
                EditText t4 = findViewById(R.id.editText_product_discription);
                String desc = t4.getText().toString();
                EditText t5 = findViewById(R.id.editText_highPrice);
                String high = t5.getText().toString();



                Intent intent = new Intent(screen8.this, screen7.class);

                intent.putExtra("name" , name);
                intent.putExtra("location" , location);
                intent.putExtra("tags" , tags);
                intent.putExtra("desc" , desc);
                intent.putExtra("high" , high);

                if (imageSet)
                {
                    ImageView iv = findViewById(R.id.uploadedImage);
                    Bitmap bitmap = ((BitmapDrawable)iv.getDrawable()).getBitmap();
                    intent.putExtra("bitmap", bitmap);
                }

                setResult(RESULT_OK,intent);
                screen8.this.finish();
            }
        });


        ImageButton b1 = findViewById(R.id.btnAddImage);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageSet = true;
                selectImage(screen8.this);
            }
        });
    }

    private void selectImage(Context context) {
        final CharSequence[] options = { "Take Photo", "Choose from Gallery","Cancel" };

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Choose your profile picture");

        builder.setItems(options, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int item) {

                if (options[item].equals("Take Photo")) {
                    Intent takePicture = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(takePicture, 0);

                } else if (options[item].equals("Choose from Gallery")) {
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto , 1);

                } else if (options[item].equals("Cancel")) {
                    dialog.dismiss();
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != RESULT_CANCELED) {
            switch (requestCode) {
                case 0:
                    ImageView imageView = findViewById(R.id.uploadedImage);
                    if (resultCode == RESULT_OK && data != null) {
                        Bitmap selectedImage = (Bitmap) data.getExtras().get("data");
                        imageView.setImageBitmap(selectedImage);
                        imageView.bringToFront();

                    }

                    break;
            }
        }
    }
}
