package com.company.Storyboards;

import com.company.Sprites.Sprite;

import java.util.*;

public class StoryBoard {

    private List<Sprite> objects;

    public StoryBoard()
    {
        objects = new ArrayList<>();
    }

    public StoryBoard(InputStoryBoard inputStoryBoard)
    {
        this();
        for(Sprite get = inputStoryBoard.extractNext(); get != null; get = inputStoryBoard.extractNext())
            objects.add(get);
    }

    public void addSprite(Sprite sprite)
    {
        this.objects.add(sprite);
    }

    public void addSprites(Collection<Sprite> sprites)
    {
        this.objects.addAll(sprites);
    }

    public Sprite findBySubString(String subString)
    {
        for(Sprite sprite : objects)
        {
            if (sprite.toString().contains(subString))
                return sprite;
        }
        return null;
    }

    public Set<Sprite> findAllBySubString(String subString)
    {
        Set<Sprite> res = new HashSet<>();
        for(Sprite sprite : objects)
        {
            if (sprite.toString().contains(subString))
                res.add(sprite);
        }
        return res;
    }

    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[Events]\n");
        objects.stream().forEach(sprite1 -> stringBuilder.append(sprite1.toString()));
        stringBuilder.append("//Storyboards Sound Samples");

        return stringBuilder.toString();
    }
}
