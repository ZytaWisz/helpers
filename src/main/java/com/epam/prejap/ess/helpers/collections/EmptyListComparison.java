package com.epam.prejap.ess.helpers.collections;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * Comparison of Collections.emptyList with Collections.EMPTY_LIST.
 * <p>
 * Both comes from the {@link Collections} class, which was introduced in Java 1.2
 * <p>
 *
 * @author Michal Majewski
 * @version 0.2
 * @see Collections
 */
class EmptyListComparison {

    public static final String MESSAGE_FOR_A_MUTABLE_LIST = "List from the %s is mutable\n";
    public static final String MESSAGE_FOR_IMMUTABLE_LIST = "List from the %s is immutable\n";

    /**
     * Introduced in Java 1.2 <br>
     * <br>
     * The private static final field in the Collections class.
     * The constant is initialized only once and reference to the raw type List.
     * It is initialized by "new EmptyList", which is an inner class in the Collections class.<br>
     * <br>
     * The return list is always:
     * <ul>
     *      <li>raw type</li>
     *      <li>an empty list</li>
     *      <li>an immutable collection</li>
     *      <li>serializable</li>
     * </ul>
     * Assigning a raw type to a generic one is not type safe, and will generate a warning,
     * so it's not recommended to use since the emptyList() was introduced in Java 1.5
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Collections.html#EMPTY_LIST">Java SE 16 & JDK 16 - EMPTY_LIST</a>
     */
    private final List EMPTY_LIST = Collections.EMPTY_LIST;

    /**
     * Introduced in Java 1.5 <br>
     * <br>
     * Along with introduced generics, the emptyList() was added to the Collections class.
     * The method returns a generic list. Under the hood uses type-inference,
     * and returns the EMPTY_LIST which is explicitly cast into List {@literal <T>} type. <br>
     * <br>
     * The return list is always:
     * <ul>
     *      <li>generic type</li>
     *      <li>an empty list</li>
     *      <li>an immutable collection</li>
     *      <li>serializable</li>
     * </ul>
     * Implementations of this method need not create a separate List object for each call.
     * Every call of this method return a cast reference from the EMPTY_LIST field.
     * Using this method is likely to have comparable cost to using the like-named field.
     * (Unlike this method, the field does not provide type safety.)
     * <br>
     * Since then it is recommended way to obtain an empty list.
     *
     * @see <a href="https://docs.oracle.com/en/java/javase/16/docs/api/java.base/java/util/Collections.html#emptyList()">Java SE 16 & JDK 16 - emptyList()</a>
     */
    private <T> List<T> emptyList() {
        return Collections.emptyList();
    }

    /**
     * Print information about both ways of obtaining an empty list from the Collections class.
     * Inside is also included some examples of usage for each manner with a brief comment
     */
    public static void main(String[] args) {

        /*
         * All conditions below (equality, empty content, serializable) are always true
         */
        System.out.println(checkIfBothListsAreEquals()
                ? "Both lists are equals"
                : "Both lists are not equals");

        System.out.println(checkIfBothListsAreEmpty()
                ? "Both lists are empty. Their size is equal to 0."
                : "Both lists are not empty. Their size is not equal to 0.");

        System.out.println(checkIfBothListsAreSerializable()
                ? "Both lists are serializable"
                : "Both lists are not serializable");

        /*
        * Both ways of obtaining the empty list return an immutable list.
        * Every attempt of adding a value (into each list) ends in throwing a UnsupportedOperationException
        * (Here we get specified printing on the console)
        */
        checkIfListIsImmutable(Collections.EMPTY_LIST, "Collections.EMPTY_LIST");
        checkIfListIsImmutable(Collections.emptyList(), "Collections.emptyList()");

        /*
        * An empty list, obtained from Collections.EMPTY_LIST due to missing explicit casting is an instance of Raw List.
        * The below condition is always true
        */
        System.out.println(checkIfProvidedEmptyListIsAnInstanceOfRawList(Collections.EMPTY_LIST)
                ? "The Collections.EMPTY_LIST is an instance of List"
                : "The Collections.EMPTY_LIST is NOT an instance of List");

        /*
         * The code below will cause a compilation error with the specified message:
         * "'List' cannot be safely cast to 'List<Object>'"
         */
        //System.out.println(Collections.EMPTY_LIST instanceof List<Object>);

        /*
         * The code below is correct, and it will not cause any errors. Both conditions with "instanceof" are always true.
         */
        System.out.println(checkIfProvidedEmptyListIsAnInstanceOfRawList(Collections.emptyList())
                ? "The Collections.emptyList() is an instance of List"
                : "The Collections.emptyList() is not an instance of List");
        System.out.println(checkIfEmptyListFromCollectionsStaticMethodIsAnInstanceOfObjectsList()
                ? "The Collections.emptyList() is an instance of List<Object>"
                : "The Collections.emptyList() is not an instance of List<Object>");

        /*
         * The return type is a raw List
         */
        var listFromField = Collections.EMPTY_LIST;

        /*
         * Because the parameter type is not bounded, the default assigned type is Object, so we obtain a List<Object>
         */
        var listFromEmptyListMethod = Collections.emptyList();

        /*
         * For both examples below, we obtain a warring "Raw use of parameterized class 'List'"
         */
        List rawListFromField = Collections.EMPTY_LIST;
        List rawListFromEmptyListMethod = Collections.emptyList();

        /*
         * For each examples below, we obtain a warning "Unchecked assignment:
         * 'java.util.List' to 'java.util.List<the fully-qualified name of the current type>' class 'List'"
         */
        List<String> listFromFieldWithStringType = Collections.EMPTY_LIST;
        List<Integer> listFromFieldWithIntegerType = Collections.EMPTY_LIST;
        List<Object> listFromFieldWithObjectType = Collections.EMPTY_LIST;

        /*
         * Recommended way of usage since Java 1.5. With target typing, we point out what type we expecting.
         * In this manner, we do not get any warnings.
         */
        List<Integer> listFromEmptyListMethodWithIntegerType = Collections.emptyList();
    }


    /**
     * Checks if the Collections.emptyList() is instance of List{@literal <Object>},
     * and then return a boolean value (true/ false)
     */
    private static boolean checkIfEmptyListFromCollectionsStaticMethodIsAnInstanceOfObjectsList() {
        return Collections.emptyList() instanceof List<Object>;
    }

    /**
     * Checks, if provided empty list, is an instance of raw List, and then return a boolean value
     */
    private static boolean checkIfProvidedEmptyListIsAnInstanceOfRawList(final List emptyList) {
        return emptyList instanceof List;
    }

    /**
     * Checks if provided list is immutable by an attempt of adding a new object, and then prints a proper message
     */
    private static void checkIfListIsImmutable(final List emptyList, String listSourceName) {
        try {
            emptyList.add(new Object());
            System.out.printf(MESSAGE_FOR_A_MUTABLE_LIST, listSourceName);
        } catch (UnsupportedOperationException e) {
            System.err.printf(MESSAGE_FOR_IMMUTABLE_LIST, listSourceName);
        }
    }

    /**
     * Checks if the Collections.EMPTY_LIST and the Collections.emptyList() are instance of Serializable (if they implement it),
     * and then returns a boolean value (true/ false)
     */
    private static boolean checkIfBothListsAreSerializable() {
        return Collections.EMPTY_LIST instanceof Serializable && Collections.emptyList() instanceof Serializable;
    }

    /**
     * Checks if the Collections.EMPTY_LIST and the Collections.emptyList() have size equal 0,
     * and then returns a boolean value (true/ false)
     */
    private static boolean checkIfBothListsAreEmpty() {
        return Collections.EMPTY_LIST.size() == 0 && Collections.emptyList().size() == 0;
    }

    /**
    * Return boolean value (true/ false) from the comparison the Collections.EMPTY_LIST with the Collections.emptyList()
    */
    private static boolean checkIfBothListsAreEquals() {
        return Collections.EMPTY_LIST.equals(Collections.emptyList());
    }
}
