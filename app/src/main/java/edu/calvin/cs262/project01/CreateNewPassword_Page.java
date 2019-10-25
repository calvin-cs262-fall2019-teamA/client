package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CreateNewPassword_Page extends AppCompatActivity {


    private Button buttonComplete;


    public void openMenuPage() {
        Intent buttonComplete = new Intent(this,MenuPage.class);
        this.startActivity(buttonComplete);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_password__page);
        getIntent();

        buttonComplete = findViewById(R.id.buttonComplete);
        buttonComplete.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openMenuPage();
            }
        });


    }
}