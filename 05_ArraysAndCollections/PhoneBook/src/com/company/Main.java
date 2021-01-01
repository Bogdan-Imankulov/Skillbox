package com.company;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Чтобы увидеть список команд, напишите \"HELP\"");
        System.out.println("Напишите команду \"EXIT\", чтобы выйти из программы.");
        System.out.println("Напишите команду \"LIST\", чтобы вывести список всех контактов");
        System.out.println("Чтобы добавить контакта введите номер из 11 цифр без пробелов, плюсов, скобок, тире или введите имя контакта.");
        System.out.println("Введите имя контакта по шаблону \"АлександрСергеевич2\", \"Александр сергеевич\", \"Александр-Сергеевич\"");
        System.out.println("Введите номер телефона по шаблону \"77085845526\", \"81679538820\", номер должен состоять из 11 цифр, и только цифр");
        TreeMap<String, String> phoneBook = new TreeMap<>();
        ArrayList<String> keyBook = new ArrayList<>();
        ArrayList<String> valueBook = new ArrayList<>();
        while (true) {
            int digitCount = 0;
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            input = input.trim();
            for (Character c : input.toCharArray()) {
                if (Character.isDigit(c)) {
                    digitCount++;
                }
            }
            switch (input) {
                case "EXIT":
                    return;
                case "LIST":
                    if (phoneBook.size() == 0) {
                        System.out.println("В телефонной книге нет контактов, " +
                                "добавьте минимум 1 контакт, " +
                                "чтобы увидеть список команд напишите \"HELP\"");
                    }
                    for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                        System.out.println("Имя: " + entry.getKey() + ", Номер: " + entry.getValue());
                    }
                    continue;
                case "HELP":
                    System.out.println("Напишите команду \"EXIT\", чтобы выйти из программы.");
                    System.out.println("Напишите команду \"LIST\", чтобы вывести список всех контактов");
                    System.out.println("Чтобы добавить контакта введите номер из 11 цифр без пробелов, плюсов, скобок, тире или введите имя контакта.");
                    System.out.println("Введите имя контакта по шаблону \"АлександрСергеевич2\", \"Александр сергеевич\", \"Александр-Сергеевич\"");
                    System.out.println("Введите номер телефона по шаблону \"77085845526\", \"81679538820\", номер должен состоять из 11 цифр, и только цифр");
                    continue;
            }
            if (digitCount == input.length() && input.matches("^\\d{11}$")) {
                for (int i = 0; i < phoneBook.size(); i++) {
                    if (input.equalsIgnoreCase(valueBook.get(i))) {
                        System.out.println("Такой контакт уже есть в телефонной книжке, данные контакта:");
                        System.out.println("Имя: " + keyBook.get(i) + ", Номер: " + valueBook.get(i));
                        break;
                    }
                }

                if (!phoneBook.containsValue(input)) {
                    if (input.matches("[а-яА-Яa-zA-Z\\-]\\d*\\s*")) {
                        System.out.println("Неверное имя контакта, введите имя по шаблону \"АлександрСергеевич2\", \"Александр сергеевич\", \"Александр-Сергеевич\"");
                    } else {
                        System.out.println("Добавьте имя контакта");
                        Scanner tempScanner = new Scanner(System.in);
                        String tempInput = tempScanner.nextLine();
                        tempInput = tempInput.trim();
                        phoneBook.put(tempInput, input);
                        System.out.println("Имя добавлено");
                        keyBook.add(tempInput);
                        valueBook.add(input);
                    }
                }
            } else if (input.matches(/*"^[а-яА-Яa-zA-Z\\-]\\d*\\s*"*/"^[a-zA-Zа-яА-Я']*[a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?\\d*")) {
                for (int i = 0; i < phoneBook.size(); i++) {
                    if (input.equalsIgnoreCase(keyBook.get(i))) {
                        System.out.println("Такой контакт уже есть в телефонной книжке, данные контакта:");
                        System.out.println("Имя: " + keyBook.get(i) + ", Номер: " + valueBook.get(i));
                        break;
                    }
                }
                if (!phoneBook.containsKey(input)) {
                    System.out.println("Добавьте номер телефона контакта");
                    Scanner tempScanner = new Scanner(System.in);
                    String tempInput = tempScanner.nextLine();
                    tempInput = tempInput.trim();
                    for (Character c : tempInput.toCharArray()) {
                        if (Character.isDigit(c)) {
                            digitCount++;
                        }
                    }
                    if (digitCount == tempInput.length() && tempInput.matches("^\\d{11}$")) {
                        for (int i = 0; i < phoneBook.size(); i++) {
                            if (input.equalsIgnoreCase(valueBook.get(i))) {
                                System.out.println("Такой контакт уже есть в телефонной книжке, данные контакта:");
                                System.out.println("Имя: " + keyBook.get(i) + ", Номер: " + valueBook.get(i));
                                break;
                            }
                        }
                        phoneBook.put(input, tempInput);
                        System.out.println("Номер добавлен");
                        valueBook.add(tempInput);
                        keyBook.add(input);
                    } else {
                        System.out.println("Введите номер телефона по шаблону \"77085845526\", \"81679538820\"\n" +
                                "Номер должен состоять из 11 цифр, и только цифр");
                    }
                }
            } else {
                System.out.println("Неверное имя контакта, или телефон");
                System.out.println("Введите имя по шаблону \"АлександрСергеевич2\", \"Александр сергеевич\", \"Александр-Сергеевич\"");
                System.out.println("Или введите номер телефона по шаблону \"77085845526\", \"81679538820\", номер должен состоять из 11 цифр, и только цифр");
            }
        }
    }
}
