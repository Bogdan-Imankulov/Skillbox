package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String[][] arrForX = new String[7][7];
//        for (int i = 0; i < 7; i++) {
//            for (int j = 0; j < 7; j++) {
//                arrForX[i][j] = "x";
//                arrForX[i][arrForX.length-j-1] = "x";
//                System.out.print(arrForX[i][j]);
//            }
//            System.out.println();
//        }
        for (int i = 0; i < 7; i++) {
            for (int k = 0; k < 7; k++) {
                if ((i+k) % 6 == 0) {
                    arrForX[i][k] = "X";
                } else {
                    arrForX[i][k] = " ";
                    arrForX[i][i] = "X";
                }
                System.out.print(arrForX[i][k]);
            }
            System.out.println();
        }
    }
}
