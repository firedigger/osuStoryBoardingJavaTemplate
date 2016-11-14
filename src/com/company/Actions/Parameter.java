package com.company.Actions;

/**
 * Created by gifin on 21.08.2016.
 */
public class Parameter extends Action
{
    public Parameter(int startTime, int endTime, ParameterType parameterType)
    {
        super(startTime, endTime);
        this.parameterType = parameterType;
    }

    private ParameterType parameterType;

    @Override
    public ActionType getType()
    {
        return ActionType.PARAMETER;
    }

    @Override
    public String toString()
    {
        return " P,0," + getStartTime() + "," + getEndTime() + "," + parameterType.toString() + "\n";
    }
}
