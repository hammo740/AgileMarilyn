package com.example.greentipsalpha1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        /*ImageButton buttonLanguage = (ImageButton) findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });*/
    }

    /*public void gotToLanguageScreen(){
        Intent intent = new Intent(welcome.this, choose_lang.class);
        startActivity(intent);
    }*/

    public void chooseLangScreen(View v){ startActivity(new Intent(welcome.this, choose_lang.class)); }

    public void aboutScreen(View v){
        startActivity(new Intent(welcome.this, about.class));
    }

    public void helpScreen(View v){
        startActivity(new Intent(welcome.this, help.class));
    }

    public void categoryScreen(View v){ startActivity(new Intent(welcome.this, choose_category.class)); }

    public void scheduleScreen(View v){ startActivity(new Intent(welcome.this, schedule.class)); }


}