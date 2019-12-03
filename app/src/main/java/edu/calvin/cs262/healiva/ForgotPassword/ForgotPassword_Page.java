package edu.calvin.cs262.healiva.ForgotPassword;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import edu.calvin.cs262.healiva.CreateAccount.ConfirmationPage;
import edu.calvin.cs262.healiva.CreateAccount.CreateAccount;
import edu.calvin.cs262.healiva.CreateAccount.SendMailTask;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;
import edu.calvin.cs262.healiva.Database.PersonDao;
import edu.calvin.cs262.healiva.Login;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Database.Person;
import edu.calvin.cs262.healiva.ResetPassword;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import static edu.calvin.cs262.healiva.CreateAccount.CreateAccount.randomAlphaNumeric;

/**
 * ForgotPassword_page enables user to enter their Calvin email to get code from their email
 */
public class ForgotPassword_Page extends AppCompatActivity {

    // TODO: determine how to create unique ids. (maybe primary key is email + password?)
    EditText calvinEmail;
    HealivaViewModel healivaViewModel;
    String verificationCode;

    /**
     * handleCreateAccount() should
     *      - check password
     *      - check for a calvin email
     *      - check for terms agreed
     *      - send confirmation email to validate account
     * @param view
     */
    public void handleForgotPassword(View view) {

        // Retrieve input text and checkbox state
        calvinEmail = findViewById(R.id.etEmailReset);
        String emailText = calvinEmail.getText().toString();

        Log.d("Before function", "hello\n");
//        findPeople(emailText);

        sendConfirmationEmail(emailText);

        Intent resetpasswordpage = new Intent(this, ResetPassword_Page.class);

        // Assign new person info to extra names to be identified after email confirmation
        resetpasswordpage.putExtra("PASSWORD_TEXT", emailText);
        resetpasswordpage.putExtra("VERIFICATION_CODE", verificationCode);
        this.startActivity(resetpasswordpage);

        }


//    public void findPeople(String ForgotPassEmail){
//        Log.d("I got below healiva", "\n");
//        healivaViewModel.findPerson(ForgotPassEmail).observe(this, new Observer<List<Person>>() {
//            @Override
//            public void onChanged(@Nullable final List<Person> matchedEmail) {
//                Log.d("I got below onchanged", "\n");
//                if(matchedEmail.size() > 0) {
//                    Log.d("I got below matchedmail", "\n");
//                    // Print person received by query
//                    Person currentPerson = matchedEmail.get(0);
//                    Log.d("||||||||||||||||", " \n"
//                            + "\nEmail: " + currentPerson.getEmail());
//
//                    // This is a global variable to store the current user Person object
//                } else {
//                    Toast.makeText(ForgotPassword_Page.this, "Email does not match.", Toast.LENGTH_SHORT).show();
//                }
//            }});
//    }


    /**
     * onCreate should display the reset password  activity using the code from email
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page);
        getIntent();

    }

    /**
     * sendNewCode should create and send a new code for the user to try again
     * @param emailAddress
     */
    public void sendConfirmationEmail(String emailAddress){
        verificationCode = CreateAccount.randomAlphaNumeric();
        String emailBody = "This is your verification code for resetting your password for CalvinHeliva.<br/><br/>" +
        "Please enter the code below on the confirmation page to reset your password:<br/><br/>";
        CreateAccount.sendConfirmationEmail(ForgotPassword_Page.this, emailAddress, verificationCode, emailBody);
        Toast.makeText(this, "Sending...", Toast.LENGTH_SHORT).show();
    }
}





