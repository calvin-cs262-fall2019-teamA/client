package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.project01.database.HealivaViewModel;
import edu.calvin.cs262.project01.database.Person;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class ConfirmationPage extends AppCompatActivity {
    String emailText;
    String passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_page);

        Bundle extras = getIntent().getExtras();
        emailText = extras.getString("EMAIL_TEXT");
        passwordText = extras.getString("PASSWORD_TEXT");
        Log.d("Confirmation extras", emailText + passwordText);

    }

    public void confirm(View view) {
        // TODO: CONFIRM CODE

        Boolean codeConfirmed = true;
        if (codeConfirmed) {
            // Add new person to db
            Person newPerson = new Person(
                new Random().nextInt(),
                passwordText,
                emailText,
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
            Toast.makeText(this, "Code does not match", Toast.LENGTH_SHORT).show();
        }
        
    }
}
