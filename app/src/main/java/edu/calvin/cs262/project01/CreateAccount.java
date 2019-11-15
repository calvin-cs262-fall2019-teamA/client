package edu.calvin.cs262.project01;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.Session;

import javax.mail.PasswordAuthentication;

import javax.mail.Address;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.sql.DataSource;

import java.util.Properties;

import javax.mail.Message;

/**
 * CreateAccount class enable the new user join Calvinhealvia by  creating the account using Calvin email
 */
public class CreateAccount extends AppCompatActivity {

    EditText calvinEmail;
    EditText password;
    String email;
    String pass_word;
    /**
     * openMenuPage() should create the dropdown menu button in the top right corner of each page.
     * Options should include, Finish buttons
     * @param view
     */
    public void openMenuPage(View view) {
        Intent confirmationPage = new Intent(this, ConfirmationPage.class);
        this.startActivity(confirmationPage);

        calvinEmail = findViewById(R.id.CalvinEmail);
        password = findViewById(R.id.Password);
        email = calvinEmail.getText().toString();
        pass_word = password.getText().toString();

        if(email.matches("(.*)calvin.edu") && pass_word.length() >= 8){
            //add to table
            //send an email
            sendConfirmationEmail(email);
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

    public void sendConfirmationEmail(String emailAddress){


        new SendMailTask(CreateAccount.this).execute("tproj811@gmail.com", "popethiopia123", emailAddress, "Test email", "This is the very first email from CalvinHeliva");
    }


    }

