package com.bichel.leetcode.bfs_dfs;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MakingAlargeIslandTest {

    @Test
    public void testTestCase1() {
        MakingALargeIslandUsingDFS pr = new MakingALargeIslandUsingDFS();

        int[][] grid = {{1,0},{0,1}};
        int expectedArea = 3;

        int actualArea = pr.largestIsland(grid);

        assertEquals(expectedArea, actualArea);
    }
}
