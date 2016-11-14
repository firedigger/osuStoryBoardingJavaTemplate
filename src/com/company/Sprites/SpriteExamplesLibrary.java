package com.company.Sprites;

import com.company.Actions.*;
import com.company.Types.*;
import com.company.UtilsPackage.UtilClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by gifin_000 on 10.06.2016.
 */
public class SpriteExamplesLibrary {


    public static Move timeLapseMove(Move move, int time)
    {
        double coeff = (move.getEndY() - move.getStartY()) * 1.0 / (move.getEndX() - move.getStartX());

        int fixX = time;
        int fixY = ((int)coeff * time);

        return new Move(move.getStartTime(), move.getEndTime(), move.getStartX() - fixX, move.getStartY() - fixY, move.getEndX() - fixX, move.getEndY() - fixY);
    }

    public static Rotate timeLapseRotate(Rotate rotate, int time)
    {
        double fixAngle = time;
        return new Rotate(rotate.getStartTime(), rotate.getEndTime(), rotate.getStartAngle() - fixAngle, rotate.getEndAngle() - fixAngle);
    }

    /*public static List<Sprites> addTrail(Sprites sprite, int count)
    {
        List<Sprites> res = new ArrayList<>();
        for(int i = 0; i < count; ++i)
        {
            Sprites f = new Sprites(sprite,false);
            double fade = 1 - i * 1.0 / (count + 1);
            double scale = 1;
            int time = i * 100;
            for(Action action : sprite.getActions())
            {
                switch (action.getType())
                {
                    case MOVE: f.addAction(timeLapseMove((Move)action,time)); break;
                    case FADE: f.addAction(new Fade(action.getStartTime(), action.getEndTime(), ((Fade)action).getStartFade() * fade,((Fade)action).getEndFade() * fade)); break;
                    case SCALE: f.addAction(new Scale(action.getStartTime(), action.getEndTime(), ((Scale)action).getStartScale() * scale,((Scale)action).getEndScale() * scale)); break;
                    case COLOR: break;
                    case ROTATE: f.addAction(timeLapseRotate((Rotate) action,time)); break;
                }
            }
            res.add(f);
        }
        return res;
    }*/

    public static List<Sprite> addTrail(Sprite sprite, int count, double timeCoeff)
    {
        List<Sprite> res = new ArrayList<>();
        for(int i = 0; i < count; ++i)
        {
            Sprite f = new Sprite(sprite,false);
            double fade = 1 - i * 1.0 / (count + 1);
            double scale = 1;
            int time = (int) (i * timeCoeff);
            for(Action action : sprite.getActions())
            {
                switch (action.getType())
                {
                    case MOVE: f.addAction(new Move(action.getStartTime() + time, action.getEndTime() + time, ((Move)action).getStartX(), ((Move)action).getStartY(), ((Move)action).getEndX(), ((Move)action).getEndY())); break;
                    case FADE: f.addAction(new Fade(action.getStartTime() + time, action.getEndTime() + time, ((Fade)action).getStartFade() * fade,((Fade)action).getEndFade() * fade)); break;
                    case SCALE: f.addAction(new Scale(action.getStartTime() + time, action.getEndTime() + time, ((Scale)action).getStartScale() * scale,((Scale)action).getEndScale() * scale)); break;
                    case COLOR: f.addAction(new Color(action.getStartTime() + time, action.getEndTime() + time, ((Color)action).getStartR(),((Color)action).getStartG(),((Color)action).getStartB(),((Color)action).getStartR(),((Color)action).getStartG(),((Color)action).getStartB())); break;
                    case ROTATE: f.addAction(new Rotate(action.getStartTime() + time, action.getEndTime() + time, ((Rotate)action).getStartAngle(),((Rotate)action).getEndAngle())); break;
                }
            }
            res.add(f);
        }
        return res;
    }

    public static Sprite staticBeat(String spriteName, int x, int y, ColorType color, int startTime, int duration)
    {
        Sprite res = new Sprite(spriteName, Layer.Foreground, Origin.Centre, x, y);
        res.addAction(new Color(TimePair.fromDuration(startTime, duration), color));
        res.addAction(new Fade(startTime,startTime + duration,1,0));
        return res;
    }

    private static double sign(Random rng)
    {
        return 2 * (rng.nextDouble() - 0.5);
    }


    public static List<Sprite> animation(String basePath, String extension, int count, CoordType coord, int offset, int duration)
    {
        List<Sprite> res = new ArrayList<>();

        int frame = 50;

        for(int i = 0; i < duration / frame; ++i)
        {
            Sprite sprite = new Sprite(basePath + (i % count) + extension, Layer.Background, Origin.Centre, coord.getX(), coord.getY());
            sprite.addAction(new Fade(offset + i * frame,offset + (i+1) * frame,1,1));
            res.add(sprite);
        }

        return res;
    }



    public static List<CoordType> curvy(int startX, int startY, int endX, int endY, int count)
    {
        double dx = (endX - startX) / count;
        double dy = (endY - startY) / count;

        List<CoordType> res = new ArrayList<>();
        for(int i = 0; i < count; ++i)
        {
            res.add(new CoordType(startX + (int)dx * i, startY + (int)dy * i));
        }
        return res;
    }


    public static List<CoordType> zigzag(List<CoordType> coords, int delta, double fade)
    {
        List<CoordType> res = new ArrayList<>();
        for(CoordType coord : coords)
        {
            delta = - (int) (delta * fade);
            CoordType coordType = new CoordType(coord.getX() + delta,coord.getY());
            res.add(coordType);
        }
        return res;
    }

    public static List<CoordType> curvyZigzag(List<CoordType> coords, int delta, double fade, double speed)
    {
        List<CoordType> res = new ArrayList<>();
        for(int i = 0; i < coords.size(); ++i)
        {
            CoordType coord = coords.get(i);
            double f = delta * Math.sin(i * speed) * Math.pow(fade, i);
            CoordType coordType = new CoordType((int) (coord.getX() + f),coord.getY());
            res.add(coordType);
        }
        return res;
    }


    public static List<Move> genMoves(List<CoordType> coords, int startTime, int endTime)
    {
        List<Move> res = new ArrayList<>();
        double delta = (endTime - startTime) / coords.size();

        for(int i = 0; i < coords.size() - 1; ++i)
        {
            Move move = new Move((int)(startTime + i * delta),(int)(startTime + (i + 1) * delta), coords.get(i), coords.get(i + 1));
            res.add(move);
        }
        return res;
    }


    private static int oneMinusOne(Random rng)
    {
        return 2 * rng.nextInt(2) - 1;
    }




    public static Sprite finishBeat(String spriteName, int x, int y, ColorType color, int startTime, int duration1, double scale1, int duration2, double scale2)
    {
        Sprite res1 = new Sprite(spriteName, Layer.Foreground, Origin.Centre, x, y);
        if (color != null)
            res1.addAction(new Color(TimePair.fromDuration(startTime, duration1 + duration2), color));
        res1.addAction(new Scale(startTime, startTime + duration1, 0.1, scale1));
        res1.addAction(new Scale(startTime + duration1, startTime + duration1 + duration2, scale1, scale2));
        res1.addAction(new Fade(startTime + duration1 + (duration1 + duration2) / 2, startTime + duration1 + duration2, 1, 0));

        return res1;
    }


    public static Sprite shineBeat(String spriteName, int x, int y, ColorType color, int startTime, int duration1, double scale1, int duration2, double scale2)
    {
        Sprite res1 = new Sprite(spriteName, Layer.Foreground, Origin.Centre, x, y);
        if (color != null)
            res1.addAction(new Color(TimePair.fromDuration(startTime, duration1 + duration2), color));
        res1.addAction(new Scale(startTime, startTime + duration1, 0.1, scale1));
        res1.addAction(new Scale(startTime + duration1, startTime + duration1 + duration2, scale1, scale2));
        res1.addAction(new Fade(startTime, startTime + duration1 + duration2, 1, 0));

        return res1;
    }

    public static List<Sprite> autoPilotWrapper(String spriteName, int[] x, int[] y, int offset, int bpm, ColorType color, double scale)
    {
        assert x.length != y.length;
        UtilClass.addosufix_COMPOSE(x, y);
        List<Sprite> result = new ArrayList<>();
        List<Sprite> autopilot = autopilot(spriteName,x,y,bpm,offset);
        for(Sprite sprite : autopilot)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),color));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),scale,scale));
            result.addAll(SpriteExamplesLibrary.addTrail(sprite,10,7));
        }
        result.addAll(autopilot);
        return result;
    }


    public static List<Sprite> graffitiSmoke(String frameSprite, String innerSprite, int x, int y, int startTime, int duration, int radius, int count)
    {
        Random rng = new Random();

        List<Sprite> res = new ArrayList<>();
        for(int i = 0; i < count; ++i)
        {
            int startTime1 = startTime + rng.nextInt(duration / 4);
            double dx = sign(rng);
            double dy = sign(rng);
            int sx = (int)(x + dx * radius);
            int sy = (int)(y + dy * radius);
            double delta = sign(rng) * 0.1;
            Sprite sprite = new Sprite(frameSprite,Layer.Background,Origin.Centre,sx,sy);

            List<CoordType> coords = curvy(sx, sy, x + (int)((x - sx) * delta), sy - radius, 10);
            coords = zigzag(coords, oneMinusOne(rng) * radius, 0.9 - rng.nextDouble() * 0.5);
            List<Move> moves = genMoves(coords, startTime1, startTime1 + duration);
            sprite.addActions(moves.stream().map(move -> (Action)move).collect(Collectors.toList()));
            sprite.addAction(new Fade(startTime1, startTime1 + duration, 0.95, 0.1 + rng.nextDouble() * 0.7));
            res.add(sprite);

            int lx = (int)(x + dx * radius * 0.6);
            int ly = (int)(y + dy * radius * 0.9 + radius / 3);
            Sprite sprite1 = new Sprite(innerSprite,Layer.Background,Origin.Centre,sx,sy);
            List<CoordType> coordsl = curvy(lx, ly, x + (int)((x - lx) * delta), ly - radius, 10);
            coordsl = zigzag(coordsl, oneMinusOne(rng) * radius, 0.9 - rng.nextDouble() * 0.5);
            List<Move> movesl = genMoves(coordsl, startTime1, startTime1 + duration);
            sprite1.addActions(movesl.stream().map(move -> (Action)move).collect(Collectors.toList()));
            sprite1.addAction(new Fade(startTime1, startTime1 + duration, 1, 0.7));
            res.add(sprite1);

        }

        return res;
    }


    public static List<Sprite> shot(String spriteName, int x, int y, int count, int startTime, int endTime, double radius)
    {
        List<Sprite> sprites = new ArrayList<>();

        Random rng = new Random();

        for(int i = 0; i < count; ++i)
        {
            Sprite sprite = new Sprite(spriteName, Layer.Foreground, Origin.Centre, x, y);

            double angle = rng.nextFloat() * 2 * Math.PI;

            int x_end = (int) (x + radius * Math.cos(angle));
            int y_end = (int) (y + radius * Math.sin(angle));
            sprite.addAction(new Move(startTime, endTime, x, y, x_end, y_end));
            sprite.addAction(new Rotate(startTime, endTime, 0, 6));
            sprite.addAction(new Fade(startTime, endTime, 1, 0));
            sprites.add(sprite);
        }
        return sprites;
    }

    public static List<Sprite> autopilot(String spriteName, int[] xs, int[] ys, int bpm, int offset)
    {
        CoordType[] coordTypes = new CoordType[xs.length];
        for(int i = 0; i < xs.length; ++i)
        {
            coordTypes[i] = new CoordType(xs[i],ys[i]);
        }
        return autopilot(spriteName,coordTypes,bpm,offset);
    }


    public static List<Sprite> autopilot(String spriteName, CoordType[] coords, int bpm, int offset)
    {
        List<Sprite> sprites = new ArrayList<>();
        for(int i = 0; i < coords.length - 1; ++i)
        {
            Sprite sprite = new Sprite(spriteName);
            sprite.addAction(new Move(offset + i * bpm, offset + (i+1) * bpm,coords[i],coords[i + 1]));
            sprites.add(sprite);
        }
        return sprites;
    }

    public static List<Sprite> fire(String spriteName, int startTime, int endTime, int x, int y, double radius, int count, int duration, int height)
    {
        List<Sprite> result = new ArrayList<>();

        Random rng = new Random();

        for(int i = 0; i < count; ++i)
        {
            double dX = Math.cos(i * 2 * Math.PI / count);
            double dY = Math.sin(i * 2 * Math.PI / count);
            //int startOffset = (int) Math.sqrt(dX * dX + dY * dY) * duration;
            int offset = rng.nextInt(endTime - startTime);

            Sprite sprite = new Sprite(spriteName);
            sprite.addAction(new Parameter(startTime, endTime + offset, ParameterType.A));
            sprite.addAction(new Move(startTime + offset, startTime + offset + duration, (int)(x - dX * radius), (int)(y - dY * radius), (int)(2 * x - dX * radius) / 2, (int)(y - dY * radius - height * radius)));
            sprite.addAction(new Fade(startTime + offset, startTime + offset + duration,1,0));
            sprite.addAction(new Scale(startTime + offset, startTime + offset + duration, rng.nextDouble() + 0.5,0.4));
            result.add(sprite);
        }

        return result;
    }

    public static List<Sprite> rain(String rainName, int offset, int duration, double intensity)
    {
        List<Sprite> sprites = new ArrayList<>();

        int drop_duration = (int)(intensity * 250);

        int rain_count = 3;

        //offset -= drop_duration / rain_count * (rain_count - 1);

        for(int i = 0; i < duration / drop_duration; ++i)
        {
            int delta = drop_duration / (rain_count - 1);
            //System.err.println(delta);
            for(int j = 0; j < rain_count - 1; ++j)
            {
                int start = offset + i * drop_duration + j * delta;
                int end = offset + ((i + 1) * drop_duration) + (j + 1) * delta;
                //System.err.println(start);
                //System.err.println((i + 1) * drop_duration);
                //System.err.println((j + 1) * delta);
                //exit(0);

                Sprite left = new Sprite(rainName);
                left.addAction(new Move(start, end, 640, 0, 320, 480));
                sprites.add(left);
                Sprite right = new Sprite(rainName);
                right.addAction(new Move(start, end, 0, 0, -320, 480));
                sprites.add(right);
            }
        }
        /*sprites.remove(0);
        sprites.remove(0);
        sprites.remove(sprites.size() - 1);
        sprites.remove(sprites.size() - 1);*/
        return sprites;
    }


    public static Sprite whiteFlash(String whiteSprite, int offset, int duration, double startFade, double endFade)
    {
        Sprite sprite = new Sprite(whiteSprite, Layer.Background, Origin.Centre, 320, 240);
        sprite.addAction(new Fade(offset, offset + duration, startFade, endFade));
        return sprite;
    }


    public static Sprite trailingWindow(String spriteName, int start, int end)
    {
        Sprite sprite = new Sprite(spriteName,Layer.Background, Origin.Centre, 460,240);
        sprite.addAction(new Move(start, end, 460,240, 180,240));
        sprite.addAction(new Fade(start, start + (end - start) / 10, 0, 0.625));
        sprite.addAction(new Fade(end - (end - start) / 10, end, 0.625, 0));
        return sprite;
    }

    public static Sprite flyingObject(String spriteName, int start, int end, int x1, int y1, int x2, int y2)
    {
        Sprite sprite = new Sprite(spriteName);
        sprite.addAction(new Move(start, end, x1, y1, x2, y2));
        return sprite;
    }

    public static List<Sprite> snow(String spriteName, int start, int end, int count, int time)
    {
        List<Sprite> result = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < count; ++i)
        {
            int x0 = random.nextInt(660 + 160) - 160 + UtilClass.osuXfix_COMPOSE;
            int y0 = 400 + UtilClass.osuYfix_COMPOSE;

            Sprite sprite = new Sprite(spriteName);
            //snowflake

            int startTime = start + random.nextInt(end - start - time / 8);
            int endTime = startTime + time;

            int x1 = x0;
            int y1 = -60 + UtilClass.osuYfix_COMPOSE;

            List<CoordType> coords = curvy(x0, y0, x1, y1, 50);
            coords = curvyZigzag(coords, 10, 1, 0.1);
            List<Move> moves = genMoves(coords, startTime, endTime);
            sprite.addActions(moves.stream().map(move -> (Action)move).collect(Collectors.toList()));

            //sprite.addAction(new Move(startTime, endTime, x0, y0, x1, y1));
            sprite.addAction(new Fade(startTime, startTime + time / 8, 0.1, 1));
            sprite.addAction(new Fade(startTime, Math.min(endTime - time / 8, end), 1, 0));

            result.add(sprite);
        }


        return result;
    }


    public static List<Sprite> rain(String spriteName, int start, int end, int count, double angle, int time)
    {
        List<Sprite> result = new ArrayList<>();

        Random random = new Random();

        for(int i = 0; i < count; ++i)
        {
            int x0 = random.nextInt(760 + 260) - 260 + UtilClass.osuXfix_COMPOSE;
            int y0 = -60 + UtilClass.osuYfix_COMPOSE;

            Sprite sprite = new Sprite(spriteName);
            //snowflake

            int startTime = start + random.nextInt(end - start - time / 8);
            int endTime = startTime + time;

            int y1 = 400 + UtilClass.osuYfix_COMPOSE;
            int x1 = x0;
            if (angle > 0)
                x1 = (int) (Math.tan(angle) * (y1 - y0) + x0);

            sprite.addAction(new Rotate(startTime,endTime, -angle, -angle));
            sprite.addAction(new Move(startTime, endTime, x0, y0, x1, y1));
            sprite.addAction(new Fade(startTime, endTime, 0.8, 0.8));
            //sprite.addAction(new Fade(startTime, Math.min(endTime - time / 8, end), 1, 0));

            result.add(sprite);
        }


        return result;
    }

    public static List<Sprite> lyricsGenerator(List<String> timing, String lyricsPath, String extension, double imageSize, int x, int y)
    {
        List<Sprite> sprites = new ArrayList<>();

        int counter = 0;
        for(String t : timing)
        {
            String[] components = t.replace(" ","").split("-");
            int c = counter % 2;

            Sprite sprite = new Sprite(lyricsPath + components[0] + extension,Layer.Foreground,Origin.Centre);
            int start = UtilClass.parseOffset(components[1]);
            int end = UtilClass.parseOffset(components[2]);
            sprite.addAction(new Scale(start,end,imageSize,imageSize));
            sprite.addAction(new Fade(start,start + 900, 0.1, 1));
            sprite.addAction(new Fade(end - 900,end, 1, 0));
            sprite.addAction(new Move(start,end, x + (2 * c - 1) * 10, y, x + (2 * c - 1) * (-8), y));
            //sprite.color(start,end,255,255,255,255,255,255);
            sprites.add(sprite);
            ++counter;
        }
        return sprites;
    }

    public static Sprite bgPulse(String bgName,int startTime, int bpm)
    {
        Sprite sprite = new Sprite(bgName, Layer.Background, Origin.Centre, 320, 240);
        sprite.addAction(new Scale(startTime, startTime + bpm, 0.7, 0.8));
        sprite.addAction(new Fade(startTime, startTime + bpm, 1, 0));
        return sprite;
    }

    public static Sprite projectileShot(String projectile, int startTime, int endTime, int X1, int Y1, int X2, int Y2, double angle)
    {

        Sprite sprite = new Sprite(projectile);
        sprite.addAction(new Move(startTime, endTime, X1, Y1, X2, Y2));
        sprite.staticAngle(angle);

        return sprite;
    }

    public static Sprite bulletShot(String spriteName, int offset, int X, int Y, double angle)
    {
        Sprite sprite = new Sprite(spriteName);

        int y0 = 400 + UtilClass.osuYfix_COMPOSE;
        int y1 = -60 + UtilClass.osuYfix_COMPOSE;

        int x0 = (int) (X + (Y - y0) * Math.tan(angle));
        int x1 = (int) (X + (Y - y1) * Math.tan(angle));

        double speed = 2;

        double distance1 = Math.sqrt((x0 - X)*(x0 - X) + (y0 - Y)*(y0 - Y));
        double distance2 = Math.sqrt((x1 - X)*(x1 - X) + (y1 - Y)*(y1 - Y));

        sprite.addAction(new Move(offset - (int) (distance1 / speed), offset + (int) (distance2 / speed), x0, y0, x1, y1)).staticAngle(angle);

        return sprite;
    }



    public static Sprite scratch(String damageSpriteName, int offset, int x, int y, int fadeOutTime)
    {
        Sprite sprite = new Sprite(damageSpriteName, Layer.Background, Origin.Centre, x, y);
        int period = 20;
        sprite.addAction(new Fade(offset, offset + period, 0, 1));
        sprite.addAction(new Fade(offset + period + 1000, offset + period + fadeOutTime, 1, 0));
        return sprite;
    }
}
