package com.example.demo;

public class GamePlatform {
    public static double getFinalSpeed(double initialSpeed, int[] inclinations) {
        double finalSpd = initialSpeed;

        for (int incline : inclinations) {
            System.out.println(finalSpd);
            finalSpd -= incline;
        }

        return finalSpd;
    }

    public static void main(String[] args) {
        System.out.println(getFinalSpeed(60.0, new int[]{0, -30, 0, 45, 0})); //should print 45 } }
    }
}