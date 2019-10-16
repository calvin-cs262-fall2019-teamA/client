
package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

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

    /**
     * onCreate should set up listeners for buttons on the login page
     * and use the callback functions to handle clicking those buttons
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Login button should listen for clicks and react by opening main menu
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openMenuPage();
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

    }

    /**
     * openMenuPage should start the menuPage activity
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
}
