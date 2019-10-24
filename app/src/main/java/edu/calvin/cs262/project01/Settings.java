package edu.calvin.cs262.project01;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Settings displays settings options for user
 * User can get to Profile settings with button profileButton at bottom of screen, or menu
 */
public class Settings extends AppCompatActivity {
    private Switch peerListener;
    private Switch notifications;
    // TODO: impliment switches

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Access switches on Settings page
        peerListener = findViewById(R.id.peerListener);
        notifications = findViewById(R.id.notifications);
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
     * handleClickProfile item handles profile click and redirects to profile settings page
     * @param item
     */
    public void handleClickProfile(MenuItem item) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    /**
     * handleClickProfile view is an alternate route to the profile page
     * @param view
     */
    public void handleClickProfile(View view) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    /**
     * handleClickSettings should not do anything because we are already on the settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        // Do Nothing
    }

    /**
     * handleResetPassword should bring user to change Password page
     * @param view
     */
    public void handleResetPassword(View view) {
        // TODO: Call reset Password page
    }
}
