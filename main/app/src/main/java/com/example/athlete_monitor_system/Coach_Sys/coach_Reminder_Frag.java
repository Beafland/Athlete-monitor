package com.example.athlete_monitor_system.Coach_Sys;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.CalendarContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.athlete_monitor_system.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;


public class coach_Reminder_Frag extends Fragment implements View.OnClickListener {
    private int mYear;
    private int mMonth;
    private int mDay;
    private int mHour;
    private int mMinute;
    private EditText date;
    private EditText time;
    private EditText content;
    private Button submit;

    private String title;

    private static String CALENDAR_URL = "content://com.android.calendar/calendars";
    private static String CALENDAR_EVENT_URL = "content://com.android.calendar/events";
    private static String CALENDAR_REMINDER_URL = "content://com.android.calendar/reminders";

    private static String CALENDARS_NAME = "test";
    private static String CALENDARS_ACCOUNT_NAME = "test@test.com";
    private static String CALENDARS_ACCOUNT_TYPE = "com.android.test";
    private static String CALENDARS_DISPLAY_NAME = "test";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.activity_add_reminder, container, false);
        content = root.findViewById(R.id.reminder_content);
        date = root.findViewById(R.id.reminder_date);
        time = root.findViewById(R.id.reminder_time);
        submit = root.findViewById(R.id.reminder_submit);
        date.setOnClickListener(this);
        time.setOnClickListener(this);
        submit.setOnClickListener(this);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public void onClick(View v) {
        if (v == date) {
            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(this.getContext(),
                    new DatePickerDialog.OnDateSetListener() {

                        @Override
                        public void onDateSet(DatePicker view, int year,
                                              int monthOfYear, int dayOfMonth) {

                            date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                        }
                    }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (v == time) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHour = c.get(Calendar.HOUR_OF_DAY);
            mMinute = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(this.getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {

                            time.setText(hourOfDay + ":" + minute);
                        }
                    }, mHour, mMinute, false);
            timePickerDialog.show();
        }
        if (v == submit) {
            title = content.getText().toString();
            String date_str = date.getText().toString();
            String time_str = time.getText().toString();

            if (title.equals("")) {
                content.setError("Content can't be empty");
                return;
            }
            if (date_str.equals("")) {
                date.setError("Date can't be empty");
                return;
            }
            if (time_str.equals("")) {
                time.setError("Time can't be empty");
                return;
            }

            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
            String dateString = String.format("%02d/%02d/%d %02d:%02d:00", mDay, mMonth+1, mYear, mHour, mMinute);
            final Calendar c = Calendar.getInstance();

            try {
                c.setTime(Objects.requireNonNull(format.parse(dateString)));
                long start_millisec = c.getTimeInMillis();
                fetchPermission(1, start_millisec);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
    }


    public void fetchPermission(int requestCode, long start_millisec) {
        int checkSelfPermission;
        try {
            checkSelfPermission = ActivityCompat.checkSelfPermission(this.getContext(), Manifest.permission.WRITE_CALENDAR);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return;
        }


        if (checkSelfPermission == PackageManager.PERMISSION_GRANTED) {
            insertCalendar(start_millisec);
        } else {
            ActivityCompat.requestPermissions(this.getActivity(), new String[]{Manifest.permission.WRITE_CALENDAR,
                    Manifest.permission.READ_CALENDAR}, requestCode);
        }
    }



    public void insertCalendar(long start_millisec) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, "Gym")
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, start_millisec)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, start_millisec + 1800000);
        if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivity(intent);
        }
    }



}