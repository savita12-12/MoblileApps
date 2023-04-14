package com.example.finalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    private Button logID;
    private Button signID;
    private TextView userID;
    private SharedPreferences sp_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        logID = findViewById(R.id.logID);
        signID = findViewById(R.id.signID);
        userID = findViewById(R.id.userID);

        logID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Signup.this, Login.class);
                startActivity(i);

            }
        });

        signID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_database.edit();
                String txt1 = userID.getText().toString();
                editor.putString("key_saved_text", txt1);
                editor.commit();
                Toast.makeText(Signup.this, "Data Saved!", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Signup.this, Order .class);
                String myText =  userID.getText().toString();
                i.putExtra("TextToSend",myText);
                startActivity(i);

            }
        });
    }
}