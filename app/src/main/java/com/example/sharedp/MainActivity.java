package com.example.sharedp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText firstname,lastname;
    Button  button;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstname = findViewById(R.id.firstname);
        lastname = findViewById(R.id.lastname);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String namefirst = firstname.getText().toString().trim();
                String namelast = lastname.getText().toString().trim();

                sharedPreferences =getSharedPreferences("key", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =sharedPreferences.edit();

                editor.putString("firstn",namefirst);
                editor.putString("lastn", namelast);

                editor.apply();

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);

            }
        });
    }
}
