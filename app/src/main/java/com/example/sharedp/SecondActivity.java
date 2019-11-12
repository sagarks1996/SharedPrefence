package com.example.sharedp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    TextView fname,lname;
    SharedPreferences sharedPreferences;
    RatingBar ratingBar;
    Button button1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);



        sharedPreferences = getSharedPreferences("key",MODE_PRIVATE);

        String namef = sharedPreferences.getString("firstn","");
        fname.setText(namef);

        String namel = sharedPreferences.getString("lastn","");
        lname.setText(namel);

        ratingBar = findViewById(R.id.ratingbar);
        button1 = findViewById(R.id.button1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String totalstar = "Total Rating :"+ratingBar.getNumStars();
                String rating = "Rating :"+ratingBar.getRating();

                Toast.makeText(getApplicationContext(),totalstar+"\n"+rating,Toast.LENGTH_SHORT).show();
            }
        });



    }
}
