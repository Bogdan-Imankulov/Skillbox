package com.company;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Для выхода из программы наберите EXIT");
        TreeMap<String, String> namePhoneNumber = new TreeMap<>();
        //коды разных стран бывают от 1 до 3 цифр, Пуэрто-Рико +1787 при вводе разделители () пробелы, -
        String patternPhone = "^\\+\\d{1,4}\\s*\\(*\\d{3}\\)*\\s*\\d{3}-*\\s*\\d{2}-*\\s*\\d{2}$";
        //имя контакта может быть на кирилице, латинице и может быть Анна Анна1 Анна2 и т.д.
        String patternName = "^[a-zA-Zа-яА-Я']*[a-zA-Zа-яА-Я-' ]+[a-zA-Zа-яА-Я']?\\d*";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            Pattern pattern = Pattern.compile(patternPhone);
            Pattern pattern1 = Pattern.compile(patternName);
            Matcher matcher = pattern.matcher(input);
            Matcher matcher1 = pattern1.matcher(input);
            if (input.equals("LIST")) {
                printTreeMap(namePhoneNumber);
            } else if (input.equals("EXIT")) {
                break;
            } else if (matcher.find()) {
                String phoneNumber = phoneFormat(input);

                if (namePhoneNumber.containsValue(phoneNumber)) {
                    findKey(namePhoneNumber, phoneNumber);
                } else {
                    System.out.println("Введите имя контакта ");
                    while (true) {
                        String name = scanner.nextLine();
                        if (checkName(namePhoneNumber, name))
                            System.out.println("Такое имя уже существует, Введите Другое Имя");
                        else {
                            namePhoneNumber.put(name, phoneNumber);
                            System.out.println("вы создали новый контакт\nName: "+name+", phone: "+ namePhoneNumber.get(name));
                            break;
                        }
                    }
                }

            } else if (matcher1.find()) {
                if (checkName(namePhoneNumber, input))
                    System.out.println("Name: " + input + ", phone: " + namePhoneNumber.get(input));
                else {
                    System.out.println("Контакта с таким именем не существует, если вы хотите его создать введите номер телефона,\n " +
                            "если вы не хотите создавать контакт наберите NO");
                    while (true) {
                        String phone = scanner.nextLine();
                        if (phone.equals("NO"))
                            break;
                        else if (matcher.find()) {
                            String phoneNumber = phoneFormat(phone);
                            namePhoneNumber.put(input, phoneNumber);
                            System.out.println("вы создали новый контакт\nName: " + input + ", phone: " + namePhoneNumber.get(input));
                            break;
                        }else System.out.println("Наберите или номер телефона или команду NO");
                    }
                }

            } else
                System.out.println("""
                        наберите номер телефона в формате +кодСтраны (ххх) ххх-хх-хх
                        или +кодСтраны хххххххххх
                        или +кодСтраны ххх ххх хх хх
                        или имя, или фамилию, или никнейм""");


        }
    }



    private static boolean checkName(TreeMap<String, String> namePhoneNumber, String name) {
        for (String key : namePhoneNumber.keySet()) {
            if (name.equals(key))
                return true;
        }
        return false;
    }

    private static void findKey(TreeMap<String, String> namePhoneNumber, String phoneNumber) {
        for (String key : namePhoneNumber.keySet()) {
            if (phoneNumber.equals(namePhoneNumber.get(key))) {
                System.out.println("Name: " + key + ", Phone: " + namePhoneNumber.get(key));
            }
        }
    }

    private static String phoneFormat(String input) {
        String phoneNumber = input.replaceAll("[^\\+\\d+]", "");
        phoneNumber = phoneNumber.replaceAll("^8", "+7");
        return phoneNumber;
    }

    private static void printTreeMap(TreeMap<String, String> namePhoneNumber) {
        for (String key : namePhoneNumber.keySet()) {
            System.out.println(key + " : " + namePhoneNumber.get(key));
        }
    }

}

