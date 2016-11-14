package com.company.Storyboards;

import com.company.Sprites.Sprite;

import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by DELL on 2/14/2016.
 */
public class InputStoryBoard {

    public NavigableMap<Integer, Sprite> sprites;

    public InputStoryBoard(String in)
    {
        sprites = new TreeMap<>();

        String[] lines = in.split("\n");

        String accumulate = "";
        for(int i = 1; i < lines.length; ++i)
        {
            if (!lines[i].startsWith(" ") && i > 1)
            {
                Sprite sprite = new Sprite(accumulate);
                this.sprites.put(i,sprite);
                accumulate = "";
            }
            accumulate += lines[i] + "\n";
        }
    }

    public Sprite extractNext()
    {
        if (sprites.isEmpty())
            return null;

        Integer next = sprites.firstKey();
        Sprite res = sprites.get(next);
        sprites.remove(next);
        return res;
    }
}
