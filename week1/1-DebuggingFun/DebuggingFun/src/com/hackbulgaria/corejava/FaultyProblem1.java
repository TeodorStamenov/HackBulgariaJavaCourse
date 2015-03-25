package com.hackbulgaria.corejava;

import java.io.ObjectInputStream.GetField;

public class FaultyProblem1 {
    public long getLargestPalindrome(long N) {
        N--;
        if (Utils.isPalindrome(N)) {
            return N;
        } else {
            return getLargestPalindrome(N);
        }
    }
}
