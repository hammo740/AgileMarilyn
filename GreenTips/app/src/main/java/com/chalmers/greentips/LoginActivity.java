package com.chalmers.greentips;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends HomeActivity {

    private EditText eName, ePassword;
    private Button elogin;
    private TextView eAttemptsInfo;

    private final String Username = "admin";
    private final String Password = "music";

    private boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        eName = findViewById(R.id.username_login);
        ePassword = findViewById(R.id.password_login);
        elogin = findViewById(R.id.button_login);
        eAttemptsInfo = findViewById(R.id.attempts_login);

        elogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please enter all details correctly!",Toast.LENGTH_SHORT).show();
                } else {

                    isValid = validate(inputName, inputPassword);

                    if (!isValid) {

                        counter--;
                        Toast.makeText(LoginActivity.this, "Incorrect credentials entered! ", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("No. of attempts remaining: " + counter);

                        if(counter == 0){
                            elogin.setEnabled(false);
                        }

                    } else {
                        Toast.makeText(LoginActivity.this, "Login was successful!", Toast.LENGTH_SHORT).show();

                        counter = 5;
                        //Add the code to new activity
                        Intent intent = new Intent(LoginActivity.this, DatabaseActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String username, String password){

        if(username.equals(Username) && password.equals(Password)){
            return true;
        }
        return false;
    }
}