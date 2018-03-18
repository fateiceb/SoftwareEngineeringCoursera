package com.nwnu;

import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    public static int randomIntScope(int left,int right){
        return random.nextInt(right-left+1)+left;
    }

    public static int randomInt(int right){
        return random.nextInt(right);
    }


}
