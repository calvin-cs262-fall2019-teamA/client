package edu.calvin.cs262.project01;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

/**
 * MenuPage is responsible for handling menu item clicks and opening new activities
 * The menu page consists of buttons for Messaging, Events, and Appointments
 */
public class MenuPage extends AppCompatActivity {
    private Button Messaging;
    private Button Events;
    private Button Appointments;

    /**
     * onCreate should set up listeners for Messaging, Events, and Appointments
     * buttons and call the callback functions to start those activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        getIntent();

        // Message button should listen for click and react by opening Messaging page
        Messaging = findViewById(R.id.menuItemOne);
        Messaging.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMessagePage();
            }
        });

        // Events buttons should listen for clicks ad react by opening Events page
        Events = findViewById(R.id.menuItemTwo);
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeEvents();
            }
        });

        //Appointments button should listen for clicks and react by opening Appointments page
        Appointments = findViewById(R.id.menuItemThree);
        Appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeAppointments();
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
     * seeEvents should start the events activity
     */
    public void seeEvents() {
        Intent seeEvents = new Intent(this, EventsPage.class);
        this.startActivity(seeEvents);
    }

    /**
     * seeAppointments should start the Appointments activity
     */
    public void seeAppointments() {
        Intent seeAppointments = new Intent(this, Appointments.class);
        this.startActivity(seeAppointments);
    }

    /**
     * openMessagePage should start the messaging activity
     */
    private void openMessagePage() {
        Intent messagePage = new Intent(this, Messaging.class);
        this.startActivity(messagePage);
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
}
