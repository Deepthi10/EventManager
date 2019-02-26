package edu.ecu.cs.eventapp;

import android.content.Context;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jakayla on 9/21/2017.
 */

public class EventHub {
    private static EventHub sEventHub;

    private List<Event> mEvents;

    public static EventHub get(Context context)
    {
        if(sEventHub == null)
        {
            sEventHub = new EventHub(context);
        }

        return sEventHub;
    }

    private EventHub(Context context)
    {
        mEvents = new ArrayList<>();
        for(int i = 0; i < 100; i++)
        {
            Event event = new Event();
            event.setmEventName("Event #" + i);
            event.setmEventDate(new Date());
            event.setmLocation("Location #" + i);
            mEvents.add(event);
        }
    }

    public List<Event> getEvents()
    {
        return mEvents;
    }

    public Event getEvent(UUID id)
    {
        for(Event event : mEvents){
            if(event.getmId().equals(id))
            {
                return event;
            }
        }
        return null;
    }
}
