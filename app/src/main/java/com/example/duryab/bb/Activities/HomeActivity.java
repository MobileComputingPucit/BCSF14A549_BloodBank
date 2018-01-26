package com.example.duryab.bb.Activities;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;

import com.example.duryab.bb.Adapters.DataAdapter;
import com.example.duryab.bb.Database.DBHelper;
import com.example.duryab.bb.R;
import com.example.duryab.bb.UserRegister;

import java.util.ArrayList;
import java.util.List;


public class HomeActivity extends AppCompatActivity {
    DataAdapter dataAdapter;
    RecyclerView recyclerView;
    DBHelper DB_Helper;
    List arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        DB_Helper = new DBHelper(this);

            arrayList = DB_Helper.getdata();

            recyclerView = (RecyclerView) findViewById(R.id.rec);
            dataAdapter = new DataAdapter(this, arrayList);

            LinearLayoutManager llm = new LinearLayoutManager(this);
            llm.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(llm);

            recyclerView.setAdapter(dataAdapter);

    }
}
