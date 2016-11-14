package com.company.Actions;

/**
 * Created by gifin_000 on 11.06.2016.
 */
public class Fade extends Action {

    private double startFade;
    private double endFade;

    @Override
    public ActionType getType() {
        return ActionType.FADE;
    }

    public Fade(int startTime, int endTime, double startFade, double endFade)
    {
        super(startTime, endTime);
        this.startFade = startFade;
        this.endFade = endFade;
    }

    public double getStartFade()
    {
        return startFade;
    }

    public double getEndFade()
    {
        return endFade;
    }

    @Override
    public String toString()
    {
        return " F,0," + getStartTime() + "," + getEndTime() + "," + getStartFade() + "," + Double.toString(getEndFade()) + "\n";
    }
}
