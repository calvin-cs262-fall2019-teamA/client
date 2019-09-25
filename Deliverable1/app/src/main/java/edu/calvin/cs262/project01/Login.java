package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.app.assist.AssistStructure;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class Login extends AppCompatActivity {
    private Button login;
    private Button createAccount;

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
                openMenuPage();
            }
        });

    }

    public void openMenuPage() {
        Intent menuPage = new Intent(this, MenuPage.class);
        this.startActivity(menuPage);
    }
}
