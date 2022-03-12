package com.saifullahdar.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;


public final class screen2 extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_screen2);

        ActionBar a= getSupportActionBar();
        a.hide();

        Button btn = findViewById(R.id.signIn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen2.this,screen6.class);
                startActivity(intent);
            }
        });

        Button btn2 = findViewById(R.id.signInAsGuest);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen2.this,screen6.class);
                startActivity(intent);
            }
        });

        TextView forgetPass = findViewById(R.id.forgotPass);
        forgetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen2.this,screen3.class);
                startActivity(intent);
            }
        });


        TextView createAccount = findViewById(R.id.CreateAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(screen2.this,screen5.class);
                startActivity(intent);
            }
        });

    }



}
