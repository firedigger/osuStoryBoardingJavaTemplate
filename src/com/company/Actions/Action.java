package com.company.Actions;

import com.company.Types.TimePair;

/**
 * Created by gifin_000 on 11.06.2016.
 */
public abstract class Action {

    private TimePair time;

    protected Action(int startTime, int endTime)
    {
        this.time = new TimePair(startTime, endTime);
    }

    protected Action(TimePair time)
    {
        this.time = time;
    }

    public abstract ActionType getType();

    public int getStartTime()
    {
        return time.getStartTime();
    }

    public int getEndTime()
    {
        return time.getEndTime();
    }

    public abstract String toString();

}
