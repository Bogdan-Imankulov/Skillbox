package com.company;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TreeSet<String> emailList = new TreeSet<>();
        System.out.println("Для того чтобы завершить работу с списком дел, напишите команду \"EXIT\"");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit"))
                break;
            String[] inputArrSplit = input.split(" ");
            if (inputArrSplit.length > 3) {
                System.out.println("Слишком много аргументов, проверьте E-Mail на лишние пробелы");
            } else {
                switch (inputArrSplit[0]) {
                    case "ADD":
                            add(emailList, inputArrSplit);
                            break;
                    case "DELETE":
                            delete(emailList, inputArrSplit);
                            break;
                    case "LIST":
                        write(emailList);
                        break;
                    default:
                        System.out.println("Неверная команда. Список команд:\n \"ADD\"\n \"EDIT\"\n \"LIST\"\n \"DELETE\"\n \"EXIT\"");
                        break;
                }
            }
        }
    }

    private static TreeSet delete(TreeSet<String> emailList, String[] inputArrSplit) {
        if (inputArrSplit.length == 2){
            if (inputArrSplit[1].matches("\\d+")){
                if (Integer.parseInt(inputArrSplit[1]) > emailList.size()){
                    System.out.println("Элемент списка который вы хотите удалить, находится за пределами списка.\n" +
                            "Для того чтобы узнать какие E-Mail'ы находятся в списке, и их номера введите команду \"LIST\"");
                }else{
                    emailList.remove(Integer.parseInt(inputArrSplit[1]));
                    System.out.println("Элемент на месте " + Integer.parseInt(inputArrSplit[1]) + " был успешно удален");
                }
            }else{
                System.out.println("Введите порядковый номер E-Mail, который вы хотите удалить.\n" +
                        "Для того чтобы узнать какие E-Mail'ы находятся в списке, и их номера введите команду \"LIST\"");
            }
        }else{
            System.out.println("Введите порядковый номер E-Mail, который вы хотите удалить.\n" +
                    "Для того чтобы узнать какие E-Mail'ы находятся в списке, и их номера введите команду \"LIST\"");
        }

        return emailList;
    }

    private static TreeSet add(TreeSet<String> emailList, String[] inputArrSplit) {
        if (inputArrSplit.length == 2){
            if(inputArrSplit[1].matches("^([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.[a-z]{2,6}$")){
                emailList.add(inputArrSplit[1]);
                System.out.println("E-Mail был успешно добавлен, введите \"LIST\", чтобы увидеть все E-Mail'ы");
            }else{
                System.out.println("Неверный E-Mail");
            }
        }else{
            System.out.println("Введите \"ADD\" и E-Mail который вы хотите добавить.");
        }

        return emailList;
    }

    private static void write(TreeSet<String> emailList){
        if (emailList.size() == 0){
            System.out.println("Ваш список пустой, добавьте в него E-Mail");
        }
        for (String text : emailList) {
            System.out.println(text);
        }
    }

}
