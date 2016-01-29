package com.example.huang.hour2app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Button;

public class ActivityB extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        //TODO: 1/26/2016 TextView - "This is Activity B"
        Intent intent = getIntent();
        Bundle bundle= intent.getBundleExtra("greetingBundle");
        String greeting = bundle.getString("greeting");
        String message = intent.getStringExtra("message");
        Boolean showAll = intent.getBooleanExtra("showAll", false);
        int numItems = intent.getIntExtra("numItems", 0);
        TextView t = (TextView) findViewById(R.id.textView);
        t.setText("This is Activity B: " +greeting+ " " +message+ " " +showAll+ " " +numItems);
        //TODO: 1/26/2016 Go to ActivityA
        //TODO: 1/26/2016 Back Back Exit
        Button b = (Button) findViewById(R.id.button);
        b.setText("Back");
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityA.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        Button getData = (Button) findViewById(R.id.button3);
        getData.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityC.class);
                startActivityForResult(intent, 1);
            }
        });

        Button input = (Button) findViewById(R.id.button4);
        input.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this,ActivityInput.class);
                startActivityForResult(intent, 0);
            }
        });
    }
       @Override
       protected void onActivityResult(int requestCode, int resultCode, Intent data){
        TextView t = (TextView)findViewById(R.id.textView);
        if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
            Bundle b = data.getBundleExtra("dataBundle");
            String hello = b.getString("data");
            int number1 = data.getIntExtra("number1", 0);
            int number2 = data.getIntExtra("number2", 0);
            t.setText("This is activity input: "+hello+" #1 "+number1+" #2 "+number2+ " #3 " +(number1+number2));
        } else if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
               String enteredData = data.getStringExtra("Data");
               t.setText(enteredData);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

}
