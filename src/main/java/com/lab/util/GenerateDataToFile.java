package com.lab.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public final class GenerateDataToFile {

    public static void generateNumbers() {
        double[] array = new double[1000];
        final Random random = new Random();
        for (int i = 0; i < array.length; i+=2) {
            array[i] = (random.nextDouble()) * 10000;
            array[i+1] = (random.nextDouble());
        }

        try (final FileWriter writer = new FileWriter("numbers.txt", false)) {
            for (int i = 0; i < array.length; ++i) {
                final String s = Double.toString(array[i]);
                writer.write(s);
                writer.write(" ");
                System.out.println(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
