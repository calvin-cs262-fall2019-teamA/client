package edu.calvin.cs262.healiva.Appointments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;
import edu.calvin.cs262.healiva.Database.Person;
import edu.calvin.cs262.healiva.Database.PersonDao;
import edu.calvin.cs262.healiva.Login;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.Profile;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Settings;

import android.app.Activity;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * NewAppointment gives user form to request new appt
 */
public class NewAppointment extends AppCompatActivity {

    private Spinner personDropdown;
    private List<StringWithId> dropdownOptions = new ArrayList<>();
    HealivaViewModel healivaViewModel;
    ArrayAdapter<StringWithId> personDropdownAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_appointment);
        // Set up view model access
        healivaViewModel = ViewModelProviders.of(this).get(HealivaViewModel.class);

        healivaViewModel.getAllListeners().observe(this, new Observer<List<Person>>() {
            @Override
            public void onChanged(@Nullable final List<Person> listeners) {

                // Get Person names
                Integer i;
                for(i = 0; i < listeners.size(); i++) {
                    // Print person received by query
                    Person currentPerson = listeners.get(i);
                    Log.d("||||||||||||||||", " \n"
                            + "\nPassword: " + currentPerson.getPassword()
                            + "\nEmail: " + currentPerson.getEmail()
                            + "\nId: "    + currentPerson.getId());

                    if (currentPerson.getShowName()) {
                        StringWithId person = new StringWithId(currentPerson.getName(), currentPerson.getId());
                        dropdownOptions.add(person);
                    } else {
                        StringWithId person = new StringWithId(currentPerson.getEmail(), currentPerson.getId());
                        dropdownOptions.add(person);
                    }
                }

                // Add people to dropdown
                personDropdown = findViewById(R.id.personDropdown);
                personDropdownAdapter = new ArrayAdapter<>(NewAppointment.this, R.layout.spinner_layout, dropdownOptions);
                personDropdownAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                personDropdown.setAdapter(personDropdownAdapter);
            }});
    }

    /**
     * onCreateOptionsMenu should create the dropdown menu button in the top right corner of each page.
     * Options should include Profile, Settings, and Logout buttons
     * @param menu
     * @return true -- required return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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

    /**
     * handleClickSettings handles settings click and redirects to settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        Intent settings = new Intent(this, Settings.class);
        this.startActivity(settings);
    }

    /**
     * handleClickMainMenu should bring user back to main Menu page
     * @param item
     */
    public void handleClickMainMenu(MenuItem item) {
        Intent mainMenu = new Intent(this, MenuPage.class);
        this.startActivity(mainMenu);
    }


    /**
     * onRequest read data from input to create new appointment
     * add to table
     * display on appt calendar
     * @param view
     */
    public void onRequest(View view) {
        // Use selected item position to get unique person id from dropdown
        Integer selectedDropdownItemPos = personDropdown.getSelectedItemPosition();
        StringWithId selectedItem = dropdownOptions.get(selectedDropdownItemPos);
        EditText requestedTime = findViewById(R.id.timeInput);

        // Set result and close activity
        Log.d("|||||||||", "onRequest: Got inside" + selectedItem.getId());
        setResult(Activity.RESULT_OK,
        new Intent()
                .putExtra("LISTENER_NAME", selectedItem.toString())
                .putExtra("LISTENER_ID", selectedItem.getId())
                .putExtra("TIME", requestedTime.getText().toString()));
        finish();
    }
}
