package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.project01.database.HealivaViewModel;
import edu.calvin.cs262.project01.database.Person;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

/**
 * CreateAccount class enable the new user join Calvinhealvia by  creating the account using Calvin email
 */
public class CreateAccount extends AppCompatActivity {

    // TODO: determine how to create unique ids. (maybe primary key is email + password?)
    EditText calvinEmail;
    EditText password;
    private HealivaViewModel healivaViewModel;


    /**
     * handleCreateAccount() should
     *      validate credentials
     *      add new person to db
     *      open menu page
     * @param view
     */
    public void handleCreateAccount(View view) {
        Boolean emailValidated = true;

        calvinEmail = findViewById(R.id.CalvinEmail);
        password = findViewById(R.id.Password);
        String emailText = calvinEmail.getText().toString();
        String passwordText = password.getText().toString();

        if(emailValidated && passwordText.length() != 0 && emailText.length() != 0) {
            // Make sure terms is checked
            CheckBox termsCheckbox = findViewById(R.id.agreeCheckBox);

            if(termsCheckbox.isChecked()) {
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

                healivaViewModel = ViewModelProviders.of(this).get(HealivaViewModel.class);
                healivaViewModel.insert(newPerson);

                // Open Menu page and pass in new user email and password
                Intent menuPage = new Intent(this, MenuPage.class);
                this.startActivity(menuPage);

            } else {
                Toast.makeText(this, " ↑↑ Must Agree to Terms", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Invalid Email", Toast.LENGTH_SHORT).show();
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
}
