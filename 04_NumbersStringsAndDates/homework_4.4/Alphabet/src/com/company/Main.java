package com.company;

public class Main {

    public static void main(String[] args)  {
	// Напишите код, который распечатает коды всех букв английского алфавита и сами буквы.
       String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLOMNOPQRSTUVWZYZ";
       for(int i = 0; i < alphabet.length(); i++){
           System.out.println("Коду: "+ (int)alphabet.charAt(i) + " соответствует символ: " + alphabet.charAt(i));
       }
    }
}
