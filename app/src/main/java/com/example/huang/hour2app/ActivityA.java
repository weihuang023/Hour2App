package com.example.huang.hour2app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        setTitle("ActivityA");

        Button b = (Button) findViewById(R.id.button);
        //TODO: 1/26/2016 Go to ActivityB
        //TODO: 1/26/2016 Intent add data to Activity B
        b.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this,ActivityB.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Bundle b = new Bundle();
                b.putString("greeting","Hello");
                intent.putExtra("greetingBundle",b);
                intent.putExtra("message","World");
                intent.putExtra("showAll",true);
                intent.putExtra("numItems", 5);
                startActivity(intent);
            }
        });

        Button getData = (Button) findViewById(R.id.button3);
        getData.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this,ActivityC.class);
                startActivityForResult(intent, 1);
            }
        });

        Button input = (Button) findViewById(R.id.button4);
        input.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityInput.class);
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
            int number1 = data.getIntExtra("number1",0);
            int number2 = data.getIntExtra("number2",0);
            t.setText("This is activity input: "+hello+" #1 "+number1+" #2 "+number2+ " #3 " +(number1+number2));
        } else if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String enteredData = data.getStringExtra("Data");
            t.setText(enteredData);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
