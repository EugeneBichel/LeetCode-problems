package com.bichel.leetcode.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KLargest {
    public int solutionUsingHeap(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap =
                new PriorityQueue<>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

    public int simpleSolution(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
