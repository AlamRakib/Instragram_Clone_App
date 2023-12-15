package com.example.instagramcloneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity implements View.OnClickListener {

    Button sendButton, clearButton;
    EditText nameEditText, messageEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);

        sendButton = findViewById(R.id.sendButtonId);
        clearButton = findViewById(R.id.clearButtonId);

        nameEditText = findViewById(R.id.nameEditTextId);
        messageEditText = findViewById(R.id.feedbackEditTextId);

        sendButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {


        try {
            String name = nameEditText.getText().toString();
            String message = messageEditText.getText().toString();

            if (view.getId() == R.id.sendButtonId) {

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/email");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"shamsulalamrakib@gmail.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "Feedback from App");
                intent.putExtra(Intent.EXTRA_TEXT, "Name: " + name + "\n Message: " + message);
                startActivity(Intent.createChooser(intent, "Feedback with"));


            } else if (view.getId() == R.id.clearButtonId) {
                nameEditText.setText("");
                messageEditText.setText("");
            }


        } catch (Exception e) {

            Toast.makeText(getApplicationContext(), "Exception :"+e, Toast.LENGTH_SHORT).show();

        }


    }
}