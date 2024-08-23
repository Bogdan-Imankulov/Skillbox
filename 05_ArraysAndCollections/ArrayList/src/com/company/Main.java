package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Для выхода из программы наберите EXIT\nДля помощи наберите HELP");
        ArrayList<String> todoList = new ArrayList<>();
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] inputWords = input.split(" ");
            switch (inputWords[0]) {
                case "EXIT":
                    return;
                case "ADD":
                    add(inputWords, todoList);
                    break;
                case "LIST":
                    list(todoList);
                    break;
                case "HELP":
                    System.out.println("LIST — выводит дела с их порядковыми номерами\n" +
                            "ADD - добавляет дело в конец списка или дело на определенное место, указанное пользователем\n" +
                            "EDIT - заменяет дело с указанным номером\n" +
                            "DELETE - удаляет  дело по указанному номеру или по названию дела.");
                    break;
                case "EDIT":
                    edit(inputWords, todoList);
                case "DELETE" : delete(inputWords,todoList);
                default:
                    System.out.println("Такой команды не существует, для помощи наберите HELP");
                    break;
            }
        }
    }

    private static ArrayList<String > delete(String[] inputWords, ArrayList<String> todoList) {
        if (inputWords.length == 1)
            System.out.println("Нет такой команды, наберите HELP");
        else if (inputWords[1].matches("\\d+") && Integer.parseInt(inputWords[1]) >= todoList.size()) {
            System.out.println("Место, откуда вы хотите удалить дело находится за пределами списка! Для помощи наберите HELP");
        } else if (inputWords[1].matches("\\d+")) {
            todoList.remove(Integer.parseInt(inputWords[1]));
            System.out.println("Вы удалили \"" + textPrint(inputWords) + "\" с " +todoList.indexOf(textPrint(inputWords))
                    + " места в списке.");
        } else  if (!inputWords[1].matches("\\d+")){
            todoList.remove(textPrint(inputWords));
            System.out.println("Вы удалили \"" + textPrint(inputWords) + "\" с " +todoList.indexOf(textPrint(inputWords))
                    + " места в списке.");
        }
        return todoList;
    }

    private static ArrayList<String> edit(String[] inputWords, ArrayList<String> todoList) {
        if (inputWords.length == 1)
            System.out.println("Нет такой команды, наберите HELP");
        else if (inputWords[1].matches("\\d+") && Integer.parseInt(inputWords[1]) >= todoList.size()) {
            System.out.println("Место, где вы хотите заменить дело находится за пределами списка! Для помощи наберите HELP");
        } else if (inputWords[1].matches("\\d+")) {
            todoList.set(Integer.parseInt(inputWords[1]), textPrint(inputWords));
            System.out.println("Вы занесли \"" + textPrint(inputWords) + "\" на " +todoList.indexOf(textPrint(inputWords))
                    + " место в списке.");

        }
        return todoList;
    }
    private static void list(ArrayList<String> todoList) {
        System.out.println("список ваших дел:");
        for (int i = 0; i < todoList.size(); i++) {
            System.out.println(i + " - " + todoList.get(i));
        }
    }

    private static ArrayList<String> add(String[] inputWords, ArrayList<String> todoList) {
        if (inputWords.length == 1)
            System.out.println("Нет такой команды, наберите HELP");
        else if (inputWords[1].matches("\\d+") && Integer.parseInt(inputWords[1]) > todoList.size()) {
            System.out.println("Место, куда вы хотите записать дело находится за пределами списка! Для помощи наберите HELP");
        }else if (inputWords[1].matches("\\d+")){
            todoList.add(Integer.parseInt(inputWords[1]),textPrint(inputWords));
            System.out.println("Вы занесли \""+textPrint(inputWords)+"\" на "+ todoList.indexOf(textPrint(inputWords))+
                    " место в списке.");
        }else if (!inputWords[1].matches("\\d")){
            todoList.add(textPrint(inputWords));
            System.out.println("Вы занесли \""+textPrint(inputWords)+"\" в конец списка.");
        }
        return todoList;
    }

    private static String textPrint(String[] inputWords) {
        String text = "";
        int k = 0;
        if (!inputWords[1].matches("\\d+"))
            k=1;
        else k = 2;
        for (int i = k; i < inputWords.length; i++) {
            text += inputWords[i] + " ";
        }
        return text;
    }
}
