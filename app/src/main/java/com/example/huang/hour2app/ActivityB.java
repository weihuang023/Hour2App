package com.example.huang.hour2app;

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
        // TODO: 1/27/2016 Activity B displaying as an option to handle the browser Action_Send

    }
}
