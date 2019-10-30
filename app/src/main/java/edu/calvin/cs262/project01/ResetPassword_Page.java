package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * ResetPassword_Page  enable the users to confirm the code from their emails
 */


public class ResetPassword_Page extends AppCompatActivity {

    private Button buttonFinish;



    /*
     * openCreateNewPassword_page() method  should open the  CreateNewPassword_Page
     */
    public void openCreateNewPassword_page() {
        Intent buttonFinish = new Intent(this, CreateNewPassword_Page.class);
        this.startActivity(buttonFinish);
    }


    /**
     * onCreate should display the password reset activity using the code from email
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password__page);
        getIntent();



        // finish  button  should listen for clicks and react by opening CreateNewPassword_page
        buttonFinish = findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openCreateNewPassword_page();
            }
        });


    }
}