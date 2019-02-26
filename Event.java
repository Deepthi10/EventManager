package edu.ecu.cs.eventapp;

import java.util.Date;
import java.util.UUID;

/**
 * Created by Jakayla on 9/21/2017.
 */

public class Event {
    String mEventName;
    Date mEventDate;
    String mLocation;
    UUID mId;

    public Event()
    {
        mId = UUID.randomUUID();
        mEventDate = new Date();
    }

    public String getmEventName() {
        return mEventName;
    }

    public void setmEventName(String mEventName) {
        this.mEventName = mEventName;
    }

    public Date getmEventDate() {
        return mEventDate;
    }

    public void setmEventDate(Date mEventDate) {
        this.mEventDate = mEventDate;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public UUID getmId() {
        return mId;
    }
}
