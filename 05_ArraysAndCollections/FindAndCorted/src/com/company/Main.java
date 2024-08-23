package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {


    public static void main(String[] args) {
        // write your code here
        // A123BC198
        String[] letters = {"A", "B", "E", "K", "M", "H", "O", "P", "C", "T", "Y", "X"};
        ArrayList<String> arrayList;
        ArrayList<String> middleList ;
        arrayList = firstAdditional(letters);
        middleList = addingLetters(arrayList,letters);
        arrayList.clear();
        arrayList = addRegion(middleList);
        Collections.sort(arrayList);
        HashSet<String > hashSet = addHashSet(arrayList);
        TreeSet<String > treeSet = addTreeSet(arrayList);
        Scanner scanner = new Scanner(System.in);
        String regex = "^[A-Z]{1}\\d{3}[A-Z]{2}\\d{2,3}$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("Введите автомобильный номер в формате B123DD123, количество последних цифр может быть две\n" +
                "для выхода из прораммы наберите EXIT");

        while (true){

            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (input.equals("EXIT")){
                break;
            }
            if (!matcher.find()){
                System.out.println("вы ввели неправильный номер\n" );
            }else {

                long start = System.nanoTime();
                if (arrayList.contains(input))
                {
                    long finish = System.nanoTime();
                    System.out.println("ArrayList Поиск перебором: номер найден, поиск занял " + (finish - start) + "нс");
                }else {
                    long finish = System.nanoTime();
                    System.out.println("ArrayList Поиск перебором: номер не найден, поиск занял " + (finish - start) + "нс");
                }
                long start1 = System.nanoTime();
                if (Collections.binarySearch(arrayList,input) < 0){
                    long finish = System.nanoTime();
                    System.out.println("ArrayList бинарный поиск: номер не найден, поиск занял " + (finish - start1) + "нс");
                }else {
                    long finish = System.nanoTime();
                    System.out.println("ArrayList бинарный поиск: номер найден, поиск занял " + (finish - start1) + "нс");
                }
                long start2 = System.nanoTime();
                if(hashSet.contains(input)){
                    long finish = System.nanoTime();
                    System.out.println("Поиск в HashSet: номер найден, поиск занял " + (finish - start2));
                }else {
                    long finish = System.nanoTime();
                    System.out.println("Поиск в HashSet: номер найден, поиск занял " + (finish - start2));
                }
                long start3 = System.nanoTime();
                if (treeSet.contains(input)) {
                    long finish = System.nanoTime();
                    System.out.println("Поиск в TreeSet: номер найден, поиск занял " + (finish - start3));
                }else {
                    long finish = System.nanoTime();
                    System.out.println("Поиск в TreeSet: номер не найден, поиск занял " + (finish - start3));
                }
            }
        }

    }

    private static TreeSet<String> addTreeSet(ArrayList<String> arrayList) {
        TreeSet<String > treeSet = new TreeSet<>();
        treeSet.addAll(arrayList);
        return treeSet;
    }

    private static HashSet<String> addHashSet(ArrayList<String> arrayList) {
        HashSet<String> hashSet = new HashSet<>();
        for(String str : arrayList){
            hashSet.add(str);
        }
        return hashSet;
    }

    private static ArrayList<String> addRegion(ArrayList<String> middleList) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (String str : middleList){
            for (int i = 1; i < 199; i++) {
                String num = String.format("%s%02d",str,i);
                arrayList.add(num);
            }
        }
        return arrayList ;
    }

    private static ArrayList<String > addingLetters(ArrayList<String> arrayList, String[] letters) {
        ArrayList<String> middleList = new ArrayList<>();
        for (String str : arrayList){
            for (String letter : letters){
                for (String letter1 : letters){
                    // вторая буквенная часть типа АА ВВ СС, Если удалить этот блок, то будут все возможные
                    // буквенные выраженя АС ВС и т.д.
                    if (letter.equals(letter1)) {
                        String middleNum = String.format("%s%s%s",str,letter,letter);
                        middleList.add(middleNum);
                    }
                }
            }
        }
        return middleList;
    }

    private static ArrayList<String> firstAdditional(String[] letters) {
        ArrayList<String> arrayList = new ArrayList<>();
        // перебираем  первую букву номера
        for (String letter : letters) {
            // для для каждой буквы перебираем первые три цифры
            for (int i = 1; i < 1000; i++) {
                // номера типа 001
                if (i < 10) {
                    //  форматируем и вносим в String middleNum
                    String middleNum = String.format("%1$s%2$03d", letter, i);
                    // заносим в ArrayList промежуточный
                    arrayList.add(middleNum);
                    // номера типа 011 055 088
                } else if (i > 10 && i < 100) {
                    if (i % 11 == 0) {
                        //  форматируем и вносим в String middleNum
                        String middleNum = String.format("%1$s%2$03d", letter, i);
                        // заносим в ArrayList промежуточный
                        arrayList.add(middleNum);
                    }// номера типа 111 222 666 888
                } else if (i % 100 == 0 || i % 111 == 0) {
                    //  форматируем и вносим в String middleNum
                    String middleNum = String.format("%1$s%2$03d", letter, i);
                    // заносим в ArrayList промежуточный
                    arrayList.add(middleNum);
                }
            }
        }
        return arrayList;
    }


}



















