package com.company.Actions;

/**
 * Created by gifin_000 on 12.06.2016.
 */
public class Rotate extends Action {
    private double startAngle;
    private double endAngle;

    @Override
    public ActionType getType() {
        return ActionType.ROTATE;
    }

    public Rotate(int startTime, int endTime, double startAngle, double endAngle)
    {
        super(startTime, endTime);
        this.startAngle = startAngle;
        this.endAngle = endAngle;
    }

    public double getStartAngle()
    {
        return startAngle;
    }

    public double getEndAngle()
    {
        return endAngle;
    }

    @Override
    public String toString()
    {
        return " R,0," + getStartTime() + "," + getEndTime() + "," + getStartAngle() + "," + getEndAngle() + "\n";
    }
}
