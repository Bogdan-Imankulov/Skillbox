package com.company;

import javax.sound.midi.Soundbank;

public class Main {

    public static void main(String[] args) {
	// write your code here
        byte minByte = Byte.MIN_VALUE;
        byte maxByte = Byte.MAX_VALUE;
        System.out.println(minByte);
        System.out.println(maxByte);
        //А можно вот так
        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        short minShort = Short.MIN_VALUE;
        short maxShort = Short.MAX_VALUE;
        System.out.println(minShort);
        System.out.println(maxShort);
        //А можно вот так
        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        int minInt = Integer.MIN_VALUE;
        int maxInt = Integer.MAX_VALUE;
        System.out.println(minInt);
        System.out.println(maxInt);
        //А можно вот так
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        float minFloat = -Float.MAX_VALUE;
        float maxFloat = Float.MAX_VALUE;
        System.out.println(minFloat);
        System.out.println(maxFloat);
        //А можно вот так
        System.out.println(-Float.MAX_VALUE);
        System.out.println(Float.MAX_VALUE);

        double minDouble = -Double.MAX_VALUE;
        double maxDouble = Double.MAX_VALUE;
        System.out.println(minDouble);
        System.out.println(maxDouble);
        //А можно вот так
        System.out.println(-Double.MAX_VALUE);
        System.out.println(Double.MAX_VALUE);

        long minLong = Long.MIN_VALUE;
        long maxLong = Long.MAX_VALUE;
        System.out.println(minLong);
        System.out.println(maxLong);
        //А можно вот так
        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);
    }
}
