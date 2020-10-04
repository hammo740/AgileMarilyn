package com.chalmers.greentips;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ScheduleActivity extends AppCompatActivity {

    private int NotificationId = 1;
    EditText editText;
    TimePicker timePicker;
    Button set, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        editText = findViewById(R.id.et);
        timePicker = findViewById(R.id.time);
        set = findViewById(R.id.btnSet);
        cancel = findViewById(R.id.btnCancel);

        final AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ScheduleActivity.this, AlarmReciever.class);
                intent.putExtra ("notificationId", NotificationId);
                intent.putExtra ("message", editText.getText().toString());
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(ScheduleActivity.this, 0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                int Hour = timePicker.getCurrentHour();
                int Minute = timePicker.getCurrentMinute();
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY,Hour);
                calendar.set(Calendar.MINUTE,Minute);
                calendar.set(Calendar.SECOND,0);

                long alarmStartTime = calendar.getTimeInMillis();
                long alarmSartTime = 0;
                alarmManager.set(AlarmManager.RTC_WAKEUP,alarmSartTime,pendingIntent);

                Toast.makeText(ScheduleActivity.this,"Done",Toast.LENGTH_SHORT).show();
            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent (ScheduleActivity.this, AlarmReciever.class);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(ScheduleActivity.this, 0,intent, PendingIntent.FLAG_CANCEL_CURRENT);
                alarmManager.cancel(pendingIntent);
                Toast.makeText(ScheduleActivity.this,"Cancel",Toast.LENGTH_SHORT).show();
            }
        });
    }
}