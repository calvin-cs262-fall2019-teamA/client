package edu.calvin.cs262.project01;

import android.app.Activity;
import android.os.Bundle;

public class AboutUs extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getIntent();
    }
}

