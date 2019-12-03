package edu.calvin.cs262.healiva.CreateAccount;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;
import edu.calvin.cs262.healiva.Database.Person;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * Confirmation page checks the code sent via email and confirm it
 */
public class ConfirmationPage extends AppCompatActivity {
    String emailText;
    String passwordText;
    String verificationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        Bundle extras = getIntent().getExtras();
        emailText = extras.getString("EMAIL_TEXT");
        passwordText = extras.getString("PASSWORD_TEXT");
        verificationCode = extras.getString("VERIFICATION_CODE");
        Log.d("Confirmation extras", emailText + passwordText);

    }

    /**
     * confirm will compare the code from the SendMailTask with the user's code input
     * The strings must match to create the account. Otherwise user will get a Toast
     * notifying then that the code does not match.
     * @param view
     */
    public void confirm(View view) {
        EditText verifyCodeInput = findViewById(R.id.verify_code);

        // If verification codes matches user input
        if (verificationCode.equals(verifyCodeInput.getText().toString())) {
            // Add new person to db
            Person newPerson = new Person(
                new Random().nextInt(),
                emailText,
                passwordText,
                "",
                false,
                "",
                false,
                null,
                false,
                "",
                false,
                false,
                false
            );

            HealivaViewModel healivaViewModel = ViewModelProviders.of(this).get(HealivaViewModel.class);
            healivaViewModel.insert(newPerson);

            // Open Menu page and pass in new user email and password
            Intent menuPage = new Intent(this, MenuPage.class);
            this.startActivity(menuPage);

        } else {
            Toast.makeText(this, "Code does not match.", Toast.LENGTH_SHORT).show();
        }
        
    }

    /**
     * sendNewCode should create and send a new code for the user to try again
     * @param view
     */
    public void sendNewCode(View view) {
        verificationCode = CreateAccount.randomAlphaNumeric();
        String emailBody = "You requested a new code.<br/><br/>" +
        "Please enter the code below on the confirmation page to create your account:<br/><br/>";
        CreateAccount.sendConfirmationEmail(ConfirmationPage.this, emailText, verificationCode, emailBody);
        Toast.makeText(this, "Sending...", Toast.LENGTH_SHORT).show();
    }
}
