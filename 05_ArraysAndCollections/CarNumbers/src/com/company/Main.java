package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // write your code here
        System.out.println("Чтобы выйти из программы, напишите \"EXIT\"");
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("EXIT")) {
                break;
            }
            if (!input.matches("[A-Z]{1}\\d{3}[A-Z]{2}\\d{2}")){
                System.out.println("Неверный формат номера");
                break;
            }


            //=====================================================================================

            ArrayList<String> firstArrayList = arrayListCreator();
            long millis1 = System.nanoTime();
            if (firstArrayList.contains(input)) {
                System.out.println("Номер найден с помощью Array List Contains" +
                        "\nВремя поиска First Array List Contains: " + (System.nanoTime() - millis1) + "\n");
            } else {
                System.out.println("Номер не был найден с помощью Array List Contains" +
                        "\nВремя поиска First Array List Contains: " + (System.nanoTime() - millis1) + "\n");
            }


            //=====================================================================================

            ArrayList<String> secondArrayList = arrayListCreator();
            Collections.sort(secondArrayList);
            long millis2 = System.nanoTime();
            if (Collections.binarySearch(secondArrayList, input) >= 0) {
                System.out.println("Номер найден с помощью Array list binary search" +
                        "\nВремя поиска Second Array List Binary Search: " + (System.nanoTime() - millis2) + "\n");
            } else {
                System.out.println("Номер не найден с помощью Array list binary search" +
                        "\nВремя поиска Second Array List Binary Search: " + (System.nanoTime() - millis2) + "\n");
            }


            //=====================================================================================

            HashSet<String> hashSet = hashSetCreator();
            long millis3 = System.nanoTime();
            if (hashSet.contains(input)) {
                System.out.println("Номер найден с помощью Hash Set Contains" +
                        "\nВремя поиска Hash Set Contains:" + (System.nanoTime() - millis3) + "\n");
            } else {
                System.out.println("Номер не найден с помощью Hash Set Contains" +
                        "\nВремя поиска Hash Set Contains:" + (System.nanoTime() - millis3) + "\n");
            }

            //=====================================================================================

            TreeSet<String> treeSet = treeSetCreator();
            long millis4 = System.nanoTime();
            if (treeSet.contains(input)) {
                System.out.println("Номер найден с помощью Tree Set Contains" +
                        "\nВремя поиска Tree Set Contains:" + (System.nanoTime() - millis4));
            } else {
                System.out.println("Номер не найден с помощью  Tree Set Contains" +
                        "\nВремя поиска Tree Set Contains:" + (System.nanoTime() - millis4));
            }
        }
        /*for (int i = 0; i < 25; i++) {
            System.out.println(carNumbersCreator());
        }*/
    }

    private static ArrayList<String> arrayListCreator() {
        char[] symbols = {'A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'};
        final int NUMBER_COUNT = 1000, DIGIT_COUNT = 10;
        ArrayList<String> array = new ArrayList<>();
        int region;
        for (char letter : symbols) {
            for (int number = 1; number < NUMBER_COUNT; number++) {
                region = (int) (Math.random() * 198 + 1);
                if (number < 10) {
                    if (region < 10) {
                        array.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        array.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                } else if (number > 10 && number < 100) {
                    if (number % 11 == 0) {
                        if (region < 10) {
                            array.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                        } else {
                            array.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                        }
                    }
                } else if (number % 100 == 0 || number % 111 == 0) {
                    if (region < 10) {
                        array.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        array.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                }

            }
        }
        return array;
    }

    private static TreeSet<String> treeSetCreator() {
        char[] symbols = {'A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'};
        final int NUMBER_COUNT = 1000, DIGIT_COUNT = 10;
        TreeSet<String> treeSet = new TreeSet<>();
        int region;
        for (char letter : symbols) {
            for (int number = 1; number < NUMBER_COUNT; number++) {
                region = (int) (Math.random() * 198 + 1);
                if (number < 10) {
                    if (region < 10) {
                        treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                } else if (number > 10 && number < 100) {
                    if (number % 11 == 0) {
                        if (region < 10) {
                            treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                        } else {
                            treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                        }
                    }
                } else if (number % 100 == 0 || number % 111 == 0) {
                    if (region < 10) {
                        treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        treeSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                }

            }
        }
        return treeSet;
    }

    private static HashSet<String> hashSetCreator() {
        char[] symbols = {'A', 'B', 'E', 'K', 'M', 'H', 'O', 'P', 'C', 'T', 'Y', 'X'};
        final int NUMBER_COUNT = 1000, DIGIT_COUNT = 10;
        HashSet<String> hashSet = new HashSet<>();
        int region;
        for (char letter : symbols) {
            for (int number = 1; number < NUMBER_COUNT; number++) {
                region = (int) (Math.random() * 198 + 1);
                if (number < 10) {
                    if (region < 10) {
                        hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                } else if (number > 10 && number < 100) {
                    if (number % 11 == 0) {
                        if (region < 10) {
                            hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                        } else {
                            hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                        }
                    }
                } else if (number % 100 == 0 || number % 111 == 0) {
                    if (region < 10) {
                        hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$02d", letter, number, region));
                    } else {
                        hashSet.add(String.format("%1$s%2$03d%1$s%1$s%3$d", letter, number, region));
                    }
                }

            }
        }
        return hashSet;
    }


}
