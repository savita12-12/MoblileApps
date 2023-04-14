package com.example.finalprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private Button loginID;
    private Button signupID;
    private ImageView googleID;
    private EditText passID;
    private EditText userID;
    private ImageView faceID;
    private ImageView twitID;

    private SharedPreferences sp_database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginID = findViewById(R.id.loginID);
        signupID = findViewById(R.id.signupID);
        googleID = findViewById(R.id.googleID);
        faceID = findViewById(R.id.faceID);
        twitID = findViewById(R.id.twitID);
        passID = findViewById(R.id.passID);
        userID = findViewById(R.id.userID);


        loginID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Order .class);
                startActivity(i);

            }
        });

        signupID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Login.this, Signup.class);
                startActivity(i);

            }
        });

        loginID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp_database = getApplicationContext().getSharedPreferences("table_store_text", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp_database.edit();
                String txt1 = userID.getText().toString();
                String txt2 = passID.getText().toString();
                editor.putString("key_saved_text", txt1);
                editor.putString("key_saved_text", txt2);
                editor.commit();
                Toast.makeText(Login.this, "Data Saved!", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(Login.this, Order.class);
                String myText =  userID.getText().toString();
                i.putExtra("TextToSend",myText);
                startActivity(i);



            }
        });
    }
}