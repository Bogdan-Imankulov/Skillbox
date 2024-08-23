package com.company;

import java.text.DecimalFormat;

public class Main {

    public static void main(String[] args) {
        // write your code here
        final int COUNT_OF_PATIENT = 30;
        final float MIN_HEALTHY_TEMPERATURE = 36.2f;
        final float MAX_HEALTHY_TEMPERATURE = 36.9f;
        final float MIN_TEMPERATURE_OF_PATIENT = 32f;
        final float MAX_TEMPERATURE_OF_PATIENT = 40f;
        float[] temperatureOfPatient = new float[COUNT_OF_PATIENT];
        String temperaturePatient = "";
        //в примере вывода указываются один, затем два знака после запятой, поэтому использую DecimalFormat
        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        DecimalFormat decimalFormat1 = new DecimalFormat("#.##");
        float average = 0; //средняя температура
        int countHealthyTemperature = 0;// количество здоровых

        for (int i = 0; i < temperatureOfPatient.length; i++) {
            temperatureOfPatient[i] = (float) (32 + 8 * Math.random());// создаем температуру от 32 до 40 градусов
            // проверяем температура в пределах нормы
            if (temperatureOfPatient[i] < MAX_HEALTHY_TEMPERATURE && temperatureOfPatient[i] > MIN_HEALTHY_TEMPERATURE)
                countHealthyTemperature++; // добавляем количесто здоровых
            average = average + temperatureOfPatient[i]; //считаем общую температуру
            // форматируем, чтобы было 1 знак при выводе числа
            String formOfTemperature = decimalFormat.format(temperatureOfPatient[i]);
            // все заносим в одну строку
            temperaturePatient = temperaturePatient + formOfTemperature + " ";

        }
        // получаем среднее значение температуры
        average = average / temperatureOfPatient.length;
        // форматируе чтобы при выводе числа было 2 знака после запятой
        String averageToString = decimalFormat1.format(average);
        System.out.println("Температуры больных: " + temperaturePatient);
        System.out.println("Средняя температура: " + averageToString);
        System.out.println("Количество здоровых: " + countHealthyTemperature);


    }
}
