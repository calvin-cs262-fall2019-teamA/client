package edu.calvin.cs262.healiva.Appointments;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.healiva.Database.Appointment;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;
import edu.calvin.cs262.healiva.Database.Person;
import edu.calvin.cs262.healiva.Login;
import edu.calvin.cs262.healiva.MenuPage;
import edu.calvin.cs262.healiva.Profile;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Appointments displays calendar for setting and viewing appointments
 */
public class Appointments extends AppCompatActivity {

    HealivaViewModel healivaViewModel;
    private CalendarView calendar;
    private TextView dateText;
    private TextView appInfo;
    private String dateTextString;
    private final Integer NEW_APPT_RESULT = 1;
    private Map apptsByDate = new HashMap();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        // Set up DB
        healivaViewModel = ViewModelProviders.of(this).get(HealivaViewModel.class);

        // Access page elements
        calendar = findViewById(R.id.calendarView);
        dateText = findViewById(R.id.dateText);
        appInfo = findViewById(R.id.appointmentInfo);

        //-------------------Set default text for date header-----------------//
        final long date = calendar.getDate();

        // create instance to use for retrieving values
        Calendar  calendarInstance = Calendar.getInstance();
        calendarInstance.setTimeInMillis(date);

        // Extract year, month, and day
        int year = calendarInstance.get(calendarInstance.YEAR);
        int month = calendarInstance.get(calendarInstance.MONTH);
        int dayOfMonth = calendarInstance.get(calendarInstance.DAY_OF_MONTH);

        // Determine month text
        String monthText = getMonthText(month);

        // Create date string for heading and set text of heading
        String defaultDateText = monthText + " " + dayOfMonth + ", " + year;
        dateText.setText(defaultDateText);
        //---------------(End) Set default text for date header-----------------//

        healivaViewModel.getAllAppointments().observe(Appointments.this, new Observer<List<Appointment>>() {
            @Override
            public void onChanged(@Nullable final List<Appointment> userAppts) {
                String appointmentString = "";
                Log.d("|||||||||||", "onChanged: For Appointment");
                for (Integer i = 0; i < userAppts.size(); i++) {

                    Appointment currentAppt = userAppts.get(i);
                    Integer listenerId = currentAppt.getListenerId();
                    String name = healivaViewModel.getNameFromId(listenerId);

                    if (name.equals("")) {
                        name = healivaViewModel.getEmailFromId(listenerId);
                    }

                    appointmentString += "Pending approval:" +
                            "\n Appointment with " + name +
                            " at " + currentAppt.getTime() + ".\n";

                    String currentDate = currentAppt.getDate();
                    String currentDateValue = (String)apptsByDate.get(currentDate);

                    String newValue;
                    if (currentDateValue != null) {
                        newValue = currentDateValue + appointmentString;

                    } else {
                        newValue = appointmentString;
                    }

                    apptsByDate.put(currentDate, newValue);
                }
            }}
        );

        /**
         * setOnDateChangeListener should select the date and show it under the calendar with
         * information about that day's appointments
         * @param view
         */
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                // Determine month text
                String monthText = getMonthText(month);

                // Create date string for heading and set text of heading
                dateTextString = monthText + " " + dayOfMonth + ", " + year;
                dateText.setText(dateTextString);

                String currentDateValue = (String)apptsByDate.get(dateTextString);
                if (currentDateValue == null) {
                    currentDateValue = "You have no appointments for this date.";
                }

                appInfo.setText(currentDateValue);

//                if (month == 11 && dayOfMonth == 12){
//                    appInfo.setText("You have an with Dr.Strange at 2:30pm.");
//                }
            }
        });
    }

    /**
     * getMonthText gives the corresponding month name of an int month
     * @param month int indicating month of selected calendar date
     * @return String of corresponding month text
     */
    public String getMonthText(int month) {
        switch(month) {
            case 0:
                return "January";
            case 1:
                return "February";
            case 2:
                return "March";
            case 3:
                return "April";
            case 4:
                return "May";
            case 5:
                return "June";
            case 6:
                return "July";
            case 7:
                return "August";
            case 8:
                return "September";
            case 9:
                return "October";
            case 10:
                return "November";
            case 11:
                return "December";
            default:
                return "Error :(";
        }
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
     * handleNewAppointment should start activity to add new appointment
     * then return to appt page with updated info
     * @param view
     */
    public void handleNewAppointment(View view) {
        Intent newAppointment = new Intent(Appointments.this, NewAppointment.class);

        startActivityForResult(newAppointment, NEW_APPT_RESULT);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NEW_APPT_RESULT) {
            // Make sure the request was successful
            if (resultCode == RESULT_OK) {
                String listenerName = data.getStringExtra("LISTENER_NAME");
                Integer listenerID = data.getIntExtra("LISTENER_ID", 0);
                String time = data.getStringExtra("TIME");
                String apptDate = dateTextString;

                // Make new appt
                Appointment newAppt = new Appointment(new Random().nextInt(), Login.currentUser.getId(), listenerID, null, apptDate, time);
                healivaViewModel.insert(newAppt);

                appInfo.setText("Pending approval:" +
                        "\n Appointment with " + listenerName +
                        " at " + time+ ".\n");
            }
        }
    }
}
