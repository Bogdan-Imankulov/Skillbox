package com.company;

import java.util.Scanner;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TreeSet<String> email = new TreeSet<>();
        System.out.println("Для выхода из программы наберите EXIT\nДля помощи наберите HELP");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputWords = input.split(" ");
            switch (inputWords[0]) {
                case "EXIT":
                    return;
                case "ADD":
                    add(inputWords, email);
                    break;
                case "LIST":
                    list(email);
                    break;
                case "HELP":
                    System.out.println("Для того, чтобы добавить емайл, наберите \"ADD нужный_емайл@почтовый_сервис.домен\"\n" +
                            "Для того, чтобы просмотреть список емайлов, наберите \"LIST\"");
                    break;
                default:
                    System.out.println("Такой команды нет, наберите HELP");

            }
        }
    }

    private static void list(TreeSet<String> email) {
        if (email.size() == 0){
            System.out.println("Вы еще ничего не добавляли в список!");
        }else {
            for (String str : email) {
                System.out.println(str);
            }
        }

    }

    private static TreeSet add(String[] inputWords, TreeSet<String> email) {
        String pattern = "^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}$";
        Pattern patternPattern = Pattern.compile(pattern);
        Matcher matcher = patternPattern.matcher(inputWords[1]);
        if (inputWords.length != 2) {
            System.out.println("Вы неправильно ввели команду, для помощи наберите HELP");
        } else if (matcher.find()) {
            email.add(inputWords[1]);
            System.out.println("Вы добавили емайл: \"" + inputWords[1]+ "\" в список!");
        } else System.out.println("Емайл, который вы ввели, не корректный!");

        return email;
    }
}
