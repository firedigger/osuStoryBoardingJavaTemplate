package com.company.Actions;

import com.company.Types.ColorType;
import com.company.Types.TimePair;

/**
 * Created by gifin_000 on 12.06.2016.
 */
public class Color extends Action {

    private ColorType startColor, endColor;

    @Override
    public ActionType getType() {
        return ActionType.COLOR;
    }

    public Color(int startTime, int endTime, int r, int g, int b, int r1, int g1, int b1)
    {
        super(startTime, endTime);
        startColor = new ColorType(r,g,b);
        endColor = new ColorType(r1,g1,b1);
    }

    public Color(TimePair time, ColorType start, ColorType end)
    {
        super(time);
        startColor = start;
        endColor = end;
    }

    public Color(TimePair time, ColorType color)
    {
        super(time);
        startColor = color;
        endColor = color;
    }

    public int getStartR()
    {
        return startColor.getR();
    }

    public int getStartG()
    {
        return startColor.getG();
    }

    public int getStartB()
    {
        return startColor.getB();
    }

    public int getEndR()
    {
        return endColor.getR();
    }

    public int getEndG()
    {
        return endColor.getG();
    }

    public int getEndB()
    {
        return endColor.getB();
    }

    @Override
    public String toString()
    {
        return " C,0," + getStartTime() + "," + getEndTime() + "," + getStartR() + "," + getStartG() + "," + getStartB() + "," + getEndR() + "," + getEndG() + "," + getEndB()  + "\n";
    }
}
