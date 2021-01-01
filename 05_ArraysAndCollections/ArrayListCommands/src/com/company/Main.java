package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        ArrayList<String> todoList = new ArrayList<>();
        System.out.println("Для того чтобы завершить работу с списком дел, напишите команду \"EXIT\"");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit"))
                break;
            String[] inputArrSplit = input.split(" ");
            switch (inputArrSplit[0]) {
                case "EDIT":
                    if (inputArrSplit.length <= 2 || !(inputArrSplit[1].matches("\\d+"))) {
                        System.out.println("Наберите \"EDIT (порядковый номер списка, который вы заменяете) Новое название / содержимое дела\"");
                    } else {
                        editList(todoList, inputArrSplit);
                    }
                    break;
                case "ADD":
                    if (inputArrSplit.length == 1) {
                        System.out.println("Команда введена  неверно. \n Шаблон команды: \"ADD Содержимое / название дела\"");
                    } else if (inputArrSplit[1].matches("\\d+") && inputArrSplit.length > 2) {
                        addWithNum(todoList, inputArrSplit);
                    } else{
                        addToList(todoList, inputArrSplit);
                    }
                    break;
                case "DELETE":
                    if (inputArrSplit.length == 1 || !inputArrSplit[1].matches("\\d+")) {
                        System.out.println("Наберите \"DELETE (порядковый номер списка, который хотите удалить)\"");
                    }else if(inputArrSplit[1].matches("\\d+")){
                        deleteFromList(todoList, inputArrSplit);
                    }
                    break;
                case "LIST":
                    writeList(todoList);
                    break;
                default:
                    System.out.println("Неверная команда. Список команд:\n \"ADD\"\n \"EDIT\"\n \"LIST\"\n \"DELETE\"\n \"EXIT\"");
                    break;
            }
        }
    }

    public static ArrayList<String> addToList(ArrayList<String> arrayList, String[] strArrToAdd) {
        String textToAdd = "";
        for (int i = 1; i < strArrToAdd.length; i++) {
            textToAdd += strArrToAdd[i] + " ";
        }
        arrayList.add(textToAdd);
        return arrayList;
    }

    public static ArrayList<String> addWithNum(ArrayList<String> arrayList, String[] strArr) {
        String textToAdd = "";
        if (Integer.parseInt(strArr[1]) > arrayList.size()) {
            System.out.println("Неверно указан порядковый номер, он больше длины списка, пожалуйста введите верный номер.");
            System.out.println("Для того чтобы узнать длину списка введите команду \"LIST\"");
        } else {
            for (int i = 2; i < strArr.length; i++) {
                textToAdd += strArr[i] + " ";
            }
            arrayList.add(Integer.parseInt(strArr[1]), textToAdd);
        }
        return arrayList;
    }

    public static void writeList(ArrayList<String> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(i + " - " + arrayList.get(i));
        }
    }

    public static ArrayList<String> deleteFromList(ArrayList<String> arrayList, String[] strArr) {
        if (Integer.parseInt(strArr[1]) >= arrayList.size()) {
            System.out.println("Неверно указан порядковый номер, он больше длины списка, пожалуйста введите верный номер.");
            System.out.println("Для того чтобы узнать длину списка введите команду \"LIST\"");
        } else {
            arrayList.remove(Integer.parseInt(strArr[1]));
        }
        return arrayList;
    }

    public static ArrayList<String> editList(ArrayList<String> arrayList, String[] strArr) {
        String textToAdd = "";
        if (Integer.parseInt(strArr[1]) >= arrayList.size()) {
            System.out.println("Неверно указан порядковый номер, он больше длины списка, пожалуйста введите верный номер.");
            System.out.println("Для того чтобы узнать длину списка введите команду \"LIST\"");
        } else {
            for (int i = 2; i < strArr.length; i++) {
                textToAdd += strArr[i] + " ";
            }
            arrayList.set(Integer.parseInt(strArr[1]), textToAdd);
        }
        return arrayList;
    }
}