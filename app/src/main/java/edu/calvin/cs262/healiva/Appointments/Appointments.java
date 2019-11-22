package edu.calvin.cs262.healiva.Appointments;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.Login;
import edu.calvin.cs262.healiva.Profile;
import edu.calvin.cs262.healiva.R;
import edu.calvin.cs262.healiva.Settings;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.Calendar;

/**
 * Appointments displays calendar for setting and viewing appointments
 */
public class Appointments extends AppCompatActivity {

    private CalendarView calendar;
    private TextView dateText;
    private TextView appInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointments);

        // Access page elements
        calendar = findViewById(R.id.calendarView);
        dateText = findViewById(R.id.dateText);
        appInfo = findViewById(R.id.appointmentInfo);

        //-------------------Set default text for date header-----------------//
        long date = calendar.getDate();

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
                String dateTextString = monthText + " " + dayOfMonth + ", " + year;
                dateText.setText(dateTextString);

                if (month == 11 && dayOfMonth == 12){
                    appInfo.setText("You have an with Dr.Strange at 2:30pm.");

                }
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
}
