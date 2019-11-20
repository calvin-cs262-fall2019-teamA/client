
package edu.calvin.cs262.healiva;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.healiva.CreateAccount.CreateAccount;
import edu.calvin.cs262.healiva.ForgotPassword.ForgotPassword_Page;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;
import edu.calvin.cs262.healiva.Database.Person;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Login is responsible for checking login credentials redirecting to the menuPage
 * Login is also responsible for opening createAccount, forgotPassword, and aboutUs activities
 *
 * NOTE: onCreateOptionsMenu should not appear on the login page as the options of
 *       Profile, Settings, and Logout should only be available while logged in.
 */
public class Login extends AppCompatActivity {

    private Button login;
    private Button createAccount;
    private TextView forgotPassword;
    HealivaViewModel healivaViewModel;

    // This is a global variable to store the current user Person object
    public static Person currentUser;

    /**
     * onCreate should set up listeners for buttons on the login page
     * and use the callback functions to handle clicking those buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up view model access
        healivaViewModel = ViewModelProviders.of(this).get(HealivaViewModel.class);

        // Login button should listen for clicks and react by opening main menu
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                confirmAccount();
            }
        });


        // CreateAccount button should listen for clicks and react by opening main menu
        createAccount = findViewById(R.id.createAccount);
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openCreateAccount();
            }
        });


        //forgotPassword TextView should for the click and response by opening RestPassword_Page
        forgotPassword = findViewById(R.id.forgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openForgotPasswordPage();
            }
        });

    }

    /**
     * confirmAccount should verify email and password
     * Once verified menuPage should open up
     */
    public void confirmAccount() {
        EditText loginEmail = findViewById(R.id.loginEmail);
        EditText loginPassword = findViewById(R.id.loginPassword);
        healivaViewModel.findUser(loginEmail.getText().toString(), loginPassword.getText().toString()).observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable final List<Person> matchedLogins) {
                if(matchedLogins.size() > 0) {
                    // Print person received by query
                    Person currentPerson = matchedLogins.get(0);
                    Log.d("||||||||||||||||", " \n"
                            + "\nPassword: " + currentPerson.getPassword()
                            + "\nEmail: " + currentPerson.getEmail()
                            + "\nId: "    + currentPerson.getId());

                    // This is a global variable to store the current user Person object
                    currentUser = currentPerson;
                    openMenuPage();
                } else {
                    Toast.makeText(Login.this, "Incorrect email or password.", Toast.LENGTH_SHORT).show();
                }
            }});
    }

    /**
     * openMenuPage should open the menu page once an account is verified
     */
    public void openMenuPage() {
        Intent menuPage = new Intent(this, MenuPage.class);
        this.startActivity(menuPage);
    }

    /**
     * openCreateAccount should start the createAccount activity
     */
    public void openCreateAccount() {
        Intent createAccountPage = new Intent(this, CreateAccount.class);
        this.startActivity(createAccountPage);
    }

    /**
     * handleAboutUs should start aboutUs activity and show our vision statement
     */
    public void handleAboutUs(View view) {
        Intent aboutUs = new Intent(this, AboutUs.class);
        this.startActivity(aboutUs);
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
     * handleClickProfile handles profile click and redirects to profile settings page
     * @param item
     */
    public void handleClickProfile(MenuItem item) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    /**
     * handleAboutUs should start aboutUs activity and show our vision statement
     */
    public void openForgotPasswordPage() {
        Intent forgotPassword = new Intent(this, ForgotPassword_Page.class);
        this.startActivity(forgotPassword);
    }
}
