import org.junit.Test;
import static org.junit.Assert.*;

public class L2022211857_5_Test {

    @Test
    public void testNumSubseqCase1() {
        Solution5 solution = new Solution5();
        int[] nums = {3, 5, 6, 7};
        int target = 9;
        int expected = 4;  // 预期结果为 4 个满足条件的子序列
        assertEquals(expected, solution.numSubseq(nums, target));
    }

    @Test
    public void testNumSubseqCase2() {
        Solution5 solution = new Solution5();
        int[] nums = {3, 3, 6, 8};
        int target = 10;
        int expected = 6;  // 预期结果为 6 个满足条件的子序列
        assertEquals(expected, solution.numSubseq(nums, target));
    }

    @Test
    public void testNumSubseqCase3() {
        Solution5 solution = new Solution5();
        int[] nums = {2, 3, 3, 4, 6, 7};
        int target = 12;
        int expected = 61;  // 预期结果为 61 个满足条件的子序列
        assertEquals(expected, solution.numSubseq(nums, target));
    }

    @Test
    public void testNumSubseqEmptyArray() {
        Solution5 solution = new Solution5();
        int[] nums = {};
        int target = 10;
        int expected = 0;  // 空数组应返回 0
        assertEquals(expected, solution.numSubseq(nums, target));
    }


}
