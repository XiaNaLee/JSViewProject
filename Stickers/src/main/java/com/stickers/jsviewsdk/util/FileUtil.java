package com.stickers.jsviewsdk.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.InputStreamReader;

;

/**
 * Created by LiYong on 2017/9/20.
 * Email:lee131483@gmail.com
 * Version:
 */

public class FileUtil {

    public static String getJsContent(Context context, String filename) {
        InputStreamReader reader;
        BufferedReader bufferedReader;
        try {
            reader = new InputStreamReader(context.getAssets().open(filename), "UTF-8");
            bufferedReader = new BufferedReader(reader);
            String s;
            StringBuffer sb = new StringBuffer();
            while ((s = bufferedReader.readLine()) != null) {
                sb.append(s).append("\n");
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
