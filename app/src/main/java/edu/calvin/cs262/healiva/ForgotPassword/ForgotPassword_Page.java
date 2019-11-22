package edu.calvin.cs262.healiva.ForgotPassword;
import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * ForgotPassword_page enables user to enter their Calvin email to get code from their email
 */
public class ForgotPassword_Page extends AppCompatActivity {

    private Button buttonReset;

    /**
     * openResetPage() should open the  ResetPassword_Page.
     */
    public void openResetPage() {
        Intent resetPassword = new Intent(this, ResetPassword_Page.class);
        this.startActivity(resetPassword);
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

        // Complete button should listen for clicks and react by opening CreateNewPassword_page
        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openResetPage();

            }
        });
    }
 }




