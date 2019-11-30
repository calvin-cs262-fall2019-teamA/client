package edu.calvin.cs262.healiva.Events;

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
 * It shows the list of events available
 */
public class EventsPage extends AppCompatActivity {
    private Button Events1;
    private Button Events2;

    /**
     * It initializes the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_page);

        // Events buttons should listen for clicks ad react by opening Events page
        Events1 = findViewById(R.id.eve1);
        Events1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeEvents1();
            }
        });

        Events2 = findViewById(R.id.eve2);
        Events2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeEvents2();
            }
        });
    }
    /**
     * It inflates the main menu page
     * @param menu
     * @return boolean
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /** seeEvents1 opens events 1 page
     */
    public void seeEvents1() {
        Intent seeEvents1 = new Intent(this, Event1Page.class);
        this.startActivity(seeEvents1);

    }

    /** seeEvents2 opens events 2 page
     */
    public void seeEvents2() {
        Intent seeEvents2 = new Intent(this, Events2Page.class);
        this.startActivity(seeEvents2);

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
}
