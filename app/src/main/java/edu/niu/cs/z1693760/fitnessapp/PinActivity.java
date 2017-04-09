package edu.niu.cs.z1693760.fitnessapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PinActivity extends AppCompatActivity {

    TextView invalidTV;
    EditText pinET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        invalidTV = (TextView) findViewById(R.id.tokenInvalid);
        pinET = (EditText) findViewById(R.id.pinEditText);

    }

    public void continueClick(View view) {

        int pin = Integer.parseInt(pinET.getText().toString());

        if (pin != 0000) {
            invalidTV.setVisibility(View.VISIBLE);
        } else {
            Intent intent = new Intent(PinActivity.this,MainActivity.class);
            startActivity(intent);
            PinActivity.this.finish();
        }
    }
}
