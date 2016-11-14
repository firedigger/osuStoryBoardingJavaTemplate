package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import com.company.Actions.*;
import com.company.BossGame.Boss;
import com.company.Sprites.Sprite;
import com.company.Sprites.SpriteExamplesLibrary;
import com.company.Storyboards.StoryBoard;
import com.company.Storyboards.StoryboardWriter;
import com.company.Types.*;
import com.company.UtilsPackage.UtilClass;

import static com.company.UtilsPackage.UtilClass.*;

public class Main {

    public static void KIKO()
    {
        StoryBoard storyBoard = new StoryBoard();

        List<Sprite> shot1 = SpriteExamplesLibrary.shot("triangle1.png",444 + osuXfix_DESIGN,298 + osuYfix_DESIGN,25,87720,87720 + 450,500);
        storyBoard.addSprites(shot1);

        List<Sprite> shot2 = SpriteExamplesLibrary.shot("triangle1.png",455 + osuXfix_DESIGN,256 + osuYfix_DESIGN,25,140084,140084 + 450,500);
        storyBoard.addSprites(shot2);

        List<Sprite> shot3 = SpriteExamplesLibrary.shot("triangle1.png",248 + osuXfix_DESIGN,143 + osuYfix_DESIGN,25,209902,209902 + 450,500);
        storyBoard.addSprites(shot3);

        List<Sprite> shot4 = SpriteExamplesLibrary.shot("SakuraPetalS.png",368 + osuXfix_COMPOSE,348 + osuYfix_COMPOSE,4,177175,177175 + 450,100);
        storyBoard.addSprites(shot4);

        int duration1 = 150;
        int bpm1 = 97129 - 96993;
        int offset1 = 96993;
        String highlight1 = "highlight.png";
        int tick = 0;

        int[] xs1 = new int[]{414,446,390,468,392,463,422,422,461,387,470,390};
        int[] ys1 = new int[]{84,153,109,138,150,106,171,101,165,111,130,154};

        UtilClass.addosufix_DESIGN(xs1, ys1);

        ColorType[] colorTypes = new ColorType[4];
        colorTypes[0] = ColorType.Red;
        colorTypes[1] = ColorType.Yellow;
        colorTypes[2] = ColorType.Green;
        colorTypes[3] = ColorType.Blue;

        for(int i1 = 0; i1 < xs1.length / 2; ++i1)
            for(int j1 = 0; j1 < 2; ++j1)
            {
                int index = i1 * 2 + j1;
                storyBoard.addSprite(SpriteExamplesLibrary.staticBeat(highlight1,xs1[index], ys1[index], colorTypes[(i1 + 3) % 4], offset1 + tick * bpm1, duration1));
                ++tick;
            }

        int[] xs2 = new int[]{48,92,48,100,52,116,56,120,60,144,60,156};
        int[] ys2 = new int[]{108,192,164,216,216,252,264,280,308,316,344,344};

        UtilClass.addosufix_COMPOSE(xs2, ys2);

        int offset2 = 99175;
        tick = 0;

        for(int i1 = 0; i1 < xs2.length / 2; ++i1)
            for(int j1 = 0; j1 < 2; ++j1)
            {
                int index = i1 * 2 + j1;
                storyBoard.addSprite(SpriteExamplesLibrary.staticBeat(highlight1,xs2[index], ys2[index], colorTypes[(i1 + 2) % 4], offset2 + tick * bpm1, duration1));
                ++tick;
            }

        String light = "Lights.png";

        int[] xsl = new int[]{152,228,264,192};
        int[] ysl = new int[]{304,336,268,240};

        UtilClass.addosufix_COMPOSE(xsl, ysl);

        int offsetl = 102448;
        tick = 0;
        int durationl = 400;

        for(int i1 = 0; i1 < xsl.length; ++i1)
        {
            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat(light,xsl[i1], ysl[i1], ColorType.White, offsetl + tick * bpm1, durationl));
            ++tick;
        }


        int[] xs3 = new int[]{152,204,216,252,276,304,332,352,388,404,448,452,476};
        int[] ys3 = new int[]{212,180,224,160,228,144,232,132,236,120,240,112,332};

        UtilClass.addosufix_COMPOSE(xs3, ys3);

        int offset3 = 192993;

        List<Sprite> autopilot1 = SpriteExamplesLibrary.autopilot("cursor.png",xs3,ys3,bpm1,offset3);
        for(Sprite sprite : autopilot1)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Green));
        }
        storyBoard.addSprites(autopilot1);

        int[] xs4 = new int[]{436,464,376,512,348,456,384,383,461,348,190,310,249,228};
        int[] ys4 = new int[]{234,56,192,112,120,184,38,196,51,120,80,182,30,168};

        UtilClass.addosufix_COMPOSE(xs4, ys4);

        int offset4 = 53220;

        List<Sprite> autopilot2 = SpriteExamplesLibrary.autopilot("cursor.png",xs4,ys4,bpm1,offset4);
        for(Sprite sprite : autopilot2)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Green));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,10,10));
        }
        storyBoard.addSprites(autopilot2);

        int[] xs5 = new int[]{272,400,436,420,460,392,415,408,435,384,407,400,427,504};
        int[] ys5 = new int[]{328,300,184,268,148,240,120,206,82,176,56,142,18,80};

        UtilClass.addosufix_COMPOSE(xs5, ys5);

        int offset5 = 59766;

        List<Sprite> autopilot3 = SpriteExamplesLibrary.autopilot("cursor.png",xs5,ys5,bpm1,offset5);
        for(Sprite sprite : autopilot3)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Green));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.6,0.6));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,10,10));
        }
        storyBoard.addSprites(autopilot3);

        //-----autopilot----

        int[] xs6 = new int[]{292,336,168,320,160,294,218,231,160,64,218,98,246,392};
        int[] ys6 = new int[]{276,192,208,128,144,21,171,0,144,104,171,48,112,172};

        UtilClass.addosufix_COMPOSE(xs6, ys6);

        int offset6 = 55402;

        List<Sprite> autopilot4 = SpriteExamplesLibrary.autopilot("cursor.png",xs6,ys6,bpm1,offset6);
        for(Sprite sprite : autopilot4)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Red));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.8,0.8));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,50,7));
        }
        storyBoard.addSprites(autopilot4);
        //-----------------------

        //-----autopilot----

        int[] xs7 = new int[]{332,244,108,232,116};
        int[] ys7 = new int[]{120,84,84,44,124};

        UtilClass.addosufix_COMPOSE(xs7, ys7);

        int offset7 = 61948;

        List<Sprite> autopilot5 = SpriteExamplesLibrary.autopilot("cursor.png",xs7,ys7,bpm1,offset7);
        for(Sprite sprite : autopilot5)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.White));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.8,0.8));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,10,7));
        }
        storyBoard.addSprites(autopilot5);

        int[] xs8 = new int[]{172,75,135,109};
        int[] ys8 = new int[]{88,184,68,206};

        UtilClass.addosufix_COMPOSE(xs8, ys8);

        int offset8 = 62629;

        List<Sprite> autopilot6 = SpriteExamplesLibrary.autopilot("cursor.png",xs8,ys8,bpm1,offset8);
        for(Sprite sprite : autopilot6)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.White));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.8,0.8));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,10,7));
        }
        storyBoard.addSprites(autopilot6);

        int[] xs9 = new int[]{120,96,78,137,184};
        int[] ys9 = new int[]{140,273,144,273,372};

        UtilClass.addosufix_COMPOSE(xs9, ys9);

        int offset9 = 63175;

        List<Sprite> autopilot7 = SpriteExamplesLibrary.autopilot("cursor.png",xs9,ys9,bpm1,offset9);
        for(Sprite sprite : autopilot7)
        {
            sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Purple));
            sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.8,0.8));
            storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,10,7));
        }
        storyBoard.addSprites(autopilot7);
        //-----------------------


        //---------finishbeat------

        storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("circle.png",180 + osuXfix_COMPOSE, 140 + osuYfix_COMPOSE, new ColorType(111,179,208), 290787, 100, 0.3, 2000, 3));

        //----------------


        //-----lightning-------

        storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("thud1.png",200, 290, new ColorType(253,250,135), 194627, 400));

        storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("whitethunder.png",320, 240, ColorType.White, 235728, 600));

        //----------------

        //----graffitiSmoke----

        List<Sprite> fireleft = SpriteExamplesLibrary.graffitiSmoke("graffitiSmoke.png","fire_light.png",160 + osuXfix_COMPOSE,240 + osuYfix_COMPOSE,185902,700,40,50);
        storyBoard.addSprites(fireleft);

        List<Sprite> fireright = SpriteExamplesLibrary.graffitiSmoke("graffitiSmoke.png","fire_light.png",480 + osuXfix_COMPOSE,240 + osuYfix_COMPOSE,186448,700,40,50);
        storyBoard.addSprites(fireright);


        List<Sprite> mlgFire = SpriteExamplesLibrary.animation("Flame/a",".png",49,new CoordType(56,332),195175,199402 - 195175);
        mlgFire.stream().map(sprite -> sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.5,0.5)));
        storyBoard.addSprites(mlgFire);
        //------------

        storyBoard.addSprite(SpriteExamplesLibrary.whiteFlash("w.png",140084, 155902 - 140084, 1 , 0));

        //---------rain----------

        List<Sprite> rain = SpriteExamplesLibrary.rain("rain.png",88266,96448 - 88266,0.5);
        storyBoard.addSprites(rain);
        //-------------------


        try {
            StoryboardWriter.output(storyBoard, new FileOutputStream("C:\\Users\\gifin\\AppData\\Local\\osu!\\Songs\\462910 Panda eyes - KIKO\\Panda eyes - KIKO (firedigger).osb"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args)
    {
        FCLSecretProject();
    }

    public static void FCLSecretProject()
    {
        String outputPath = "C:\\Users\\gifin\\AppData\\Local\\osu!\\Songs\\478289 MY FIRST STORY - Smash Out!!\\MY FIRST STORY - Smash Out!! (FCL).osb";
        StoryBoard storyBoard = new StoryBoard();
        try {

            Boss boss = new Boss("SB/GearC.png","SB/RThunder6.png");
            double scale = 0.3;
            boss.movement(117781,118805,219 + osuXfix_COMPOSE, 282 + osuYfix_COMPOSE, 256 + osuXfix_COMPOSE, 339 + osuYfix_COMPOSE);
            boss.applyDamage(117781,219 + osuXfix_COMPOSE, 282 + osuYfix_COMPOSE,scale);
            boss.applyDamage(118089,235 + osuXfix_COMPOSE, 299 + osuYfix_COMPOSE,scale);
            boss.applyDamage(118397,248 + osuXfix_COMPOSE, 319 + osuYfix_COMPOSE,scale);
            boss.applyDamage(118705,256 + osuXfix_COMPOSE, 339 + osuYfix_COMPOSE,scale);
            storyBoard.addSprites(boss.compile());

            storyBoard.addSprite(SpriteExamplesLibrary.bulletShot("SB/lightDot2.png",117705,237 + osuXfix_COMPOSE, 80 + osuYfix_COMPOSE, UtilClass.degToRad(80)));
            storyBoard.addSprite(SpriteExamplesLibrary.bulletShot("SB/lightDot2.png",118012,323 + osuXfix_COMPOSE, 72 + osuYfix_COMPOSE, UtilClass.degToRad(-80)));
            storyBoard.addSprite(SpriteExamplesLibrary.bulletShot("SB/lightDot2.png",118320,417 + osuXfix_COMPOSE, 79 + osuYfix_COMPOSE, UtilClass.degToRad(80)));
            storyBoard.addSprite(SpriteExamplesLibrary.bulletShot("SB/lightDot2.png",118628,506 + osuXfix_COMPOSE, 89 + osuYfix_COMPOSE, UtilClass.degToRad(-80)));

            StoryboardWriter.output(storyBoard, new FileOutputStream(outputPath));


        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    public static void Hirasawa()
    {
        StoryBoard storyBoard = new StoryBoard();

        try {
            List<String> timing = Files.lines(Paths.get("timings.txt")).collect(Collectors.toList());

            storyBoard.addSprites(SpriteExamplesLibrary.lyricsGenerator(timing,"Niwashi SB/en/",".png",0.85,300,350));
            storyBoard.addSprites(SpriteExamplesLibrary.lyricsGenerator(timing,"Niwashi SB/kanji/",".png",0.75,430,100));
            storyBoard.addSprites(SpriteExamplesLibrary.lyricsGenerator(timing,"Niwashi SB/romaji/",".png",0.75,430,150));

            storyBoard.addSprite(SpriteExamplesLibrary.trailingWindow("Niwashi SB/lessthenthree.png",30574,56483));

            List<Sprite> rainDrops = SpriteExamplesLibrary.rain("Niwashi SB/rain.png", 179483, 205392, 3000, Math.PI / 6, 500);
            storyBoard.addSprites(rainDrops);

            List<Sprite> snowFlakes = SpriteExamplesLibrary.snow("Niwashi SB/feathercircle.png", 84574, 110210, 100, 7 * 1000);
            snowFlakes.forEach(sprite -> sprite.addAction(new Scale(sprite.getStartLifetime(), sprite.getEndLifetime(), 0.1, 0.1)));
            storyBoard.addSprites(snowFlakes);

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/ray.png", 396 + osuXfix_COMPOSE, 180 + osuYfix_COMPOSE, new ColorType(111,179,208), 151119, 100, 5, 2000, 6));

            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/thud1.png",200, 290, new ColorType(253,250,135), 151665, 800));

            storyBoard.addSprite(SpriteExamplesLibrary.whiteFlash("Niwashi SB/w.png",69846, 71346 - 69846, 1 , 0));

            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/thud1.png",200, 290, new ColorType(253,250,135), 71483, 400));
            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/thud1.png",450, 290, new ColorType(253,250,135), 73119, 400));

            storyBoard.addSprite(SpriteExamplesLibrary.shineBeat("Niwashi SB/Light2.png",248 + osuXfix_COMPOSE,214 + osuYfix_COMPOSE, null, 220392, 100, 1, 1000, 1.2));

            int plutoStart = 205665;
            int plutoStop = 218210;
            Sprite pluto = new Sprite("Niwashi SB/pluto.png").addAction(new Move(plutoStart,plutoStop,-160 + osuXfix_COMPOSE,214 + osuYfix_COMPOSE,248 + osuXfix_COMPOSE,214 + osuYfix_COMPOSE)).addAction(new Move(220392,231846,248 + osuXfix_COMPOSE,214 + osuYfix_COMPOSE,690 + osuXfix_COMPOSE,214 + osuYfix_COMPOSE)).staticScale(0.09);
            storyBoard.addSprite(pluto);

            Sprite black = new Sprite("Niwashi SB/black.png", Layer.Background, Origin.Centre, 320, 240).addAction(new Fade(217528,plutoStop,0,0.99)).addAction(new Fade(220392,221074,0.99,0));
            storyBoard.addSprite(black);

            for(int i = 0; i < 47; ++i)
                storyBoard.addSprite(SpriteExamplesLibrary.bgPulse("Niwashi SB/BG.jpg",220937 + i * 136 * 4,110 * 2));
            for(int i = 0; i < 48; ++i)
                storyBoard.addSprite(SpriteExamplesLibrary.bgPulse("Niwashi SB/redBG.jpg",246574 + i * 136 * 4,110 * 2));

            //my part

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/circle.png",235 + osuXfix_COMPOSE, 283 + osuYfix_COMPOSE, new ColorType(111,179,208), 56756, 100, 0.3, 2000, 3));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/circle.png",136 + osuXfix_COMPOSE, 288 + osuYfix_COMPOSE, new ColorType(111,179,208), 110756, 100, 0.3, 2000, 3));

            int[] xs1 = new int[]{312,381,440,393,316,247,187,232,304,239,142,76,56};
            int[] ys1 = new int[]{232,277,217,148,88,41,100,169,236,308,309,237,140};

            UtilClass.addosufix_COMPOSE(xs1, ys1);

            int offset1 = 61665;
            int bpm1 = 61801 - 61665;
            List<Sprite> autopilot = SpriteExamplesLibrary.autopilot("Niwashi SB/cursor.png",xs1,ys1,bpm1,offset1);
            for(Sprite sprite : autopilot)
            {
                sprite.addAction(new Color(new TimePair(sprite.getStartLifetime(),sprite.getEndLifetime()),ColorType.Yellow));
                sprite.addAction(new Scale(sprite.getStartLifetime(),sprite.getEndLifetime(),0.8,0.8));
                storyBoard.addSprites(SpriteExamplesLibrary.addTrail(sprite,50,7));
            }
            storyBoard.addSprites(autopilot);

            List<Sprite> shot4 = SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png",28 + osuXfix_COMPOSE,356 + osuYfix_COMPOSE,8,28937,28937 + 450,100);
            storyBoard.addSprites(shot4);
            List<Sprite> shot5 = SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png",484 + osuXfix_COMPOSE,360 + osuYfix_COMPOSE,8,29483,29483 + 450,100);
            storyBoard.addSprites(shot5);
            List<Sprite> shot6 = SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png",256 + osuXfix_COMPOSE,32 + osuYfix_COMPOSE,25,30028,30028 + 450,500);
            storyBoard.addSprites(shot6);

            Sprite entry = SpriteExamplesLibrary.flyingObject("Niwashi SB/cursor.png",30028, 30574, 680 + osuXfix_COMPOSE, 372 + osuYfix_COMPOSE, 260 + osuXfix_COMPOSE, 372 + osuYfix_COMPOSE);
            entry.addAction(new Color(new TimePair(entry.getStartLifetime(), entry.getEndLifetime()),ColorType.White));
            List<Sprite> trail = SpriteExamplesLibrary.addTrail(entry,75,7);
            storyBoard.addSprites(trail);

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 76 + osuXfix_COMPOSE, 254 + osuYfix_COMPOSE, 5, 123846, 123846 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 252 + osuXfix_COMPOSE, 280 + osuYfix_COMPOSE, 5, 124119, 124119 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 252 + osuXfix_COMPOSE, 205 + osuYfix_COMPOSE, 5, 124256, 124256 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 252 + osuXfix_COMPOSE, 127 + osuYfix_COMPOSE, 5, 124392, 124392 + 300, 150));

            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/highlight.png",252 + osuXfix_COMPOSE,280 + osuYfix_COMPOSE,ColorType.Purple, 124119, 124665 - 124119));
            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/highlight.png",252 + osuXfix_COMPOSE,205 + osuYfix_COMPOSE,ColorType.Purple, 124256, 124665 - 124256));
            storyBoard.addSprite(SpriteExamplesLibrary.staticBeat("Niwashi SB/highlight.png",252 + osuXfix_COMPOSE,127 + osuYfix_COMPOSE,ColorType.Purple, 124392, 124665 - 124392));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxESS.png", 252 + osuXfix_COMPOSE, 130 + osuYfix_COMPOSE, 10, 124665, 124665 + 250, 300));

            Sprite entry1 = SpriteExamplesLibrary.flyingObject("Niwashi SB/cursor.png",124800, 124937, -160 + osuXfix_COMPOSE, 205 + osuYfix_COMPOSE, 168 + osuXfix_COMPOSE, 205 + osuYfix_COMPOSE);
            entry.addAction(new Color(new TimePair(entry1.getStartLifetime(), entry1.getEndLifetime()),ColorType.White));
            List<Sprite> trail1 = SpriteExamplesLibrary.addTrail(entry1,75,2);
            storyBoard.addSprites(trail1);

            Sprite entry2 = SpriteExamplesLibrary.flyingObject("Niwashi SB/cursor.png",124800, 125210, 680 + osuXfix_COMPOSE, 205 + osuYfix_COMPOSE, 336 + osuXfix_COMPOSE, 205 + osuYfix_COMPOSE);
            entry.addAction(new Color(new TimePair(entry2.getStartLifetime(), entry2.getEndLifetime()),ColorType.White));
            List<Sprite> trail2 = SpriteExamplesLibrary.addTrail(entry2,75,2);
            storyBoard.addSprites(trail2);

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/Bubble.png",252 + osuXfix_COMPOSE, 37 + osuYfix_COMPOSE, new ColorType(111,179,208), 125483, 100, 3, 1000, 4));

            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{122,187,252,317}, new int[]{288,288,288,288},126028,137,ColorType.White,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{360,291,226,200,162,188,248,208,147,189,260,210,136,186,320}, new int[]{144,137,129,165,141,105,124,181,143,85,120,192,146,70,88},126846,136,ColorType.Red,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{60,160,260,360,480,380,280,180,123,218,238,144,123,160,218,248,304,332,368,331,273,243,187,159}, new int[]{112,94,77,60,128,146,163,180,143,122,217,237,143,80,122,56,108,44,152,215,173,239,187,251},130392,136,ColorType.Blue,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{292,348,280,188,284,340,272,180,64,68,113,190,285,380}, new int[]{96,176,248,216,176,256,328,296,292,194,108,49,28,49},134210,136,ColorType.Blue,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{88,78,140,250,368,284,197,116}, new int[]{72,169,240,241,172,170,166,164},138028,136,ColorType.White,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{208,113,61,68,136,232,228,229,284,341,286,287,345,399,228,224,313,399}, new int[]{304,275,211,124,56,32,159,224,250,217,188,253,282,246,159,256,304,246},139392,136,ColorType.White,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{255,313,369,430,419,372,321,278,355,324,292,262,220}, new int[]{178,157,133,115,177,136,92,55,42,95,149,203,268},143483,136,ColorType.White,1));
            storyBoard.addSprites(SpriteExamplesLibrary.autoPilotWrapper("Niwashi SB/cursor.png",new int[]{304,238,187,158,241,190,161,157,193,164,160,172,243,340,410,426,382,295,176,127,80,153,244,352,424}, new int[]{60,82,126,186,85,129,189,255,132,192,258,322,344,329,260,163,75,30,28,112,216,297,380,336,280},146756,136,ColorType.White,1));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 226 + osuXfix_COMPOSE, 129 + osuYfix_COMPOSE, 10, 127119, 127119 + 400, 200));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 248 + osuXfix_COMPOSE, 124 + osuYfix_COMPOSE, 15, 127665, 127665 + 300, 300));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 260 + osuXfix_COMPOSE, 120 + osuYfix_COMPOSE, 30, 128210, 128210 + 200, 400));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 320 + osuXfix_COMPOSE, 88 + osuYfix_COMPOSE, 8, 128756, 128756 + 300, 100));

            Sprite entry3 = SpriteExamplesLibrary.flyingObject("Niwashi SB/cursor.png",136665, 137074, 612 + osuXfix_COMPOSE, 480 + osuYfix_COMPOSE, 353 + osuXfix_COMPOSE, 270 + osuYfix_COMPOSE);
            entry.addAction(new Color(new TimePair(entry3.getStartLifetime(), entry3.getEndLifetime()),ColorType.White));
            List<Sprite> trail3 = SpriteExamplesLibrary.addTrail(entry3,75,2);
            storyBoard.addSprites(trail3);

            Sprite lh1 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",60 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 130392, 300);
            lh1.addAction(new Scale(lh1.getStartLifetime(),lh1.getEndLifetime(),2,2));
            storyBoard.addSprite(lh1);

            Sprite lh2 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",480 + osuXfix_COMPOSE,128 + osuYfix_COMPOSE,ColorType.White, 130937, 300);
            lh2.addAction(new Scale(lh2.getStartLifetime(),lh2.getEndLifetime(),2,2));
            storyBoard.addSprite(lh2);

            Sprite lh3 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight2.png",123 + osuXfix_COMPOSE,143 + osuYfix_COMPOSE,ColorType.White, 131483, 600);
            lh3.addAction(new Scale(lh3.getStartLifetime(),lh3.getEndLifetime(),3,3));
            storyBoard.addSprite(lh3);
            Sprite lh4 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight2.png",123 + osuXfix_COMPOSE,163 + osuYfix_COMPOSE,ColorType.White, 131483, 600);
            lh4.addAction(new Scale(lh4.getStartLifetime(),lh4.getEndLifetime(),3,3));
            storyBoard.addSprite(lh4);
            Sprite lh5 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight2.png",123 + osuXfix_COMPOSE,183 + osuYfix_COMPOSE,ColorType.White, 131483, 600);
            lh5.addAction(new Scale(lh5.getStartLifetime(),lh5.getEndLifetime(),3,3));
            storyBoard.addSprite(lh5);

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 123 + osuXfix_COMPOSE, 143 + osuYfix_COMPOSE, 8, 132028, 132028 + 400, 100));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 144 + osuXfix_COMPOSE, 100 + osuYfix_COMPOSE, 8, 137483, 137483 + 300, 200));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/circle.png",132 + osuXfix_COMPOSE, 132 + osuYfix_COMPOSE, new ColorType(111,179,208), 133665, 100, 0.3, 2000, 3));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/circle.png",292 + osuXfix_COMPOSE, 96 + osuYfix_COMPOSE, new ColorType(111,179,208), 134210, 100, 0.3, 2000, 3));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/circle.png",284 + osuXfix_COMPOSE, 176 + osuYfix_COMPOSE, new ColorType(111,179,208), 134756, 100, 0.3, 2000, 3));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/Bubble.png",64 + osuXfix_COMPOSE, 292 + osuYfix_COMPOSE, new ColorType(111,179,208), 135301, 100, 3, 1000, 4));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 88 + osuXfix_COMPOSE, 72 + osuYfix_COMPOSE, 8, 138028, 138028 + 300, 200));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 368 + osuXfix_COMPOSE, 172 + osuYfix_COMPOSE, 8, 138574, 138574 + 400, 100));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 208 + osuXfix_COMPOSE, 304 + osuYfix_COMPOSE, 5, 139392, 139392 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 113 + osuXfix_COMPOSE, 275 + osuYfix_COMPOSE, 5, 139528, 139528 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 61 + osuXfix_COMPOSE, 211 + osuYfix_COMPOSE, 5, 139665, 139665 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 68 + osuXfix_COMPOSE, 124 + osuYfix_COMPOSE, 5, 139801, 139801 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 136 + osuXfix_COMPOSE, 56 + osuYfix_COMPOSE, 5, 139937, 139937 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxEESS.png", 232 + osuXfix_COMPOSE, 32 + osuYfix_COMPOSE, 5, 140074, 140074 + 300, 150));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxESS.png", 228 + osuXfix_COMPOSE, 144 + osuYfix_COMPOSE, 50, 140210, 140210 + 300, 400));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxESS.png", 286 + osuXfix_COMPOSE, 173 + osuYfix_COMPOSE, 50, 140756, 140756 + 300, 400));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/BoxESS.png", 228 + osuXfix_COMPOSE, 144 + osuYfix_COMPOSE, 50, 141301, 141301 + 300, 400));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/MagicCircleD-AnimatedSmoke.png",340 + osuXfix_COMPOSE, 56 + osuYfix_COMPOSE, new ColorType(111,179,208), 141846, 100, 2, 1000, 3));

            storyBoard.addSprite(SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot2.png", 143074, 143483, osuXfix_COMPOSE, 244 + osuYfix_COMPOSE, 255 + osuXfix_COMPOSE, 178 + osuYfix_COMPOSE));
            storyBoard.addSprite(SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot2.png", 143892, 144028, 512 + osuXfix_COMPOSE, 264 + osuYfix_COMPOSE, 419 + osuXfix_COMPOSE, 177 + osuYfix_COMPOSE));
            storyBoard.addSprite(SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot2.png", 144437, 144574, 420 + osuXfix_COMPOSE, -52 + osuYfix_COMPOSE, 335 + osuXfix_COMPOSE, 42 + osuYfix_COMPOSE));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/ring.png", 220 + osuXfix_COMPOSE, 268 + osuYfix_COMPOSE, new ColorType(111,179,208), 145119, 100, 3, 1000, 4));

            Sprite instantFlyingObject1 = SpriteExamplesLibrary.flyingObject("Niwashi SB/Lights.png", 146756 - 50, 146756 + 50, -168 + osuXfix_COMPOSE, 80 + osuYfix_COMPOSE, 668 + osuXfix_COMPOSE, 80 + osuYfix_COMPOSE);
            List<Sprite> trailObject1 = SpriteExamplesLibrary.addTrail(instantFlyingObject1,50,2);
            storyBoard.addSprites(trailObject1);

            Sprite instantFlyingObject2 = SpriteExamplesLibrary.flyingObject("Niwashi SB/Lights.png", 147307 - 50, 147307 + 50, 668 + osuXfix_COMPOSE, 85 + osuYfix_COMPOSE, -168 + osuXfix_COMPOSE, 85 + osuYfix_COMPOSE);
            List<Sprite> trailObject2 = SpriteExamplesLibrary.addTrail(instantFlyingObject2,50,2);
            storyBoard.addSprites(trailObject2);

            Sprite instantFlyingObject3 = SpriteExamplesLibrary.flyingObject("Niwashi SB/Lights.png", 147846 - 50, 147846 + 50, -168 + osuXfix_COMPOSE, 132 + osuYfix_COMPOSE, 668 + osuXfix_COMPOSE, 132 + osuYfix_COMPOSE);
            List<Sprite> trailObject3 = SpriteExamplesLibrary.addTrail(instantFlyingObject3,50,2);
            storyBoard.addSprites(trailObject3);

            Sprite ring2 = SpriteExamplesLibrary.finishBeat("Niwashi SB/ring2.png", 243 + osuXfix_COMPOSE, 344 + osuYfix_COMPOSE, new ColorType(111,179,208), 148256, 100, 1, 1000, 1.5);
            ring2.addAction(new Rotate(ring2.getStartLifetime(), ring2.getEndLifetime(),0, Math.PI));
            storyBoard.addSprite(ring2);

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 243 + osuXfix_COMPOSE, 344 + osuYfix_COMPOSE, 5, 148392, 148392 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 340 + osuXfix_COMPOSE, 329 + osuYfix_COMPOSE, 5, 148528, 148528 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 410 + osuXfix_COMPOSE, 260 + osuYfix_COMPOSE, 5, 148665, 148665 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 426 + osuXfix_COMPOSE, 163 + osuYfix_COMPOSE, 5, 148801, 148801 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 382 + osuXfix_COMPOSE, 75 + osuYfix_COMPOSE, 5, 148937, 148937 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 295 + osuXfix_COMPOSE, 30 + osuYfix_COMPOSE, 5, 149074, 149074 + 300, 150));

            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/Flare2.jpg", 424 + osuXfix_COMPOSE, 280 + osuYfix_COMPOSE, new ColorType(111,179,208), 150028, 100, 1.2, 1000, 1.5));

            //storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/Flare.jpg", 95 + 80 + osuXfix_COMPOSE, 72 + 80 + osuYfix_COMPOSE, new ColorType(111,179,208), 150574, 100, 1.5, 1000, 1.7));

            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 176 + osuXfix_COMPOSE, 28 + osuYfix_COMPOSE, 5, 149210, 149210 + 300, 150));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 127 + osuXfix_COMPOSE, 112 + osuYfix_COMPOSE, 6, 149346, 149346 + 290, 160));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 80 + osuXfix_COMPOSE, 216 + osuYfix_COMPOSE, 7, 149483, 149483 + 280, 170));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 153 + osuXfix_COMPOSE, 297 + osuYfix_COMPOSE, 8, 149619, 149619 + 270, 180));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 244 + osuXfix_COMPOSE, 380 + osuYfix_COMPOSE, 9, 149756, 149756 + 260, 190));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/SakuraPetalS.png", 352 + osuXfix_COMPOSE, 336 + osuYfix_COMPOSE, 10, 149892, 149892 + 250, 200));


            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 176 + osuXfix_COMPOSE, 28 + osuYfix_COMPOSE, new ColorType(111,179,208), 149210, 100, 0.5, 1000, 0.8));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 127 + osuXfix_COMPOSE, 112 + osuYfix_COMPOSE, new ColorType(111,179,208), 149346, 100, 0.5, 1000, 0.8));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 80 + osuXfix_COMPOSE, 216 + osuYfix_COMPOSE, new ColorType(111,179,208), 149483, 100, 0.5, 1000, 0.8));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 153 + osuXfix_COMPOSE, 297 + osuYfix_COMPOSE, new ColorType(111,179,208), 149619, 100, 0.5, 1000, 0.8));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 244 + osuXfix_COMPOSE, 380 + osuYfix_COMPOSE, new ColorType(111,179,208), 149756, 100, 0.5, 1000, 0.8));
            storyBoard.addSprite(SpriteExamplesLibrary.finishBeat("Niwashi SB/CyanogenArcRotor - LR.png", 352 + osuXfix_COMPOSE, 336 + osuYfix_COMPOSE, new ColorType(111,179,208), 149892, 100, 0.5, 1000, 0.8));


            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 176 + osuXfix_COMPOSE, 28 + osuYfix_COMPOSE, 15, 149210, 149210 + 300, 250));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 127 + osuXfix_COMPOSE, 112 + osuYfix_COMPOSE, 16, 149346, 149346 + 290, 260));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 80 + osuXfix_COMPOSE, 216 + osuYfix_COMPOSE, 17, 149483, 149483 + 280, 270));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 153 + osuXfix_COMPOSE, 297 + osuYfix_COMPOSE, 18, 149619, 149619 + 270, 280));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 244 + osuXfix_COMPOSE, 380 + osuYfix_COMPOSE, 19, 149756, 149756 + 260, 290));
            storyBoard.addSprites(SpriteExamplesLibrary.shot("Niwashi SB/triangle1.png", 352 + osuXfix_COMPOSE, 336 + osuYfix_COMPOSE, 110, 149892, 149892 + 250, 300));

            Sprite instantFlyingObject10 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149210 - 75, 149210 + 75, 668 + osuXfix_COMPOSE, 28 + osuYfix_COMPOSE, -168 + osuXfix_COMPOSE, 28 + osuYfix_COMPOSE);
            instantFlyingObject10.addAction(new Scale(instantFlyingObject10.getStartLifetime(), instantFlyingObject10.getEndLifetime(), 2, 2));
            List<Sprite> trailObject10 = SpriteExamplesLibrary.addTrail(instantFlyingObject10,50,0.5);
            storyBoard.addSprites(trailObject10);

            Sprite instantFlyingObject11 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149346 - 75, 149346 + 75, -168 + osuXfix_COMPOSE, 112 + osuYfix_COMPOSE, 668 + osuXfix_COMPOSE, 112 + osuYfix_COMPOSE);
            instantFlyingObject11.addAction(new Scale(instantFlyingObject11.getStartLifetime(), instantFlyingObject11.getEndLifetime(), 2, 2));
            List<Sprite> trailObject11 = SpriteExamplesLibrary.addTrail(instantFlyingObject11,50,0.5);
            storyBoard.addSprites(trailObject11);

            Sprite instantFlyingObject12 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149483 - 75, 149483 + 75, 668 + osuXfix_COMPOSE, 216 + osuYfix_COMPOSE, -168 + osuXfix_COMPOSE, 216 + osuYfix_COMPOSE);
            instantFlyingObject12.addAction(new Scale(instantFlyingObject12.getStartLifetime(), instantFlyingObject12.getEndLifetime(), 2, 2));
            List<Sprite> trailObject12 = SpriteExamplesLibrary.addTrail(instantFlyingObject12,50,0.5);
            storyBoard.addSprites(trailObject12);

            Sprite instantFlyingObject13 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149619 - 75, 149619 + 75, -168 + osuXfix_COMPOSE, 297 + osuYfix_COMPOSE, 668 + osuXfix_COMPOSE, 297 + osuYfix_COMPOSE);
            instantFlyingObject13.addAction(new Scale(instantFlyingObject13.getStartLifetime(), instantFlyingObject13.getEndLifetime(), 2, 2));
            List<Sprite> trailObject13 = SpriteExamplesLibrary.addTrail(instantFlyingObject13,50,0.5);
            storyBoard.addSprites(trailObject13);

            Sprite instantFlyingObject14 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149756 - 75, 149756 + 75, 668 + osuXfix_COMPOSE, 380 + osuYfix_COMPOSE, -168 + osuXfix_COMPOSE, 380 + osuYfix_COMPOSE);
            instantFlyingObject14.addAction(new Scale(instantFlyingObject14.getStartLifetime(), instantFlyingObject14.getEndLifetime(), 2, 2));
            List<Sprite> trailObject14 = SpriteExamplesLibrary.addTrail(instantFlyingObject14,50,0.5);
            storyBoard.addSprites(trailObject14);

            Sprite instantFlyingObject15 = SpriteExamplesLibrary.flyingObject("Niwashi SB/lightDot.png", 149892 - 75, 149892 + 75, -168 + osuXfix_COMPOSE, 336 + osuYfix_COMPOSE, 668 + osuXfix_COMPOSE, 336 + osuYfix_COMPOSE);
            instantFlyingObject15.addAction(new Scale(instantFlyingObject15.getStartLifetime(), instantFlyingObject15.getEndLifetime(), 2, 2));
            List<Sprite> trailObject15 = SpriteExamplesLibrary.addTrail(instantFlyingObject15,50,0.5);
            storyBoard.addSprites(trailObject15);

            Sprite lh10 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",176 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149210, 300);
            lh10.addAction(new Scale(lh10.getStartLifetime(),lh10.getEndLifetime(),2,2));
            storyBoard.addSprite(lh10);
            Sprite lh11 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",127 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149346, 300);
            lh11.addAction(new Scale(lh11.getStartLifetime(),lh11.getEndLifetime(),3,3));
            storyBoard.addSprite(lh11);
            Sprite lh12 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",80 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149483, 300);
            lh12.addAction(new Scale(lh12.getStartLifetime(),lh12.getEndLifetime(),4,4));
            storyBoard.addSprite(lh12);
            Sprite lh13 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",153 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149619, 300);
            lh13.addAction(new Scale(lh13.getStartLifetime(),lh13.getEndLifetime(),5,5));
            storyBoard.addSprite(lh13);
            Sprite lh14 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",244 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149756, 300);
            lh14.addAction(new Scale(lh14.getStartLifetime(),lh14.getEndLifetime(),6,6));
            storyBoard.addSprite(lh14);
            Sprite lh15 = SpriteExamplesLibrary.staticBeat("Niwashi SB/Lhighlight.png",352 + osuXfix_COMPOSE,200 + osuYfix_COMPOSE,ColorType.White, 149892, 300);
            lh15.addAction(new Scale(lh15.getStartLifetime(),lh15.getEndLifetime(),7,7));
            storyBoard.addSprite(lh15);

            storyBoard.addSprites(SpriteExamplesLibrary.fire("Niwashi SB/fire.png",198983,200983,272 + osuXfix_COMPOSE, 52 + osuYfix_COMPOSE, 10, 30, 240, 5));

            StoryboardWriter.output(storyBoard, new FileOutputStream("C:\\Users\\gifin\\AppData\\Local\\osu!\\Songs\\495772 Susumu Hirasawa - Niwashi KING\\Susumu Hirasawa - Niwashi KING (firedigger).osb"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
