package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuPage extends AppCompatActivity {

    private Button Messaging;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);
        getIntent();

        Messaging = findViewById(R.id.menuItemOne);
        Messaging.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                openMessagePage();
            }
        });

    }

    private void openMessagePage() {
        Intent messagePage = new Intent(this, Messaging.class);
        this.startActivity(messagePage);
    }
    }

