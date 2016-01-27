package com.example.huang.hour2app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        setTitle("ActivityA");
        Button b = (Button) findViewById(R.id.button);
        //TODO Go to ActivityB
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
    }
}
