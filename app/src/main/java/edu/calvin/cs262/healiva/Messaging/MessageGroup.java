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
 * MessageGroup.java opens up the activity page in which the user can choose which of the three users, counselor, peer, or group, the user wants to select.
 * MessageGroup is the next activity page after MessageRecent.java
 */
public class MessageGroup extends AppCompatActivity {
    private Button messagingGroupTherapist;
    private Button messagingGroupPeer;
    private Button messagingGroupGucciGang;

    /**
     * Opens up the message group page activity page
     */
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_choose_message_group);
        getIntent();

        // Message button should listen for click and react by opening MessagePerson
        messagingGroupTherapist = findViewById(R.id.buttonTherapist);
        messagingGroupTherapist.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openCounselorList();
            }
        });

        // Message button should listen for click and react by opening MessagePerson
        messagingGroupPeer = findViewById(R.id.buttonPeer);
        messagingGroupPeer.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMessagePerson();
            }
        });

        // Message button should listen for click and react by opening MessagePerson
        messagingGroupGucciGang = findViewById(R.id.buttonGucciGang);
        messagingGroupGucciGang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openGroupList();
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
     * openMessagePerson opens the MessagePerson class
     */
    private void openMessagePerson() {
        Intent messagePerson = new Intent(this, MessagePerson.class);
        this.startActivity(messagePerson);
    }

    /**
     * openCounselorList opens the CounselorList class
     */
    private void openCounselorList() {
        Intent counselorList = new Intent(this, CounselorList.class);
        this.startActivity(counselorList);
    }

    /**
     * openCounselorList opens the CounselorList class
     */
    private void openGroupList() {
        Intent groupList = new Intent(this, GroupList.class);
        this.startActivity(groupList);
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
