package edu.calvin.cs262.healiva;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

/**
 * ResetPassword allows a logged-in user to update their password easily from the Settings page
 */
public class ResetPassword extends AppCompatActivity {

    /**
     * onCreate should display the reset password activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
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
     * handleClickSettings handles settings click and redirects to settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        Intent settings = new Intent(this, Settings.class);
        this.startActivity(settings);
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
     * handleSaveNewPassword should update user's password and return them to settings page
     * @param view
     */
    public void handleSaveNewPassword(View view) {
        Toast.makeText(getApplicationContext(),"Password Reset", Toast.LENGTH_SHORT).show();
        Intent settings = new Intent(this, Settings.class);
        this.startActivity(settings);
    }
}
