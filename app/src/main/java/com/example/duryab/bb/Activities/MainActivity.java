package com.example.duryab.bb.Activities;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.duryab.bb.Database.DBHelper;
import com.example.duryab.bb.R;

public class MainActivity extends AppCompatActivity {
    Button LogInButton;
    Button RegisterButton ;
    EditText Email, Password ;
    static String EmailHolder, PasswordHolder;
    static Boolean EditTextEmptyHolder;
    SQLiteDatabase sqLiteDatabaseObj;
    DBHelper sqLiteHelper;
    Cursor cursor;
    String TempPassword = "NOT_FOUND" ;
    public static final String UserEmail = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        LogInButton = (Button)findViewById(R.id.loginBtn);

        RegisterButton = (Button)findViewById(R.id.createAccount);

        Email = (EditText)findViewById(R.id.login_emailid);
        Password = (EditText)findViewById(R.id.login_password);

        sqLiteHelper = new DBHelper(this);

        //Adding click listener to log in button.
        LogInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Calling EditText is empty or no method.
                CheckEditTextStatus();

                // Calling login method.
                LoginFunction();


            }
        });

        // Adding click listener to register button.
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Opening new user registration activity using intent on button click.
                Intent intent1 = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent1);

            }
        });

    }

    // Login function starts from here.
    public void LoginFunction(){

       if(EditTextEmptyHolder) {
/*
            // Opening SQLite database write permission.
            sqLiteDatabaseObj = sqLiteHelper.getWritableDatabase();

            // Adding search email query to cursor.
            cursor = sqLiteDatabaseObj.query(DBHelper.TABLE_NAME, null, " " + DBHelper.EMAIL + "=?", new String[]{EmailHolder}, null, null, null);

            while (cursor.moveToNext()) {

                if (cursor.isFirst()) {

                    cursor.moveToFirst();

                    // Storing Password associated with entered email.
                    TempPassword = cursor.getString(cursor.getColumnIndex(DBHelper.PASS));

                    // Closing cursor.
                    cursor.close();
                }
            }*/

            // Calling method to check final result ..
            CheckFinalResult();

        }
        else {

            //If any of login EditText empty then this block will be executed.
            Toast.makeText(this,"Please Enter UserName or Password.",Toast.LENGTH_LONG).show();

        }

    }

    // Checking EditText is empty or not.
    public void CheckEditTextStatus(){

        // Getting value from All EditText and storing into String Variables.
        EmailHolder = Email.getText().toString();
        PasswordHolder = Password.getText().toString();

        // Checking EditText is empty or no using TextUtils.
        if( TextUtils.isEmpty(EmailHolder) || TextUtils.isEmpty(PasswordHolder)){

            EditTextEmptyHolder = false ;

        }
        else {

            EditTextEmptyHolder = true ;
        }
    }

    // Checking entered password from SQLite database email associated password.
    public void CheckFinalResult(){

     //   if(TempPassword.equalsIgnoreCase(PasswordHolder))
       // {

            Toast.makeText(this,"Login Successfully",Toast.LENGTH_LONG).show();

            // Going to Dashboard activity after login success message.
            Intent intent3 = new Intent(this, HomeActivity.class);

            // Sending Email to Dashboard Activity using intent.
            intent3.putExtra(UserEmail, EmailHolder);

            startActivity(intent3);


        //}
        //else {

//            Toast.makeText(this,"UserName or Password is Wrong, Please Try Again.",Toast.LENGTH_LONG).show();

//        }
        TempPassword = "NOT_FOUND" ;

    }

}

