package com.company;

public class Main {

    public static void main(String[] args) {
        // write your code here

        String[][] arrX = new String[7][7];
        for (int i = 0; i < arrX.length; i++) {
            for (int j = 0; j < arrX[i].length; j++) {
                arrX[i][j] = " ";
                if ((i + j) % (arrX.length - 1) == 0 || i == j )
                    arrX[i][j] = "X";
                System.out.print(arrX[i][j]);
            }
            System.out.println();
        }
    }
}
