package com.example.buzzerbets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class gameActivity extends AppCompatActivity {
    int num2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Button betBtn = (Button) findViewById(R.id.betBtn);
        betBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (getIntent().hasExtra("unique.SOMETHING")) {
////            TextView tv = (TextView) findViewById(R.id.textview);
//                    String text = getIntent().getExtras().getString("unique");
////            tv.setText(text);
//                    int num2 = Integer.parseInt(text);
//                }
//                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
//                TextView resultTextView = (TextView) findViewById(R.id.resultTextView);
//                int num1 = Integer.parseInt(firstNumEditText.getText().toString());
//                int result = num2 - num1;
//                resultTextView.setText(result + "");
            }
        });
    }
}
