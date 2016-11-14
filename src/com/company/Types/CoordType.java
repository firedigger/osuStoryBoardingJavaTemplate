package com.company.Types;

/**
 * Created by gifin on 14.06.2016.
 */
public class CoordType
{
    private int x,y;

    public CoordType(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static CoordType Zero = new CoordType(0,0);
    public static CoordType Center = new CoordType(320,240);
}
