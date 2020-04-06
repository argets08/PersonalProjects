package problems;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumSubArrayTest {

    @Test
    void testMaxSubArray() {
       MaxSumSubArray m = new MaxSumSubArray();
//        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

        assertEquals(6, m.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        assertEquals(21, m.maxSubArray(new int[]{8,-19,5,-4,20}));
        assertEquals(9, m.maxSubArray(new int[]{5,-1,-2,3,4,-1}));
        assertEquals(1, m.maxSubArray(new int[]{-1,-19,1,0}));
        assertEquals(1, m.maxSubArray(new int[]{-2,1}));
        assertEquals(4, m.maxSubArray(new int[]{2,0,-3,2,1,0,1,-2}));
    }
}