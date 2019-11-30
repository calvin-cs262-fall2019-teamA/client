package edu.calvin.cs262.healiva.CreateAccount;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

/**
 * Extends the AsyncTask for creating activity to send email
 */
public class SendMailTask extends AsyncTask {
    private ProgressDialog statusDialog;
    private Activity sendMailActivity;

    /**
     * Create an activity with send mail
     * @param activity
     */
    public SendMailTask(Activity activity) {
        sendMailActivity = activity;
    }

    protected void onPreExecute() {
    }


    @Override
    protected Object doInBackground(Object... args) {
        try {
            Log.i("SendMailTask", "About to instantiate GMail...");
            publishProgress("Processing input....");
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(),  args[2].toString(), args[3].toString(),
                    args[4].toString());
            publishProgress("Preparing mail message....");
            androidEmail.createEmailMessage();
            publishProgress("Sending email....");
            Toast.makeText(sendMailActivity, "Sending...", Toast.LENGTH_SHORT).show();
            androidEmail.sendEmail();
            publishProgress("Email Sent.");
            Log.i("SendMailTask", "Mail Sent.");
        } catch (Exception e) {
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void onPostExecute(Object result) {
        Toast.makeText(sendMailActivity, "Email sent!", Toast.LENGTH_SHORT).show();
    }
}