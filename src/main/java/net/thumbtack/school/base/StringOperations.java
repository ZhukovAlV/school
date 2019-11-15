package net.thumbtack.school.base;

import java.util.HashSet;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int sum = 0;
        for (String string : strings)
            sum += string.length();
        return sum;
    }

    public static String getFirstAndLastLetterString(String string) {
        return concat(String.valueOf(string.charAt(0)),String.valueOf(string.charAt(string.length() - 1)));
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return isEqual(String.valueOf(string1.charAt(index)), String.valueOf(string2.charAt(index)));
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character)==string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character)==string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return  string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) & string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) & string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        String result = "";
        for (int i = 0; i < Integer.min(string1.length(), string2.length()); i++) {
            if (string1.charAt(i) != string2.charAt(i)) break;
           // result = result + string1.charAt(i);
            // result = new StringBuilder(result).append(string1.charAt(i)).toString();
            result = result.concat(String.valueOf(string1.charAt(i)));
        }
        return result;
    }

    public static String reverse(String string) {
        return  new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String resultString = "";
        for (String s : strings)
            resultString=(isPalindromeIgnoreCase(s) & resultString.length() < s.length()) ? s: resultString;
        return resultString;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (length + index > string1.length() || length + index > string2.length()) return false;
        return isEqual(string1.substring(index, length),string2.substring(index, length));
    }

    public static boolean isEqualAfterReplaceCharacters(String string1, char replaceInStr1, char replaceByInStr1, String string2, char replaceInStr2, char replaceByInStr2) {
        return isEqual(string1.replaceAll(String.valueOf(replaceInStr1), String.valueOf(replaceByInStr1)),string2.replaceAll(String.valueOf(replaceInStr2), String.valueOf(replaceByInStr2)));
    }

    public static boolean isEqualAfterReplaceStrings(String string1, String replaceInStr1, String replaceByInStr1, String string2, String replaceInStr2, String replaceByInStr2) {
        return isEqual(string1.replaceAll(replaceInStr1, replaceByInStr1),string2.replaceAll(replaceInStr2, replaceByInStr2));
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        return isPalindromeIgnoreCase(string.replaceAll(" ",""));
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return isEqual(string1.trim(),string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder mcsbfi = new StringBuilder("");
        for (int i=0; i < array.length; i++) {
            mcsbfi.append(array[i]);
            if (i < (array.length - 1)) mcsbfi.append(",");
        }
        return mcsbfi;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder mcsbfd = new StringBuilder();
        for (int i=0; i < array.length; i++) {
            mcsbfd.append(String.format("%.2f", array[i]));
            if (i < (array.length - 1)) mcsbfd.append(",");
        }
        return mcsbfd;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder rc = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            rc.deleteCharAt(positions[i] - i);
        }
        return rc;
    }

    public static StringBuilder insertCharacters(String string, int[] positions, char[] characters) {
        StringBuilder stringBuilder = new StringBuilder(string);
        for (int i = 0; i < positions.length; i++) {
            stringBuilder.insert(positions[i] + i, characters[i]);
        }
        return stringBuilder;
    }
}
