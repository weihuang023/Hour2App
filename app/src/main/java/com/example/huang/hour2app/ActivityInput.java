package com.example.huang.hour2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class ActivityInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        setTitle("Activity Input");

        final EditText number1 = (EditText) findViewById(R.id.numEditText1);
        final EditText number2 = (EditText) findViewById(R.id.numEditText2);

        Button add = (Button) findViewById(R.id.button1);
        add.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO: 1/28/2016 Add button here
                Intent result = new Intent();
                result.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle b = new Bundle();
                b.putString("data", "Hello World!");
                result.putExtra("dataBundle",b);
                try {
                    result.putExtra("number1", Integer.parseInt(number1.getText().toString()));
                    result.putExtra("number2", Integer.parseInt(number2.getText().toString()));
                } catch (NumberFormatException nfe) {
                    System.out.println("Could not parse " + nfe);
                }
                setResult(Activity.RESULT_OK, result);
                finish();
            }
        });
    }
}
