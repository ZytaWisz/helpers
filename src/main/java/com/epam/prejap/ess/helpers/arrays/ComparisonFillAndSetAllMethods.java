package com.epam.prejap.ess.helpers.arrays;

import java.util.Arrays;

/**
 * The type Comparison fill and set all methods.
 * <p>
 * This methods comes from{@link Arrays} class.
 * </p>
 *
 * @author Zyta Wiszniewska
 * @version 0.3
 * @see Arrays
 */
public class ComparisonFillAndSetAllMethods {

    /**
     * In the examples below shown differences between fill and setAll methods.
     *
     * @param args the input arguments
     */
    public static <T> void main(String[] args) {


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


        int[] array2 = new int[]{1, 2, 5, 10, 11, 12, 5, 4, 7, 8, 9, 10};
        System.out.println("Original array2: " + Arrays.toString(array2));
        Arrays.setAll(array2, index -> (index + 1) * 10);
        System.out.println("Example 5 with setAll methods: " + Arrays.toString(array2));

        Arrays.setAll(stringArray, value -> stringArray[value].toUpperCase());
        System.out.println(Arrays.toString(stringArray));

    }
}
