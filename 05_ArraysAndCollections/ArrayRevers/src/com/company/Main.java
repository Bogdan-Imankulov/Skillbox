package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String[] arrMnemo = {"Каждый", "охотник", "желает","знать,","где","сидит","фазан"};
        String[] arrRevers = new String[arrMnemo.length];
        for (int i = 0; i < arrMnemo.length ; i++) {
            arrRevers[i] = arrMnemo[arrMnemo.length - (1+i)];
            System.out.println(arrRevers[i]);
        }
    }
}
