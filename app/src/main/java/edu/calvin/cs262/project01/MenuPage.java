package edu.calvin.cs262.project01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MenuPage extends AppCompatActivity {
    private Button Events;
    private Button Appointments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_page);

        // Events buttons should listen for clicks ad react by opening Events page
        Events = findViewById(R.id.menuItemTwo);
        Events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeEvents();
            }
        });

        //Appointments button should listen for clicks and react by opening Appointments page
        Appointments = findViewById(R.id.menuItemThree);
        Appointments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                seeAppointments();
            }
        });
    }

    public void seeEvents() {
        Intent seeEvents = new Intent(this, EventsPage.class);
        this.startActivity(seeEvents);

    }

    public void seeAppointments() {
        Intent seeAppointments = new Intent(this, Appointments.class);
        this.startActivity(seeAppointments);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
