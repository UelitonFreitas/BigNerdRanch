package com.origin.ueliton.criminalintent.model;

import android.content.Context;
import android.support.v4.app.FragmentActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by ueliton on 02/04/16.
 */
public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private static List<Crime> mCrimes;

    public static CrimeLab get(Context context) {
        if (sCrimeLab == null) {
            sCrimeLab = new CrimeLab(context);
        }
        return sCrimeLab;
    }

    private CrimeLab(Context context) {
        mCrimes = new ArrayList<>();
    }

    public List<Crime> getCrimes() {
        return mCrimes;
    }

    public Crime getCrime(UUID id) {
        for (Crime crime : mCrimes) {
            if (crime.getId().equals(id)) {
                return crime;
            }
        }
        return null;
    }

    public void addCrime(Crime c) {
        mCrimes.add(c);
    }

    public void deleteCrime(Crime c){
        for (int i = 0; i < mCrimes.size(); i++) {
            if (mCrimes.get(i).getId() == c.getId()) {
                mCrimes.remove(i);
            }
        }
    }

}
