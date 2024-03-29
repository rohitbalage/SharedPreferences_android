package com.rrbofficial.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button saveButton;
    private EditText enterMessage;
    private TextView showMessageTextView;
    private static final String MESSAGE_ID ="MESSAGES_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        saveButton  = findViewById(R.id.button);
        enterMessage =findViewById(R.id.editText);
        showMessageTextView = findViewById(R.id.showMessageTextView);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = enterMessage.getText().toString().trim();
                SharedPreferences sharedPreferences = getSharedPreferences(MESSAGE_ID, MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("message", message);

                editor.apply(); // savig to disk!

            }
        });

        // Get data back from shared preferences

        SharedPreferences getShareData = getSharedPreferences(MESSAGE_ID,MODE_PRIVATE);
      String value =  getShareData.getString( "message", "Nothing yet");

      showMessageTextView.setText(value);


    }
}