package com.example.myapp;

import android.content.Intent;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button myShelf;
    public Button bookStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myShelf = (Button) findViewById(R.id.myShelf);
        myShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMyShelf();
            }
        });

        bookStore = (Button) findViewById(R.id.bookStore);
        bookStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBookStore();
            }
        });
    }

    public void openMyShelf() {
        Intent myShelfIntent =new Intent(this, MyShelf.class);
        startActivity(myShelfIntent);
    }

    public void openBookStore() {
        Intent bookStoreIntent =new Intent(this, BookStore.class);
        startActivity(bookStoreIntent);
    }


    public void browser(View view){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.pdfdrive.com"));
        startActivity(browserIntent);
    }


}

