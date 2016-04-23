package com.origin.ueliton.criminalintent.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;


import com.origin.ueliton.criminalintent.R;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ueliton on 18/04/16.
 */
public class TimerPickerFragment extends DialogFragment {

    private static final String ARG_TIME = "time";
    private TimePicker mTimePicker;
    public static final String EXTRA_TIME = "com.origin.ueliton.criminalintent.time";


    public static TimerPickerFragment newInstance(Date date){

        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_TIME, date);

        TimerPickerFragment timerPickerFragment = new TimerPickerFragment();
        timerPickerFragment.setArguments(bundle);
        return timerPickerFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);

        Date date = (Date) getArguments().getSerializable(ARG_TIME);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        View view = LayoutInflater.from(getContext()).inflate(R.layout.dialog_time, null);

        mTimePicker = (TimePicker) view.findViewById(R.id.timer_picker_time);
        mTimePicker.is24HourView();
        mTimePicker.setCurrentHour(calendar.get(Calendar.HOUR));
        mTimePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setTitle("Hours")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Calendar calendar = Calendar.getInstance();
                        calendar.set(Calendar.HOUR, mTimePicker.getCurrentHour());
                        calendar.set(Calendar.MINUTE, mTimePicker.getCurrentMinute());
                        sendResult(Activity.RESULT_OK, calendar.getTime());
                    }
                })
                .create();
    }

    private void sendResult(int resultCode, Date date) {

        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, date);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
