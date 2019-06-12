package com.example.buzzerbets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class balanceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balance);
        Button betBtn = (Button) findViewById(R.id.betBtn);
        betBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText firstNumEditText = (EditText) findViewById(R.id.firstNumEditText);
//                String num1 = firstNumEditText.getText().toString();
//                Intent startIntent = new Intent(getApplicationContext(), gameActivity.class);
//                startIntent.putExtra("unique.SOMETHING",num1);
//                startActivity(startIntent);
            }
        });
    }
}
