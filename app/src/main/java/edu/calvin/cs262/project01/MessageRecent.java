package edu.calvin.cs262.project01;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MessageRecent extends AppCompatActivity {
    private Button messageGroup;

    /*
     * onCreate should set up listeners for Messaging, Events, and Appointments
     * buttons and call the callback functions to start those activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recent_messages);
        getIntent();

        // Message button should listen for click and react by opening MessageRecent
        messageGroup = findViewById(R.id.newChat);
        messageGroup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMessageGroup();
            }
        });

    }

    /*
     * Opens up the messaging page activity
     */


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * logout handles logout click and redirects to login page
     * @param item
     */
    public void logout(MenuItem item) {
        Intent login = new Intent(this, Login.class);
        this.startActivity(login);
    }

    /**
     * handleClickProfile handles profile click and redirects to profile settings page
     * @param item
     */
    public void handleClickProfile(MenuItem item) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    private void openMessageGroup() {
        Intent openMessageGroup = new Intent(this, MessageGroup.class);
        this.startActivity(openMessageGroup);
    }

}
