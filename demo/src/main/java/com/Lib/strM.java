package com.Lib;

import java.util.Formatter;

public class strM {

    public static char charAt(String a) {
        char result = 'a';
        // Returns the character at the specified index position.
        for (int i = 0; i < a.length(); i++) {
            result = (a.charAt(i));
        }
        return result;

    }

    public static String replace(String str, char searchChar, char newChar) {
        // The replace() method searches a string for a specified character, and returns
        // a new string where the specified character(s) are replaced.
        return (str.replace(searchChar, newChar));

    }

    public static int indexOf(String str, char character) {
        // The indexOf() method returns the position of the first occurrence of
        // specified character(s) in a string.
        return (str.indexOf(character));
    }

    public static boolean startsWith(String str, String searchString) {

        return (str.startsWith(searchString));
    }

    public static boolean endsWith(String str, String searchString) {
        return (str.endsWith(searchString));
    }

    public static void split(String str, String searchString, int numberOfArrays) {
        // The string split() method breaks a given string around matches of the given
        // regular expression
        String[] arrStr = (str.split(searchString, numberOfArrays));

        for (String a : arrStr)
            System.out.print(a + "\n");
        // System.out.println();
    }

    public static int compareTo(String str, String anotherString) {
        // System.out.println(str.compareTo(anotherString));
        // Returns: An int value: 0 if the string is equal to the other string.
        // < 0 if the string is lexicographically less than the other string
        // > 0 if the string is lexicographically greater than the other string (more
        // characters)
        return (str.compareTo(anotherString));
    }

    public static int compareToIngnoreCase(String str, String anotherString) {
        // Compare two strings, ignoring lower case and upper case differences:
        return (str.compareToIgnoreCase(anotherString));
    }

    public static boolean contains(String str, String searchString) {
        // The contains() method checks whether a string contains a sequence of
        // characters.
        // Returns true if the characters exist and false if not.
        return (str.contains(searchString));
    }

    public static boolean contentEquals(String str, String compareString) {
        // The contentEquals() method searches a string to find out if it contains the
        // exact same sequence of characters in the specified string or StringBuffer.
        return (str.contentEquals(compareString));
    }

    public static String concat(String str, String addString) {
        return (str.concat(addString));
    }

    public static String copyValueOf(char[] myChar, String removeSpaces, int offset, int count) {
        return (removeSpaces.copyValueOf(myChar, offset, count));
    }

    public static boolean isEmpty(String str) {
        return (str.isEmpty());

    }

    public static String trim(String str) {
        // trim() The trim() method removes whitespace from both ends of a string and
        // returns a new string, without modifying the original string. Whitespace in
        // this context is all the whitespace characters (space, tab, no-break space,
        // etc.)
        return (str.trim());
    }

    public static boolean equals(String str, String anotherObject) {
        // The Java String class equals() method compares the two given strings based on
        // the content of the string. If any character is not matched, it returns false.
        // If all characters are matched, it returns true. The String equals() method
        // overrides the equals() method of the Object class.
        return (str.equals(anotherObject));
    }

    public static boolean equalsIgnoreCase(String str, String anotherObject) {
        return (str.equalsIgnoreCase(anotherObject));
    }

    public static String substring(String str, int offset, int count) {
        // A part of String is called substring. In other words, substring is a subset
        // of another String. Java String class provides the built-in substring() method
        // that extract a substring from the given string by using the index values
        // passed as an argument.
        // In case of substring() method startIndex is inclusive and endIndex is
        // exclusive.
        return (str.substring(offset, count));
    }

    public static int indexOf(String str, int indice) {
        // The indexOf() method is used in Java to retrieve the index position at which
        // a particular character or substring appears in another string. You can use a
        // second argument to start your search after a particular index number in the
        // string. If the specified letter or letters cannot be found, indexOf() returns
        // -1
        return (str.indexOf(str, indice));
    }

    public static int lastIndexOf(String str, String searchString) {
        return (str.lastIndexOf(searchString));
    }

    public static int lastIndexOf(String str, int searchIndex) {
        return (str.lastIndexOf(searchIndex));
    }

    public static String replace(String str, String searchString, String newString) {
        return (str.replace(searchString, newString));
    }

    public static String replaceAll(String str, String searchString, String newString) {
        return (str.replaceAll(searchString, newString));
        // "[^abc]" [0 - 9]
        // System.out.println(s.replaceAll("[au]", "o"));
        // System.out.println(s.replaceAll("perro|gato", "animal"));
        // System.out.println(s.replaceAll("e.a", "illa"));
        // System.out.println(s.replaceAll("^Hola", "Te saludo"));
        // System.out.println(s.replaceAll("Hola$", "Te saludo"));
        // System.out.println(s.replaceAll("\\d", "*"));
        // System.out.println(s.replaceAll("\\s", ""));
        // System.out.println(s.replaceAll("\\s+", " "));

    }

    public static String valueOf(String str, int convert) {
        // The java string valueOf() method converts different types of values into
        // string. By the help of string valueOf() method, you can convert int to
        // string, long to string, boolean to string, character to string, float to
        // string, double to string, object to string and char array to string.

        return (str = String.valueOf(convert));

    }

    public static String stringFormat(Object args) {
        // The java string format() method returns the formatted string by given locale,
        // format and arguments.
        return new Formatter().format("%s", args).toString();
    }

}