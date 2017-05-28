package com.example.rhm.rhmandroidapp;

import android.app.FragmentManager;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import rhm.com.fragment.gallery;
import rhm.com.fragment.main;
import rhm.com.fragment.booking;
import rhm.com.fragment.room;
import rhm.com.fragment.hotel;
import rhm.com.fragment.login;
import rhm.com.fragment.logout;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //On rajoute du code pour gérer nos fragments
        FragmentManager fragMan = getFragmentManager();
        fragMan.beginTransaction().replace(R.id.content_frame, new main()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fragMan = getFragmentManager();
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.content_frame) {
            fragMan.beginTransaction().replace(R.id.content_frame, new main()).commit();
        } else if (id == R.id.nav_gallery) {
            fragMan.beginTransaction().replace(R.id.content_frame, new gallery()).commit();
        } else if (id == R.id.nav_book) {
            fragMan.beginTransaction().replace(R.id.content_frame, new booking()).commit();
        } else if (id == R.id.nav_room) {
            fragMan.beginTransaction().replace(R.id.content_frame, new room()).commit();
        }else if (id == R.id.nav_hotel) {
            fragMan.beginTransaction().replace(R.id.content_frame, new hotel()).commit();
        } else if (id == R.id.nav_login) {
            fragMan.beginTransaction().replace(R.id.content_frame, new login()).commit();
        } else if (id == R.id.nav_logout) {
            fragMan.beginTransaction().replace(R.id.content_frame, new logout()).commit();
        } /*else if (id == R.id.nav_send) {
            fragMan.beginTransaction().replace(R.id.content_frame, new main_fragment()).commit();
        }*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
