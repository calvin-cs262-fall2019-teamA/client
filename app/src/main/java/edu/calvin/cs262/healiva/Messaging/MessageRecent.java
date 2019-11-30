package edu.calvin.cs262.healiva.Messaging;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.Login;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.Profile;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Settings;

/**
 * MessageRecent.java is the first page that the user sees after clicking Messages in the menu page. In the MessageRecent activity page,
 * the user is shown with various recent conversations the user was engaged in, a search button, and a button to initiate a new conversation.
 */
public class MessageRecent extends AppCompatActivity {
    private Button messageGroup;

    /**
     * Opens up the MessageGroup activity page
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
     * handleClickMainMenu should bring user back to main Menu page
     * @param item
     */
    public void handleClickMainMenu(MenuItem item) {
        Intent mainMenu = new Intent(this, MenuPage.class);
        this.startActivity(mainMenu);
    }

    /**
     * openMessageGroup opens the MessageGroup class
     */
    private void openMessageGroup() {
        Intent openMessageGroup = new Intent(this, MessageGroup.class);
        this.startActivity(openMessageGroup);
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
