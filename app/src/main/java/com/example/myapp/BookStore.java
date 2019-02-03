package com.example.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BookStore extends AppCompatActivity {

    public Button mazeRunner;
    public Button twilight;
    public Button newMoon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_store);

        mazeRunner = (Button) findViewById(R.id.mazeRunner);
        mazeRunner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMazeRunner();
            }
        });

        twilight = (Button) findViewById(R.id.twilight);
        twilight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTwilight();
            }
        });

        newMoon = (Button) findViewById(R.id.newMoon);
        newMoon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewMoon();
            }
        });
    }

    public void openMazeRunner() {
        Intent mazeRunnerIntent =new Intent(this, ViewMazeRunner.class);
        startActivity(mazeRunnerIntent);
    }

    public void openTwilight() {
        Intent twilightIntent =new Intent(this, ViewTwilight.class);
        startActivity(twilightIntent);
    }

    public void openNewMoon() {
        Intent newMoonIntent =new Intent(this, ViewNewMoon.class);
        startActivity(newMoonIntent);
    }
}
