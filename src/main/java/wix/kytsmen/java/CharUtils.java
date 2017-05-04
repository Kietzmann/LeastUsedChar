package wix.kytsmen.java;

import static java.lang.Character.MAX_VALUE;
import static java.lang.Character.MIN_VALUE;

public class CharUtils {

    // complexity O(n * Character.MAX_VALUE) -> O(n)
    // memory O(1)

    // in two loops go through every char and count it occurrences in string. If at the end of inner loop counter is
    // more than zero and less than outer cnt -> assign answer to char
    // we can speed up it if we now that there will be only letters but in task was specified 'symbols'
    public static char leastUsedChar(String string) {
        if (string == null) {
            throw new IllegalArgumentException("String is null");
        }
        if (string.isEmpty()) {
            throw new IllegalArgumentException("String is empty");
        }
        char ans = 0;
        int cnt = Integer.MAX_VALUE;
        for (char ch = MIN_VALUE; ch <= MAX_VALUE; ++ch) {
            int currCnt = 0;
            for (int i = 0; i < string.length(); ++i) {
                if (string.charAt(i) == ch) {
                    ++currCnt;
                }
            }

            if (currCnt < cnt && currCnt > 0) { //if the last occurring should be returned, than currCnt <= cnt
                ans = ch;
                cnt = currCnt;
            }
        }
        return ans;
    }

    // fastest one using at least memory
    // explanation: in Java Strings are immutable, so we cannot perform bubble sort of the string to
    // group chars by their lexicographic value : for example from bcbza -> abbcz
    // But we can use char array and then sort it and find the least sequence of occuring number
    // Although sorting is not good enough to us, cause it will lead to increasing of complexity

    // The best solution considering - to create int array and at when looping through string increase value in array at the index if char value
    // to prevent allocation of array up to Character.MAX_VALUE, we can go through array at another loop, find lowest and highest char value
    // casted to int, find diff and then create new array with length [high - low] and then every digit occurring should be stored as
    // ++occurrences[string.charAt(i) - low]
//    public static char leastUsedCharWithLeastComplexity(String string) {
//        if (string == null) {
//            throw new IllegalArgumentException("String is null");
//        }
//        if (string.isEmpty()) {
//            throw new IllegalArgumentException("String is empty");
//        }
//        char ans = 0;
//        int cnt = Integer.MAX_VALUE;
//        int[] occurrences = new int[MAX_VALUE + 1];
//        for (int i = 0; i < string.length(); ++i) {
//            ++occurrences[string.charAt(i)];
//        }
//        for (int i = 0; i < occurrences.length; ++i) {
//            if (occurrences[i] < cnt && occurrences[i] > 0) {
//                ans = (char) i;
//                cnt = occurrences[i];
//            }
//        }
//
//        return ans;
//    }

}
