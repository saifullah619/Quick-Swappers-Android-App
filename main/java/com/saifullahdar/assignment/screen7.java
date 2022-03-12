package com.saifullahdar.assignment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class screen7 extends AppCompatActivity {
    RecyclerView rv;
    List<Add> adds;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen7);

        ActionBar a= getSupportActionBar();
        a.hide();

        rv = (RecyclerView) findViewById(R.id.rv);
        adds = new ArrayList<>();

        adds.add(new Add("Versace Bag","Islamabad","20$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.bags_image) , "tags"));
        adds.add(new Add("Styles heel","Lahore","40$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.heels_image), "tags"));
        adds.add(new Add("Xiomi M21","Paris","10$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.headphones_image), "tags"));

        adds.add(new Add("Ladies Bag","Islamabad","20$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.bags_image), "tags"));
        adds.add(new Add("Long heel","Lahore","40$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.heels_image), "tags"));
        adds.add(new Add("Xiomi x-3","Paris","10$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.headphones_image), "tags"));


        adds.add(new Add("Stylo Bag","Islamabad","20$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.bags_image), "tags"));
        adds.add(new Add("Xinjiang heel","Lahore","40$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.heels_image), "tags"));
        adds.add(new Add("Samsung DC","Paris","10$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.headphones_image), "tags"));

        adds.add(new Add("Metro Bag","Islamabad","20$"," Her şahsın öğrenim hakkı vardır. Öğrenim hiç olmazsa ilk ve temel safhalarında parasızdır. İlk öğretim mecburidir. Teknik ve mesleki öğretimden herkes istifade edebilmelidir. Yüksek öğretim, liyakatlerine göre herkese tam eşitlikle açık olmalıdır.",getResources().getDrawable(R.drawable.headphones_image), "tags"));

        MyRVAdapter adapter = new MyRVAdapter(adds,this);
        rv.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
        rv.setAdapter( adapter );

        Button btn = findViewById(R.id.addButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(screen7.this, screen8.class);
                startActivityForResult(i , 8);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 8)
        {
            String name = data.getStringExtra("name");
            String location = data.getStringExtra("location");
            String tags = data.getStringExtra("tags");
            String desc = data.getStringExtra("desc");
            String high = data.getStringExtra("high");
            Bitmap bitmap = (Bitmap) data.getParcelableExtra("bitmap");

            Drawable myDrawable = new BitmapDrawable(getResources(), bitmap);

            adds.add(new Add(name, location, high, desc,  myDrawable, tags));

            MyRVAdapter adapter = new MyRVAdapter(adds,this);
            rv.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
            rv.setAdapter( adapter );

        }


        if(requestCode == 9) {
            String name = data.getStringExtra("name");
            String location = data.getStringExtra("location");
            String tags = data.getStringExtra("tags");
            String desc = data.getStringExtra("desc");
            String high = data.getStringExtra("high");
            Bitmap bitmap = (Bitmap) data.getParcelableExtra("photo");
            int pos = data.getIntExtra("Position", 0);

            Drawable myDrawable = new BitmapDrawable(getResources(), bitmap);

            adds.get(pos).setProduct_name(name);
            adds.get(pos).setLocation(location);
            adds.get(pos).setDescription(desc);
            adds.get(pos).setPrice(high);
            adds.get(pos).setImage(myDrawable);

            MyRVAdapter adapter = new MyRVAdapter(adds,this);
            rv.setLayoutManager(new GridLayoutManager(this,3,GridLayoutManager.VERTICAL,false));
            rv.setAdapter( adapter );
        }

    }
}