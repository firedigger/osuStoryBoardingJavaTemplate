package com.company.Storyboards;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by DELL on 2/7/2016.
 */
public class StoryboardWriter {

    public static void output(StoryBoard storyBoard, FileOutputStream stream) {
        String str = storyBoard.toString();

        //System.err.println(str);

        //if (true)
        //    return;

        byte[] contentInBytes = str.getBytes();

        try {
            stream.write(contentInBytes);
            stream.flush();
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
