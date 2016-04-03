package com.origin.ueliton.criminalintent.activity;

import android.support.v4.app.Fragment;

import com.origin.ueliton.criminalintent.fragment.CrimeListFragment;

/**
 * Created by ueliton on 02/04/16.
 */
public class CrimeListActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return  new CrimeListFragment();
    }
}
