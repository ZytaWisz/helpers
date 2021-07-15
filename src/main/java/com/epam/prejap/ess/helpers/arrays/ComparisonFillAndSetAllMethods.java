package com.epam.prejap.ess.helpers.arrays;

import java.util.Arrays;

/**
 * Examples below shown differences between fill and setAll methods.
 * <p>
 * This methods comes from{@link Arrays} class.
 * </p>
 * @author Zyta Wiszniewska
 * @version 0.3
 */
public class ComparisonFillAndSetAllMethods {


    public static void main(String[] args) {

        /**
         * The fill method in an array allows to fill array in whole or fill from the start index to end index.
         * The values must be the same type as the array.
         * Examples below shown this two options to using fill methods.
         */


        int[] array = new int[]{1, 2, 2, 3, 4, 5, 6, 7, 8, 9, 9, 1, 0};
        System.out.println("Original array: " + Arrays.toString(array));
        Arrays.fill(array, 12);
        System.out.println("Example 1 with fill method: " + Arrays.toString(array));


        Arrays.fill(array, 3, 8, 33);
        System.out.println("Example 2 with fill method: " + Arrays.toString(array));

        char[] charArray = new char[]{'e', 'p', 'a', 'm'};
        System.out.println("Original char array: " + Arrays.toString(charArray));
        Arrays.fill(charArray, 1, 3, 'e');
        System.out.println("Example 3 with fill method: " + Arrays.toString(charArray));


        String[] stringArray = new String[]{"Kasia", "Monika", "Zuza", "Daniel", "Łukasz"};
        System.out.println("Original String array: " + Arrays.toString(stringArray));
        Arrays.fill(stringArray, 2, 4, "Miś");
        System.out.println("Example 4 with fill method: " + Arrays.toString(stringArray));

        /**
         * The method setAll in array allows to fill array using the provided generator function to compute each
         * element.
         * The values must be the same type as the array.
         * Examples below shown this how to using selAll method.
         */

        int[] array2 = new int[]{1, 2, 5, 10, 11, 12, 5, 4, 7, 8, 9, 10};
        System.out.println("Original array2: " + Arrays.toString(array2));
        Arrays.setAll(array2, index -> (index + 1) * 10);
        System.out.println("Example 5 with setAll methods: " + Arrays.toString(array2));

        double array3[] = new double[10];
        Arrays.setAll(array3, (index) -> index * index);
        System.out.println("Example 6 with setAll methods: " + Arrays.toString(array3));

        Arrays.setAll(stringArray, value -> stringArray[value].toUpperCase());
        System.out.println("Example 7 with setAll methods: " + Arrays.toString(stringArray));

    }
}
