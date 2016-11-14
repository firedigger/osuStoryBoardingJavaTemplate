package com.company.UtilsPackage;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gifin_000 on 10.06.2016.
 */
public class UtilClass {

    public static int osuXfix_DESIGN = 35;
    public static int osuYfix_DESIGN = 5;
    public static int osuXfix_COMPOSE = 62;
    public static int osuYfix_COMPOSE = 60;


    public static double euclidDistance(double x0, double y0, double x1, double y1)
    {
        return Math.sqrt((x0-x1)*(x0-x1) + (y0-y1)*(y0-y1));
    }

    public static double degToRad(double deg)
    {
        return Math.toRadians(deg);
    }


    public static int parseOffset(String time)
    {
        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss:SSS");
        try {
            Date date = sdf.parse(time);
            return (int) (date.getTime() - sdf.parse("00:00:000").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }


    public static void addosufix_DESIGN(int[] xs, int[] ys)
    {
        for(int i = 0; i < xs.length; ++i)
        {
            xs[i] += osuXfix_DESIGN;
            ys[i] += osuYfix_DESIGN;
        }
    }

    public static void addosufix_COMPOSE(int[] xs, int[] ys)
    {
        for(int i = 0; i < xs.length; ++i)
        {
            xs[i] += osuXfix_COMPOSE;
            ys[i] += osuYfix_COMPOSE;
        }
    }

}
