package com.origin.ueliton.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.origin.ueliton.criminalintent.fragment.CrimeFragment;

public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
}
