package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        final int PATIENT_COUNT = 30;
        final float MIN_PATIENT_TEMPERATURE = 32.0f;
        final float MAX_PATIENT_TEMPERATURE = 40.0f;
        final float MIN_HEALTHY_PATIENT_TEMPERATURE = 32.6f;
        final float MAX_HEALTHY_PATIENT_TEMPERATURE = 36.9f;
        int healthyPatientCount = 0;
        float[] temperature = new float[PATIENT_COUNT];
        float averageTemperature = 0;
        float f;
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = (float) (32 + 8 * Math.random());
            System.out.println(temperature[i]);
            averageTemperature = averageTemperature + temperature[i];
            if (temperature[i] > MIN_HEALTHY_PATIENT_TEMPERATURE && temperature[i] < MAX_HEALTHY_PATIENT_TEMPERATURE) {
                healthyPatientCount++;
            }
        }
        for (int i = 0; i < temperature.length; i++) {
            for (int j = i+1; j < temperature.length; j++) {
                if (temperature[j] < temperature[i]){
                    f = temperature[i];
                    temperature[i] = temperature[j];
                    temperature[j] = f;
                }
            }
        }
        System.out.println("Lowest temperature is: " + temperature[0]);
        System.out.println("Highest temperature is: " + temperature[temperature.length-1]);
        averageTemperature = averageTemperature / temperature.length;
        System.out.println("Average Temperature is: " + averageTemperature);
        System.out.println("Healthy patient count is: " + healthyPatientCount);

    }
}
