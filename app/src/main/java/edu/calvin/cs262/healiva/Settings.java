package edu.calvin.cs262.healiva;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import edu.calvin.cs262.healiva.Database.HealivaViewModel;

/**
 * Settings displays settings options for user
 * User can get to Profile settings with button profileButton at bottom of screen, or menu
 */
public class Settings extends AppCompatActivity {
    private Switch peerListener;
    private Switch notifications;
    // TODO: implement switches

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        // Access switches on Settings page
        peerListener = findViewById(R.id.peerListener);
        notifications = findViewById(R.id.notifications);
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
     * handleClickProfile item handles profile click and redirects to profile settings page
     * @param item
     */
    public void handleClickProfile(MenuItem item) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    /**
     * handleClickProfile view is an alternate route to the profile page
     * @param view
     */
    public void handleClickProfile(View view) {
        Intent profile = new Intent(this, Profile.class);
        this.startActivity(profile);
    }

    /**
     * handleClickSettings should not do anything because we are already on the settings page
     * @param item
     */
    public void handleClickSettings(MenuItem item) {
        // Do Nothing
    }

    /**
     * handleResetPassword should bring user to change Password page
     * @param view
     */
    public void handleResetPassword(View view) {
        Intent resetPassword = new Intent(this, ResetPassword.class);
        this.startActivity(resetPassword);
    }

    /**
     * handleDeleteAccount will present alert pop up and ask user to confirm action
     * On confirm account will be deleted and user will be returned to login page with history deleted
     * On cancel alert will close
     * @param view
     */
    public void handleDeleteAccount(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(Settings.this);
        alert.setTitle("Confirm Delete Account");
        alert.setMessage("Are you sure you want to delete your account? This action can not be undone.");

        alert.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
            /**
             * If user confirms deleting their account, bring them to the login page and erase activity history
             * @param dialog The alert to confirm delete account
             * @param which - required
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Delete user from all tables
                // TODO: handle removing group chats and appts if necessary
                //       currently we only delete Person record and PersonGroupChatLink recods
                HealivaViewModel healivaViewModel = ViewModelProviders.of(Settings.this).get(HealivaViewModel.class);
                healivaViewModel.deletePerson(Login.currentUser);

                // Bring to login page
                Intent loginPage = new Intent(Settings.this, Login.class);

                // Clear history so back button closes app
                loginPage.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                Settings.this.startActivity(loginPage);

                dialog.dismiss();
            }
        });

        alert.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            /**
             * If user changes their mind about deleting, close the alert
             * @param dialog The alert to confirm delete account
             * @param which - required
             */
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Close alert
                dialog.dismiss();
            }
        });

        alert.show();
    }
}
