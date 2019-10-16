package com.example.mylibrary;

import android.content.Intent;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnSeeAll, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();
        setOnClickListeners();

    }

    private void setOnClickListeners(){
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AlreadyReadActivity.class);
                startActivity(intent);
            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });


    }


    private void initWidgets(){
        btnSeeAll = (Button)findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = (Button)findViewById(R.id.btnCurrrent);
        btnWantToRead= (Button)findViewById(R.id.btnWantTo);
        btnAlreadyRead = (Button)findViewById(R.id.btnAlreadyRead);
        btnAbout = (Button)findViewById(R.id.btnAbout);
    }

}
