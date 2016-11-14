package com.company.Types;

/**
 * Created by gifin on 14.06.2016.
 */
public class TimePair
{
    private int startTime, endTime;

    public TimePair(int startTime, int endTime)
    {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public static TimePair fromDuration(int startTime, int duration)
    {
        return new TimePair(startTime, startTime + duration);
    }
}
