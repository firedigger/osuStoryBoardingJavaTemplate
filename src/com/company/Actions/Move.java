package com.company.Actions;

import com.company.Types.CoordType;

/**
 * Created by gifin_000 on 11.06.2016.
 */
public class Move extends Action
{
    private int startX;
    private int endX;
    private int startY;
    private int endY;

    @Override
    public ActionType getType() {
        return ActionType.MOVE;
    }

    public Move(int startTime, int endTime, int startX, int startY, int endX, int endY)
    {
        super(startTime, endTime);
        this.startX = startX;
        this.endX = endX;
        this.startY = startY;
        this.endY = endY;
    }

    public Move(int startTime, int endTime, CoordType start, CoordType end)
    {
        super(startTime, endTime);
        this.startX = start.getX();
        this.startY = start.getY();
        this.endX = end.getX();
        this.endY = end.getY();
    }

    public int getStartX()
    {
        return startX;
    }

    public int getEndX()
    {
        return endX;
    }

    public int getStartY()
    {
        return startY;
    }

    public int getEndY()
    {
        return endY;
    }

    @Override
    public String toString()
    {
        return " M,0," + getStartTime() + "," + getEndTime() + "," + getStartX() + "," + getStartY() + "," + getEndX() + "," + getEndY() + "\n";
    }
}
