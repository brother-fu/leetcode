//确定循环随着范围缩小，依然有效力的方法

/*怎么判断循环条件是不是正确，范围取小之后，继续循环条件，会不会出错！*/
/*这里边界变小之后是不是依然满足条件！*/
/*经验证，与0 / start / end比都能获得正确的答案*/




public class Solution {
    /*comparing with nums[0]*/
    public int findMin1(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len - 1])   //pivot is the first num, remain order;
            return nums[0];
        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[0]) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }
    
    
    /*comparing with the nums[start]*/
    public int findMin2(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len - 1])   //pivot is the first num, remain order;
            return nums[0];
        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[start])
                start = mid;
            if (nums[mid] < nums[start])
                end = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
    
    /*comparing with the end*/
    public int findMin(int[] nums) {
        int len = nums.length;
        if (nums[0] <= nums[len - 1])   //pivot is the first num, remain order;
            return nums[0];
        int start = 0, end = len - 1;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[end])
                start = mid;
            if (nums[mid] < nums[end])
                end = mid;
        }
        return Math.min(nums[start], nums[end]);
    }
}

