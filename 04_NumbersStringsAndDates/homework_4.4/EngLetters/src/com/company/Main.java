package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String engAlphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int count = 0;
        while (count < engAlphabet.length())
        {
            System.out.println(engAlphabet.charAt(count));
            System.out.println((int) engAlphabet.charAt(count));
            count++;
        }
    }
}
