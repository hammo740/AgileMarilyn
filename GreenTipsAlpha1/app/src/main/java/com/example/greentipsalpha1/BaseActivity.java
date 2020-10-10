package com.example.greentipsalpha1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        /*ImageButton buttonLanguage = (ImageButton) findViewById(R.id.languageButton);
        buttonLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotToLanguageScreen();
            }
        });*/
    }

    /*public void gotToLanguageScreen(){
        Intent intent = new Intent(BaseActivity.this, choose_lang.class);
        startActivity(intent);
    }*/

    public void chooseLangScreen(View v){ startActivity(new Intent(this, choose_lang.class)); }

}
