package edu.calvin.cs262.healiva;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

/**
 * AboutUs displays our vision statement so that potential users can learn about the app
 *
 * NOTE: onCreateOptionsMenu should not appear on the AboutUs page as the options of
 *       Profile, Settings, and Logout should only be available while logged in.
 */
public class AboutUs extends AppCompatActivity {

    /**
     * onCreate should create the aboutUs page and display the vision statement in the activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getIntent();
    }
}

