package edu.calvin.cs262.project01;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * CreateAccount class enable the new user join Calvinhealvia by  creating the account using Calvin email
 */

public class CreateAccount extends AppCompatActivity {

    /**
     * openMenuPage() should create the dropdown menu button in the top right corner of each page.
     * Options should include, Finish buttons
     * @param view
     */
    public void openMenuPage(View view) {
        Intent menuPage = new Intent(this, MenuPage.class);
        this.startActivity(menuPage);
    }

    /**
     * onCreate should set up listeners for  events and  create accounts
     * buttons and call the callback functions to start those activities
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        getIntent();
    }
}
