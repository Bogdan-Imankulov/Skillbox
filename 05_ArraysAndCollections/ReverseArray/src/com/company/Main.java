package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String str = "Каждый охотник желает знать, где сидит фазан";
        String[] strings1 = str.split(",?\\s+");
        String[] strings = new String[strings1.length];
        int j = 0;
        for (int i = 0; i < strings1.length; i++) {
            j = strings1.length - i - 1;
            strings[i] = strings1[j];
            System.out.println(strings[i]);
        }
    }
}
