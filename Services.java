package com.example.maryannemillicent.myproject;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Maryanne Mwai on 4/4/2017.
 */

public class Services  extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,AdapterView.OnItemSelectedListener {
    public RecyclerView recycle;

    @Override
    protected  void onCreate (Bundle SavedInstanceState) {
        super.onCreate(SavedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
