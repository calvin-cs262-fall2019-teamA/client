package edu.calvin.cs262.healiva.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * CreateNewPassword_Page  enable the users to create new password  after the forget the old password
 */
public class CreateNewPassword_Page extends AppCompatActivity {

    private Button buttonComplete;

    /**
     * openMenuPage() should open the menuPage after the user reset their passwords.
     * Options should be complete button
     */
    public void openMenuPage() {
        Intent buttonComplete = new Intent(this, MenuPage.class);
        this.startActivity(buttonComplete);
    }

    /**
     * onCreate should set up listeners forget password activity
     * buttons and call the callback functions to start those activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password__page);
        getIntent();

        // Complete button should listen for clicks and react by opening main menu
        buttonComplete = findViewById(R.id.buttonComplete);
        buttonComplete.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openMenuPage();
            }
        });
    }
}