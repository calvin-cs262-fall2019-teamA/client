package edu.calvin.cs262.healiva.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;

import edu.calvin.cs262.healiva.CreateAccount.ConfirmationPage;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


/**
 * CreateNewPassword_Page  enable the users to create new password  after the forget the old password
 */
public class CreateNewPassword_Page extends AppCompatActivity {

    private Button buttonComplete;
    EditText newPassword;
    EditText retypePassword;

    /**
     * handleCreateAccount() should
     *      - check password
     *      - check for a calvin email
     *      - check for terms agreed
     *      - send confirmation email to validate account
     * @param view
     */
    public void handleNewPassword(View view) {

        // Retrieve input text and checkbox state
        newPassword = findViewById(R.id.newPass);
        retypePassword = findViewById(R.id.confirmPass);


        String newpasswordText = newPassword.getText().toString();
        String retypepasswordText = retypePassword.getText().toString();


        if (newpasswordText.length() == 0 || newpasswordText.length() < 8 || !newpasswordText.equals(retypepasswordText)){
            if (newpasswordText.length() == 0 || newpasswordText.length() < 8 ) {
                Toast.makeText(this, "Password must have at least 8 characters.", Toast.LENGTH_SHORT).show();
            }
            if (!newpasswordText.equals(retypepasswordText)){
                Toast.makeText(this, "New Password and Confirm Password does not match.", Toast.LENGTH_SHORT).show();
            }
        }

            // All is good, send email confirmation
        else {

            Intent continuePage = new Intent(this, MenuPage.class);
            this.startActivity(continuePage);
        }
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

    }
}