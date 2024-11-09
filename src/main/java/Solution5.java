import java.util.Arrays;

class Solution5 {
    static final int P = 1000000007;
    static final int MAX_N = 100005;

    int[] f = new int[MAX_N];

    public int numSubseq(int[] nums, int target) {
        // 预处理，计算 f 数组中的 2^i % P
        pretreatment();

        // 对数组进行排序，方便二分查找
        Arrays.sort(nums);

        int ans = 0;
        for (int i = 0; i < nums.length; ++i) {
            // 如果当前最小元素 nums[i] 的两倍已经超过 target，则后续元素不用再计算
            if (nums[i] * 2 > target) {
                break;
            }
            // 计算可以与 nums[i] 组合的最大元素
            int maxValue = target - nums[i];
            // 通过二分查找找到满足条件的最大元素的位置
            int pos = binarySearch(nums, maxValue) - 1;
            // 计算可以组合的子序列数
            int contribute = (pos >= i) ? f[pos - i] : 0;
            ans = (ans + contribute) % P;
        }

        return ans;
    }

    // 预处理 2^i % P 的值，存储在 f 数组中
    public void pretreatment() {
        f[0] = 1; // 2^0 = 1
        for (int i = 1; i < MAX_N; ++i) {
            f[i] = (f[i - 1] * 2) % P;
        }
    }

    // 二分查找，找到 nums 中 <= target 的最大元素的索引
    public int binarySearch(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
