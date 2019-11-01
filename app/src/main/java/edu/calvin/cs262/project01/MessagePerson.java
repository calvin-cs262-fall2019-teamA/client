package edu.calvin.cs262.project01;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

/**
 * MessagePerson.java opens up the activity page in which the user can choose which user/group they'd like to talk to
 * this page goes after the MessageGroup.java page
 */
public class MessagePerson extends AppCompatActivity {
    private Button messageCounselor;

    /**
     * Opens up the message person page activity page
     */
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_choose_message_person);
        getIntent();

        //Message button should listen for click and react by opening messaging_page_counselor
        messageCounselor = findViewById(R.id.yk);
        messageCounselor.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMessagePage();
            }
        });

    }

    /**
     * onCreateOptionsMenu should create the dropdown menu button in the top right corner of each page.
     * Options should include Profile, Settings, and Logout buttons
     * @param menu
     * @return true -- required return
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

    /**
     * openMessagePage opens the Message class
     */
    private void openMessagePage() {
        Intent openMessagePage = new Intent(this, Messaging.class);
        this.startActivity(openMessagePage);
    }

    /**
     * handleClickSettings handles settings click and redirects to settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        Intent settings = new Intent(this, Settings.class);
        this.startActivity(settings);
    }
}
