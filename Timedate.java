package com.example.maryannemillicent.myproject;

/**
 * Created by Maryanne Mwai on 3/28/2017.
 */
import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.DatePicker;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class Timedate extends Activity {

    private TextView tvDisplayTime;
    private TimePicker timePicker1;
    private Button btnSelectTime;
    private TextView tvDisplayDate;
    private DatePicker datePicker1;
    private Button btnSelectDate;

    private int hour;
    private int minute;
    private int day;
    private int month;
    private int year;


    static final int TIME_DIALOG_ID = 999;
    static final int DATE_DIALOG_ID = 899;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);

        setCurrentTimeOnView();
        setCurrentDateOnView();
        addListenerOnButton();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void setCurrentDateOnView() {

        tvDisplayDate = (TextView) findViewById(R.id.tvDate);
        datePicker1 = (DatePicker) findViewById(R.id.datepicker1);

        final Calendar c = Calendar.getInstance();
        day = c.get(Calendar.DAY_OF_MONTH);
        month = c.get(Calendar.MONTH);
        year = c.get(Calendar.YEAR);

        // set current date into textview
        tvDisplayDate.setText(new StringBuilder().append(pad(day)).append("/")
                .append(pad(month)).append("/").append(pad(year)));

        // set current date into datepicker
        datePicker1.updateDate(year,month,day);

    }
        // display current time and date

    public void setCurrentTimeOnView() {

        tvDisplayTime = (TextView) findViewById(R.id.tvTime);
        timePicker1 = (TimePicker) findViewById(R.id.timePicker1);

        final Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        // set current time into textview
        tvDisplayTime.setText(new StringBuilder().append(pad(hour)).append(":")
                .append(pad(minute)));

        // set current time into timepicker
        timePicker1.setCurrentHour(hour);
        timePicker1.setCurrentMinute(minute);
    }




    public void addListenerOnButton() {

        btnSelectDate = (Button) findViewById(R.id.btnSelectDate);

        btnSelectDate.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                showDialog(DATE_DIALOG_ID);

            }

        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID:
                return new DatePickerDialog(this,datePickerListener, day, month, year);
            case TIME_DIALOG_ID:
                // set time picker as current time
                return new TimePickerDialog(this, timePickerListener, hour, minute,
                        false);

        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int selectedDay,
                              int selectedMonth, int selectedYear) {
            day = selectedDay;
            month = selectedMonth;
            year = selectedYear;

            // set current date into textview
            tvDisplayDate.setText(new StringBuilder().append(pad(day)).append("/")
                    .append(pad(month)).append("/").append(pad(year)));


            // set current DATE into DATEpicker
            datePicker1.updateDate(year,month,day);
           // datePicker1.setCurrentDay(day);
          //  datePicker1.setCurrentMonth(month);
           // datePicker1.setCurrentYear(year);
        }
    };
    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int selectedHour,
                              int selectedMinute) {
            hour = selectedHour;
            minute = selectedMinute;

            // set current time into textview
            tvDisplayTime.setText(new StringBuilder().append(pad(hour))
                    .append(":").append(pad(minute)));

            // set current time into timepicker
            timePicker1.setCurrentHour(hour);
            timePicker1.setCurrentMinute(minute);

        }
    };


    private static String pad(int c) {
        if (c >= 10)
            return String.valueOf(c);
        else
            return "0" + String.valueOf(c);
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Timedate Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
