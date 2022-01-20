package com.bichel.leetcode.bit;

/*
The complement of an integer is the integer you get when you flip all the 0's to 1's and all the 1's to 0's in its binary representation.
For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
Given an integer n, return its complement.

Example 1:
Input: n = 5
Output: 2
Explanation: 5 is "101" in binary, with complement "010" in binary, which is 2 in base-10.
 */

public class ComplementOfBase10Integer {
    public int bitwiseComplement(int N) {
        // l is a length of N in binary representation
        int l = (int) (Math.log(N) / Math.log(2)) + 1;
        // bitmask has the same length as num and contains only ones 1...1
        int bitmask = (1 << l) - 1;
        // flip all bits
        return bitmask ^ N;
    }
}
