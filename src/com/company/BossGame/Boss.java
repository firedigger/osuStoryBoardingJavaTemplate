package com.company.BossGame;

import com.company.Actions.Fade;
import com.company.Actions.Move;
import com.company.Sprites.Sprite;
import com.company.Sprites.SpriteExamplesLibrary;
import com.company.Types.Layer;
import com.company.Types.Origin;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gifin on 29.08.2016.
 */
public class Boss
{
    private String spriteName;
    private String damageSpriteName;
    private List<Sprite> sprites;

    public Boss(String spriteName, String damageSpriteName)
    {
        this.spriteName = spriteName;
        this.damageSpriteName = damageSpriteName;
        this.sprites = new ArrayList<>();
    }

    public Boss applyDamage(int offset, int X, int Y, double scale)
    {
        Sprite damage = SpriteExamplesLibrary.scratch(damageSpriteName, offset, X, Y, 90);
        damage.staticScale(scale);
        this.sprites.add(damage);
        return this;
    }

    public Boss movement(int offset1, int offset2, int X1, int Y1, int X2, int Y2)
    {
        Sprite movement = new Sprite(spriteName).addAction(new Move(offset1, offset2, X1, Y1, X2, Y2));
        movement.staticScale(0.3);
        this.sprites.add(movement);
        return this;
    }

    public Boss staticAppearance(int offset1, int offset2)
    {
        Sprite life = new Sprite(spriteName).addAction(new Fade(offset1, offset2, 1,1)).staticScale(0.3);
        this.sprites.add(life);
        return this;
    }

    public List<Sprite> compile()
    {
        return sprites;
    }

}
