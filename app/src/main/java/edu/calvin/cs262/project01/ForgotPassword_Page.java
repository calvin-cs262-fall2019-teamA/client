package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgotPassword_Page extends AppCompatActivity {

    private Button buttonReset;

    public void openResetPage() {
        Intent resetPassword = new Intent(this, ResetPassword_Page.class);
        this.startActivity(resetPassword);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_page);
        getIntent();

        buttonReset = findViewById(R.id.buttonReset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                openResetPage();
            }
        });
    }
 }





