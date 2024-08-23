package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] colorsOfRainbow = {"Каждый", "охотник", "желает", "знать,", "где", "сидит", "фазан"};
        String [] colorsRevers = new String[colorsOfRainbow.length];
        for (int i = 0; i < colorsOfRainbow.length; i++) {
            colorsRevers[i] = colorsOfRainbow[colorsOfRainbow.length -(1+i)];
            System.out.println(colorsRevers[i]);
        }
    }
}
