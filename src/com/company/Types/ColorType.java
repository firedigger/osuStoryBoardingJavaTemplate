package com.company.Types;

/**
 * Created by gifin on 14.06.2016.
 */
public class ColorType
{
    private int r,g,b;

    public ColorType(int r, int g, int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public int getR()
    {
        return r;
    }

    public int getG()
    {
        return g;
    }

    public int getB()
    {
        return b;
    }

    public static ColorType Red = new ColorType(255,0,0);
    public static ColorType Green = new ColorType(0,255,0);
    public static ColorType Blue = new ColorType(0,0,255);
    public static ColorType Yellow = new ColorType(255,255,0);
    public static ColorType White = new ColorType(255,255,255);
    public static ColorType Purple = new ColorType(90, 0, 157);
}
