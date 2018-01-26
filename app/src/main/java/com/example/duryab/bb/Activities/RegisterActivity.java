package com.example.duryab.bb.Activities;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duryab.bb.Database.DBHelper;
import com.example.duryab.bb.R;
import com.example.duryab.bb.UserRegister;

/**
 * Created by duryab on 1/26/18.
 */

public class RegisterActivity extends AppCompatActivity {
    Button SignInButton;
    EditText name,email,password,address,phone,blood ;
    SQLiteDatabase sqLiteDatabaseObj;
    DBHelper dbHelper;
    Cursor cursor;
    String name1,pass1,phone1,blood1,add1,email1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        SignInButton = (Button)findViewById(R.id.siginBtn);

        email = (EditText)findViewById(R.id.signin_email);
        password = (EditText)findViewById(R.id.password);
        name = (EditText)findViewById(R.id.signin_name);
        phone = (EditText)findViewById(R.id.signin_phone);
        address = (EditText)findViewById(R.id.signin_address);
        blood = (EditText)findViewById(R.id.signin_blood);

        dbHelper = new DBHelper(this);

        //Adding click listener to log in button.
        SignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SignUp();

            }
        });

    }

    // Login function starts from here.
    public void SignUp() {

        //UserRegister user = new UserRegister();

        name1 = name.getText().toString();
        email1 = email.getText().toString();
        phone1 = phone.getText().toString();
        add1 = address.getText().toString();
        blood1 = blood.getText().toString();
        pass1 = password.getText().toString();

        //Toast.makeText(MainActivity.this,name, Toast.LENGTH_SHORT).show();
        if (name1.isEmpty() || email1.isEmpty() || phone1.isEmpty() || add1.isEmpty() || blood1.isEmpty() || pass1.isEmpty()) {

            Toast.makeText(this, "please fill details", Toast.LENGTH_SHORT).show();
        } else {

            dbHelper.insert(name1, email1, add1, blood1, phone1, pass1);
            name.setText("");
            email.setText("");
            phone.setText("");
            address.setText("");
            blood.setText("");
            password.setText("");

            Intent intent2 = new Intent(this, HomeActivity.class);
            startActivity(intent2);

        }
    }

}
