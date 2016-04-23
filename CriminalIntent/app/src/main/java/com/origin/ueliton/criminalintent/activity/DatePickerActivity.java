package com.origin.ueliton.criminalintent.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.origin.ueliton.criminalintent.fragment.DatePickerFragment;

import java.util.Date;

/**
 * Created by ueliton on 21/04/16.
 */
public class DatePickerActivity extends SingleFragmentActivity {

    private static final String CRIME_DATE = "crime_date";
    private Date mCrimeDate;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        mCrimeDate = (Date) getIntent().getSerializableExtra(CRIME_DATE);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected Fragment createFragment() {
        return DatePickerFragment.newInstance(mCrimeDate);
    }

    public static Intent getIntent(Context context, Date date){

        Intent intent = new Intent(context, DatePickerActivity.class);
        intent.putExtra(CRIME_DATE, date);
        return intent;
    }
}
