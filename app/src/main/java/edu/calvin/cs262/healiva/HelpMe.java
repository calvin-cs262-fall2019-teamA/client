package edu.calvin.cs262.healiva;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

/**
 * HelpMe displays the frequently asked questions about app. It will help user with navigation of the app.
 *
 */
public class HelpMe extends AppCompatActivity {

    /**
     * onCreate should create the HelpME page and display the FAQ's in the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helpme);
    }

    /**
     * onCreateOptionsMenu should create the dropdown menu button in the top right corner of each page.
     * Options should include Profile, Settings, Help and Logout buttons
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
     * handleClickSettings handles settings click and redirects to settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        Intent settings = new Intent(this, Settings.class);
        this.startActivity(settings);
    }

    /**
     * handleClickHelp handles help click and redirects to FAQ page
     * @param item
     */
    public void handleClickHelp(MenuItem item) {
        //do nothing
    }

    /**
     * handleClickMainMenu should bring user back to main Menu page
     * @param item
     */
    public void handleClickMainMenu(MenuItem item) {
        Intent mainMenu = new Intent(this, MenuPage.class);
        this.startActivity(mainMenu);
    }
}

