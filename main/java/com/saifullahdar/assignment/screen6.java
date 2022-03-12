package com.saifullahdar.assignment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class screen6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen6);

        ActionBar a= getSupportActionBar();
        a.hide();

        Button btn = findViewById(R.id.post);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen6.this,screen7.class);
                startActivity(intent);
            }
        });


        Button btn1 = findViewById(R.id.signOut);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen6.this,screen2.class);
                startActivity(intent);
            }
        });

    }
}