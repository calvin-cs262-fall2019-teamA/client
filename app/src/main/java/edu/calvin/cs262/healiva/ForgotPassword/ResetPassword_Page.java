package edu.calvin.cs262.healiva.ForgotPassword;

import androidx.appcompat.app.AppCompatActivity;
import edu.calvin.cs262.healiva.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * ResetPassword_Page enables the user to confirm the code from their emails
 */
public class ResetPassword_Page extends AppCompatActivity {

    String verificationCode;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password__page);

        Bundle extras = getIntent().getExtras();
        //emailText = extras.getString("EMAIL_TEXT");
        //passwordText = extras.getString("PASSWORD_TEXT");
        verificationCode = extras.getString("VERIFICATION_CODE");
        //Log.d("Confirmation extras", emailText + passwordText);

    }


    /**
     * handleCreateAccount() should
     *      - check password
     *      - check for a calvin email
     *      - check for terms agreed
     *      - send confirmation email to validate account
     * @param view
     */
    public void handleConfirmCode(View view) {

        // Retrieve input text and checkbox state
        EditText confirmCode = findViewById(R.id.editTextCodeNUM);
        String Code = confirmCode.getText().toString();

        if (verificationCode.equals(Code)) {

            Intent createNewPass = new Intent(this, CreateNewPassword_Page.class);
            this.startActivity(createNewPass);
        } else {
            Toast.makeText(this, "Code does not match.", Toast.LENGTH_SHORT).show();
        }

    }

}