package com.bichel.leetcode.arrays;

/*

There are n dominoes in a line,
and we place each domino vertically upright.
In the beginning, we simultaneously push some of
the dominoes either to the left or to the right.

After each second, each domino that is falling
to the left pushes the adjacent domino on the left.
Similarly, the dominoes falling to the right push
their adjacent dominoes standing on the right.
When a vertical domino has dominoes falling on it from both sides,
it stays still due to the balance of the forces.
For the purposes of this question, we will consider
that a falling domino expends no additional force
to a falling or already fallen domino.
You are given a string dominoes representing the initial state where:

dominoes[i] = 'L', if the ith domino has been pushed to the left,
dominoes[i] = 'R', if the ith domino has been pushed to the right, and
dominoes[i] = '.', if the ith domino has not been pushed.
Return a string representing the final state.

Example 1:
Input: dominoes = "RR.L"
Output: "RR.L"
Explanation: The first domino expends no additional force on the second domino.

Example 2:
Input: dominoes = ".L.R...LR..L.."
Output: "LL.RR.LLRRLL.."

 */

public class PushDominos {
    public String pushDominoes1(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N+2];
        char[] symbols = new char[N+2];
        int len = 1;
        indexes[0] = -1;
        symbols[0] = 'L';

        for (int i = 0; i < N; ++i)
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len++] = dominoes.charAt(i);
            }

        indexes[len] = N;
        symbols[len++] = 'R';

        char[] ans = dominoes.toCharArray();
        for (int index = 0; index < len - 1; ++index) {
            int i = indexes[index], j = indexes[index+1];
            char x = symbols[index], y = symbols[index+1];
            char write;
            if (x == y) {
                for (int k = i+1; k < j; ++k)
                    ans[k] = x;
            } else if (x > y) { // RL
                for (int k = i+1; k < j; ++k)
                    ans[k] = k-i == j-k ? '.' : k-i < j-k ? 'R' : 'L';
            }
        }

        return String.valueOf(ans);
    }

    public String pushDominoes2(String S) {
        char[] A = S.toCharArray();
        int N = A.length;
        int[] forces = new int[N];

        // Populate forces going from left to right
        int force = 0;
        for (int i = 0; i < N; ++i) {
            if (A[i] == 'R') force = N;
            else if (A[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        // Populate forces going from right to left
        force = 0;
        for (int i = N-1; i >= 0; --i) {
            if (A[i] == 'L') force = N;
            else if (A[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder ans = new StringBuilder();
        for (int f: forces)
            ans.append(f > 0 ? 'R' : f < 0 ? 'L' : '.');
        return ans.toString();
    }
}
