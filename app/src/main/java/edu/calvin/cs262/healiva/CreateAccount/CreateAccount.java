package edu.calvin.cs262.healiva.CreateAccount;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.Toast;

/**
 * CreateAccount class enable the new user join Calvinhealvia by  creating the account using Calvin email
 */
public class CreateAccount extends AppCompatActivity {

    // TODO: determine how to create unique ids. (maybe primary key is email + password?)
    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    EditText calvinEmail;
    EditText password;

    /**
     * handleCreateAccount() should
     *      - check password
     *      - check for a calvin email
     *      - check for terms agreed
     *      - send confirmation email to validate account
     * @param view
     */
    public void handleCreateAccount(View view) {

        // Retrieve input text and checkbox state
        calvinEmail = findViewById(R.id.CalvinEmail);
        password = findViewById(R.id.Password);
        String emailText = calvinEmail.getText().toString();
        String passwordText = password.getText().toString();
        CheckBox termsCheckbox = findViewById(R.id.agreeCheckBox);

        // Check for Calvin email
        if (emailText.length() == 0 || !emailText.matches("(.*)calvin.edu")) {
            Toast.makeText(this, "Email must be a valid calvin address.", Toast.LENGTH_SHORT).show();

        // Check for valid password
        } else if (passwordText.length() == 0 || passwordText.length() < 8) {
            Toast.makeText(this, "Password must have at least 8 characters.", Toast.LENGTH_SHORT).show();
        
        // Make sure terms is checked
        } else if (!termsCheckbox.isChecked()) {
            Toast.makeText(this, " ↑↑ Must Agree to Terms", Toast.LENGTH_SHORT).show();

        // All is good, send email confirmation
        } else {
            String verificationCode = randomAlphaNumeric();
            sendConfirmationEmail(emailText, verificationCode);

            Intent confirmationPage = new Intent(this, ConfirmationPage.class);

            // Assign new person info to extra names to be identified after email confirmation
            confirmationPage.putExtra("EMAIL_TEXT", passwordText);
            confirmationPage.putExtra("PASSWORD_TEXT", emailText);
            confirmationPage.putExtra("VERIFICATION_CODE", verificationCode);
            this.startActivity(confirmationPage);
        }
    }

    /**
     * onCreate should set up listeners for  events and  create accounts
     * buttons and call the callback functions to start those activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getIntent();
    }

    /**
     * randomAlphaNumeric will create a random 10 character verification code to verify user's email
     * @return alpha-numeric string
     */
    public static String randomAlphaNumeric() {
        Integer count = 10;
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            // Get a random character from ALPHA_NUMERIC_STRING
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());

            // Add character to string
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    /**
     * sendConfirmationEmail starts SendMailTask to send user an email with a verification code
     * email body is written in HTML and sent as a string
     * @param emailAddress
     */
    public void sendConfirmationEmail(String emailAddress, String verificationCode){
        new SendMailTask(CreateAccount.this).execute("tproj811@gmail.com", "popethiopia123", emailAddress, "Test email",
                "This is your very first email from CalvinHeliva, welcome!<br/><br/>" +
                "Please enter the code below on the confirmation page to create your account:<br/><br/>" +
                "<b><font color=\"#97252B\">" + verificationCode + "</font></b>");
    }
}
