package com.chalmers.greentips;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //Variables
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Define the hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        //Toolbar
        setSupportActionBar(toolbar);

        /*------- Navigation Drawer Menu -------*/
        //Hide or show items
        Menu menu = navigationView.getMenu();
        menu.findItem(R.id.nav_logout).setVisible(false);
        menu.findItem(R.id.nav_profile).setVisible(false);

        navigationView.bringToFront();

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_home);
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        switch(menuItem.getItemId()){
            case R.id.nav_home:
                break;

            case R.id.nav_schedule:
                Intent intent_1 = new Intent(HomeActivity.this, ScheduleActivity.class);
                startActivity(intent_1);
                break;

            case R.id.nav_tips:
                Intent intent_2 = new Intent(HomeActivity.this, DailyTipsActivity.class);
                startActivity(intent_2);
                break;

            case R.id.nav_facts:
                Intent intent_3 = new Intent(HomeActivity.this, UNFactsActivity.class);
                startActivity(intent_3);
                break;

            case R.id.nav_charity:
                Intent intent_4 = new Intent(HomeActivity.this, CharityActivity.class);
                startActivity(intent_4);
                break;

            case R.id.nav_login:
                Intent intent_5 = new Intent(HomeActivity.this, LoginActivity.class);
                startActivity(intent_5);
                break;

            case R.id.nav_share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void categoryScreen(View view) {
        startActivity(new Intent(HomeActivity.this, DailyTipsActivity.class));
    }
    public void scheduleScreen(View v){
        startActivity(new Intent(HomeActivity.this, ScheduleActivity.class));
    }
}