package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

/**
 * Profile displays profile setting for user
 * User can choose full anonymity which disable all other profile setting
 * If the user disables full anonymity they will be able to customize what PII information shows
 */
public class Profile extends AppCompatActivity {
    private Switch fullAnonymity;
    private CardView disabled;
    private EditText description;
    private Switch showName;
    private Switch showPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Access buttons and view on profile page
        fullAnonymity = findViewById(R.id.anonymity);
        disabled = findViewById(R.id.disabled);
        description = findViewById(R.id.descriptionText);
        showName = findViewById(R.id.showName);
        showPic = findViewById(R.id.showPic);
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
     * handleClickProfile should not do anything because we are already on the profile page
     * @param item
     */
    public void handleClickProfile(MenuItem item) {
        // do nothing
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
     * handleFullAnonymity should
     *      disable other profile settings buttons and make user fully anonymous if anonymity is changed to on
     *      enable other profile settings buttons if anonymity is changed to off
     * @param view
     */
    public void handleFullAnonymity(View view) {

        // If full anonymity is checked
        // disable fields and make switches be off
        // Grey out all of screen but anonymity button
        if(fullAnonymity.isChecked()){
            disabled.setVisibility(view.VISIBLE);
            description.setInputType(InputType.TYPE_NULL);
            showName.setClickable(false);
            showPic.setClickable(false);
            showName.setChecked(false);
            showPic.setChecked(false);

        // enable fields and remove grey screen cover
        } else {
            disabled.setVisibility(view.GONE);
            description.setInputType(InputType.TYPE_TEXT_FLAG_IME_MULTI_LINE);
            showName.setClickable(true);
            showPic.setClickable(true);
        }
    }
}
