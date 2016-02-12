package com.origin.ueliton.criminalintent.model;

import java.util.UUID;

/**
 * Created by ueliton on 11/02/2016.
 */
public class Crime {

    private UUID mId;
    private String mTitle;

    public UUID getId() {
        return mId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String tittle) {
        mTitle = tittle;
    }

    public Crime() {
        mId = UUID.randomUUID();
    }
}
