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