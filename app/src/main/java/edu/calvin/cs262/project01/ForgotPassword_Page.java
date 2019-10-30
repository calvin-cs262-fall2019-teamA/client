package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * ForgotPassword_page  enable user to enter their Calvin email to get code from  their email
 */

public class ForgotPassword_Page extends AppCompatActivity {




    private Button buttonReset;


    /**
     * openResetPage() should open the  ResetPassword_Page.
     */
    public void openResetPage() {
        Intent buttonReset = new Intent(this, ResetPassword_Page.class);
        this.startActivity(buttonReset);
    }


    /**
     * onCreate should display the reset password  activity using the code from email
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page);
        getIntent();


        // Complete button  should listen for clicks and react by opening CreateNewPassword_page
        buttonReset = findViewById(R.id.buttonContinue1);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
                openResetPage();
            }
        });


    }
 }





