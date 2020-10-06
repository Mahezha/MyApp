package com.example.myapp;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

public class MyShelf extends AppCompatActivity {

    public Button storage;

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static int REQUEST_CODE = 42;
    public static final int PERMISSION_CODE = 42042;


    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shelf);

        storage = (Button) findViewById(R.id.storage);
        storage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFiles();
            }
        });
    }

    public void chooseFiles() {

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                READ_EXTERNAL_STORAGE);

        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    this,
                    new String[]{READ_EXTERNAL_STORAGE},
                    PERMISSION_CODE
            );

            return;
        }
        launchPicker();
    }

    void launchPicker() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.setType("application/pdf");
        try {
            startActivityForResult(intent, REQUEST_CODE);
        } catch (ActivityNotFoundException e) {
            //alert user that file manager not working
            Toast.makeText(this, "File manager is not working", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData){
        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            Uri uri = null;
            if(resultData != null){
                uri = resultData.getData();
                Log.i(TAG,"Uri: "+uri.toString());

                PDFView pdfView = findViewById(R.id.pdfView);
                pdfView.fromUri(uri)
                        .enableSwipe(true) // allows to block changing pages using swipe
                        .swipeHorizontal(false)
                        .enableDoubletap(true)
                        .defaultPage(0)
                        .enableAnnotationRendering(false) // render annotations (such as comments, colors or forms)
                        .password(null)
                        .scrollHandle(null)
                        .enableAntialiasing(true) // improve rendering a little bit on low-res screens
                        // spacing between pages in dp. To define spacing color, set view background
                        .spacing(0)
                        .autoSpacing(false) // add dynamic spacing to fit each page on its own on the screen
                        .pageSnap(true) // snap pages to screen boundaries
                        .pageFling(false) // make a fling change only a single page like ViewPager
                        .nightMode(false) // toggle night mode
                        .load();


            }
        }
    }
}
