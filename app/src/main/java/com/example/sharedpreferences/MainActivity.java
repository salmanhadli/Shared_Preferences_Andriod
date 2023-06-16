package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.btn);

        DisplaySavedText();


        button.setOnClickListener(v -> {
            String message = editText.getText().toString();
            DisplayAndSaveText(message);
        });
    }

    private void DisplaySavedText() {
        // Retrieving the value from shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        String s1 = sharedPreferences.getString("message", "");
        textView.setText(s1);
    }

    private void DisplayAndSaveText(String message) {
        // Display the text
        textView.setText(message);

        // Save the text into shared preferences
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);

        // Writing data to shared preferences
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("message", message);

        editor.commit();
    }
}