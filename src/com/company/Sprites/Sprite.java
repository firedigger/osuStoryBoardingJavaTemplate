package com.company.Sprites;

import com.company.Actions.*;
import com.company.Types.ColorType;
import com.company.Types.Layer;
import com.company.Types.Origin;
import com.company.Types.TimePair;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DELL on 2/7/2016.
 */
public class Sprite {

    private String filepath;
    private Layer layer;
    private Origin origin;
    private int startX;
    private int startY;

    private List<Action> actions;

    public Sprite(String filepath, Layer layer, Origin origin)
    {
        this(filepath,layer,origin,0,0);
    }

    public Sprite(String filepath)
    {
        this(filepath,Layer.Foreground,Origin.Centre,0,0);
    }

    public static Action parseAction(String code)
    {
        throw new NotImplementedException();
    }

    public Sprite(String code, boolean a)
    {
        actions = new ArrayList<>();
        String[] codes = code.split("\n");

        for(String c : codes)
            actions.add(parseAction(c));
    }

    public Sprite(String filepath, Layer layer, Origin origin, int X, int Y)
    {
        this.filepath = filepath;
        this.layer = layer;
        this.origin = origin;
        this.startX = X;
        this.startY = Y;

        this.actions = new ArrayList<>();
    }

    public Sprite(Sprite other, boolean copyActions)
    {
        this.filepath = other.filepath;
        this.layer = other.layer;
        this.origin = other.origin;

        this.actions = copyActions ? other.actions : new ArrayList<>();
    }

    public Sprite addAction(Action action)
    {
        actions.add(action);
        return this;
    }

    public Sprite addActions(Collection<Action> actions)
    {
        this.actions.addAll(actions);
        return this;
    }

    public Sprite staticScale(double scale)
    {
        addAction(new Scale(getStartLifetime(), getEndLifetime(), scale, scale));
        return this;
    }

    public Sprite staticColor(ColorType color)
    {
        addAction(new Color(new TimePair(getStartLifetime(), getEndLifetime()), color));
        return this;
    }

    public Sprite staticFade(double fade)
    {
        addAction(new Fade(getStartLifetime(), getEndLifetime(), fade, fade));
        return this;
    }

    public Sprite addFadeIn(int duration, double fadeStart, double fadeEnd)
    {
        addAction(new Fade(getStartLifetime() - duration, getStartLifetime(), fadeStart, fadeEnd));
        return this;
    }

    public Sprite addFadeOut(int duration, double fadeStart, double fadeEnd)
    {
        addAction(new Fade(getEndLifetime(), getEndLifetime() + duration, fadeStart, fadeEnd));
        return this;
    }

    public int getStartLifetime()
    {
        int min = Integer.MAX_VALUE;
        for(Action action : actions)
            if (action.getStartTime() < min)
                min = action.getStartTime();

        return min;
    }

    public int getEndLifetime()
    {
        int max = Integer.MIN_VALUE;
        for(Action action : actions)
            if (action.getEndTime() > max)
                max = action.getEndTime();

        return max;
    }

    public List<Action> getActions()
    {
        return actions;
    }

    public String toString()
    {
        String res = "Sprite," + layer.toString() + "," + origin.toString() + "," + filepath + "," + startX + "," + startY + "\n";
        for(Action action : actions)
        {
            res += action.toString();
        }
        return res;
    }

    public Sprite staticAngle(double angle)
    {
        addAction(new Rotate(getStartLifetime(), getEndLifetime(), angle, angle));
        return this;
    }
}