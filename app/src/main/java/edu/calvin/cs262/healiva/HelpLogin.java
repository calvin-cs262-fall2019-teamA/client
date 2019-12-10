package edu.calvin.cs262.healiva;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * HelpLogin displays the frequently asked questions about app. It will help user with navigation of the app.
 *
 */
public class HelpLogin extends AppCompatActivity {

    /**
     * onCreate should create the HelpME page and display the FAQ's in the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpme);
    }
}

