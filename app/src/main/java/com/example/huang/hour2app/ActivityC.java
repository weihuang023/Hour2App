package com.example.huang.hour2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Button;

public class ActivityC extends AppCompatActivity {

    // TODO: 1/27/2016 Add send button here
    // TODO: 1/27/2016 Add send button here

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c_layout);
        setTitle("ActivityC");

        final EditText e = (EditText) findViewById(R.id.editText);
        Button cancel = (Button) findViewById(R.id.button1);
        Button send = (Button) findViewById(R.id.button2);

        send.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent result = new Intent();
                result.putExtra("Data", e.getText().toString());
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });

        cancel.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                setResult(Activity.RESULT_CANCELED);
                finish();
            }
        });
    }
}
