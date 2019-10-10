package edu.calvin.cs262.project01;


import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Messaging extends AppCompatActivity {

    private String channelID = "csgk6hEIPp8ZKg0K";
    private String roomName = "observable-room";
    private EditText editText;
    private Button Messaging;

    public static void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_messaging_page_counselor);
        getIntent();

        //This is where we write the message
        editText = (EditText) findViewById(R.id.editText);

    }
}
