package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ResetPassword_Page extends AppCompatActivity {
    //private EditText passwordEmail;
    private Button buttonFinish;


    public void openCreateNewPassword_page() {
        Intent buttonFinish = new Intent(this, CreateNewPassword_Page.class);
        this.startActivity(buttonFinish);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password__page);
        getIntent();

        buttonFinish = findViewById(R.id.buttonFinish);
        buttonFinish.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openCreateNewPassword_page();
            }
        });


    }
}