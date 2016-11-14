package com.company.Actions;

/**
 * Created by gifin_000 on 12.06.2016.
 */
public class Scale extends Action {
    private double startScale;
    private double endScale;

    @Override
    public ActionType getType() {
        return ActionType.SCALE;
    }

    public Scale(int startTime, int endTime, double startScale, double endScale)
    {
        super(startTime, endTime);
        this.startScale = startScale;
        this.endScale = endScale;
    }

    public double getStartScale()
    {
        return startScale;
    }

    public double getEndScale()
    {
        return endScale;
    }

    @Override
    public String toString()
    {
        return " S,0," + getStartTime() + "," + getEndTime() + "," + getStartScale() + "," + getEndScale() + "\n";
    }
}
