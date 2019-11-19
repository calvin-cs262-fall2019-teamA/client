package edu.calvin.cs262.project01.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.project01.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * ResetPassword_Page enables the user to confirm the code from their emails
 */
public class ResetPassword_Page extends AppCompatActivity {

    private Button continueButton;

    /**
     * openCreateNewPassword_page() method should open the CreateNewPassword_Page
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

        // continue  button  should listen for clicks and react by opening CreateNewPassword_page
        continueButton = findViewById(R.id.continueButton);
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openCreateNewPassword_page();
            }
        });
    }
}