package edu.calvin.cs262.healiva.Messaging;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.calvin.cs262.healiva.HelpMe;
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
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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
        ArrayList<ExampleItem> adapterList = new ArrayList<>();

        //Need to update the below with the actual database photo, user name, and recent chat history preview. Also need to update so that the view doesn't expand if the text gets too big
        adapterList.add(new ExampleItem(R.drawable.ic_android, "YK Park", "How is it going man!"));
        adapterList.add(new ExampleItem(R.drawable.ic_adb, "Sambridhi", "Your appointment has been made. An email .."));
        adapterList.add(new ExampleItem(R.drawable.ic_mood, "Nikita", "Are you going tomorrow?"));

        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(adapterList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
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

    /**
     * handleClickHelp handles help click and redirects to FAQ page
     * @param item
     */
    public void handleClickHelp(MenuItem item) {
        Intent help = new Intent(this, HelpMe.class);
        this.startActivity(help);
    }

}
