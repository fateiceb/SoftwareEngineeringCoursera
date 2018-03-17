package com.company;

import java.util.Random;

public class RandomUtil {

    private static Random random = new Random();

    public static int randomIntScope(int left,int right){
        return random.nextInt(right-left+1)+left;
    }

    public static int randomInt(int right){
        return random.nextInt(right);
    }

    public static void main(String[] args){
        for (int i = 0 ;i< 100;i++){
            System.out.println(randomIntScope(3,5));
        }
    }

}
