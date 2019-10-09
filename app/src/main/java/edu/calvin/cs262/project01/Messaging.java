package edu.calvin.cs262.project01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AbsSpinner;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Random;

public class Messaging extends AppCompatActivity {

    private String channelID = "csgk6hEIPp8ZKg0K";
    private String roomName = "observable-room";
    private EditText editText;
//    private Scaledrone scaledrone;
    private Button Messaging;

//    private String getRandomName() {
//        String[] adjs = {"autumn", "hidden", "bitter", "misty", "silent", "empty", "dry", "dark", "summer", "icy", "delicate", "quiet", "white", "cool", "spring", "winter", "patient", "twilight", "dawn", "crimson", "wispy", "weathered", "blue", "billowing", "broken", "cold", "damp", "falling", "frosty", "green", "long", "late", "lingering", "bold", "little", "morning", "muddy", "old", "red", "rough", "still", "small", "sparkling", "throbbing", "shy", "wandering", "withered", "wild", "black", "young", "holy", "solitary", "fragrant", "aged", "snowy", "proud", "floral", "restless", "divine", "polished", "ancient", "purple", "lively", "nameless"};
//        String[] nouns = {"waterfall", "river", "breeze", "moon", "rain", "wind", "sea", "morning", "snow", "lake", "sunset", "pine", "shadow", "leaf", "dawn", "glitter", "forest", "hill", "cloud", "meadow", "sun", "glade", "bird", "brook", "butterfly", "bush", "dew", "dust", "field", "fire", "flower", "firefly", "feather", "grass", "haze", "mountain", "night", "pond", "darkness", "snowflake", "silence", "sound", "sky", "shape", "surf", "thunder", "violet", "water", "wildflower", "wave", "water", "resonance", "sun", "wood", "dream", "cherry", "tree", "fog", "frost", "voice", "paper", "frog", "smoke", "star"};
//        return (
//                adjs[(int) Math.floor(Math.random() * adjs.length)] +
//                        "_" +
//                        nouns[(int) Math.floor(Math.random() * nouns.length)]
//        );
//    }
//
//    private String getRandomColor() {
//        Random r = new Random();
//        StringBuffer sb = new StringBuffer("#");
//        while(sb.length() < 7){
//            sb.append(Integer.toHexString(r.nextInt()));
//        }
//        return sb.toString().substring(0, 7);
//    }
//
//    class MemberData {
//        private String name;
//        private String color;
//
//        public MemberData(String name, String color) {
//            this.name = name;
//            this.color = color;
//        }
//
//        // Add an empty constructor so we can later parse JSON into MemberData using Jackson
//        public MemberData() {
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public String getColor() {
//            return color;
//        }
//    }

//    public void sendMessage(View view) {
//        String message = editText.getText().toString();
//        if (message.length() > 0) {
//            scaledrone.publish("observable-room", message);
//            editText.getText().clear();
//        }
//    }

    public static void setOnClickListener(View.OnClickListener onClickListener) {
    }

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_messaging_page_counselor);
        getIntent();

        //This is where we write the message
        editText = (EditText) findViewById(R.id.editText);

//        MemberData data = new MemberData(getRandomName(), getRandomColor());
//
//        scaledrone = new Scaledrone(channelID, data);
//        scaledrone.connect(new Listener() {
//            @Override
//            public void onOpen() {
//                System.out.println("Scaledrone connection open");
//                // Since the MainActivity itself already implement RoomListener we can pass it as a target
//                scaledrone.subscribe(roomName, Messaging.this);
//            }
//
//            @Override
//            public void onOpenFailure(Exception ex) {
//                System.err.println(ex);
//            }
//
//            @Override
//            public void onFailure(Exception ex) {
//                System.err.println(ex);
//            }
//
//            @Override
//            public void onClosed(String reason) {
//                System.err.println(reason);
//            }
//        });
//    }

//
//    //Successfully connected to Scaledrone room
//    @Override
//    public void onOpen(Room room) {
//        System.out.println("Connected to room");
//    }
//
//    //Connecting to Scaledrone failed
//    @Override
//    public void onOpenFailure(Room room, Exception ex) {
//        System.err.println(ex);
//    }
//
//    @Override
//    public void onMessage(Room room, Message message) {
//
//    }
//
//    //Received a message from Scaledrone room
//    @Override
//    public void onMessage(Room room, final JsonNode json, final Member member) {
//        // To transform the raw JsonNode into a POJO we can use an ObjectMapper
//        final ObjectMapper mapper = new ObjectMapper();
//        try {
//            // member.clientData is a MemberData object, let's parse it as such
//            Message receivedMessage;
//            final MemberData data = mapper.treeToValue(receivedMessage.getMember().getClientData(), MemberData.class);
//            // if the clientID of the message sender is the same as our's it was sent by us
//            boolean belongsToCurrentUser = receivedMessage.getClientID().equals(scaledrone.getClientID());
//            // since the message body is a simple string in our case we can use json.asText() to parse it as such
//            // if it was instead an object we could use a similar pattern to data parsing
//            final Message message = new Message(receivedMessage.getData().asText(), data, belongsToCurrentUser);
//            runOnUiThread(new Runnable() {
//                @Override
//                public void run() {
//                    MessageAdapter.add(message);
//                    // scroll the ListView to the last added element
//                    AbsSpinner messagesView;
//                    messagesView.setSelection(messagesView.getCount() - 1);
//                }
//            });
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
    }
}
