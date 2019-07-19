package com.github.bartimaeusnek.croploadcore;

import java.util.SplittableRandom;

public class MyRandom {

    public static int intrandom(int max, int min) {
        if (max < min) {
            int a = max;
            int b = min;
            min = a;
            max = b;
        }
        SplittableRandom random = new SplittableRandom(System.nanoTime());
        return random.nextInt((max - min) + 1) + min;
    }

    public static float floatrandom(float max, float min) {
        if (max < min) {
            float a = max;
            float b = min;
            min = a;
            max = b;
        }
        SplittableRandom random = new SplittableRandom(System.nanoTime());
        return (float) (min + random.nextDouble() * (max - min));
    }

}
