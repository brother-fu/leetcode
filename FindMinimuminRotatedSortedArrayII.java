public class FindMinimuminRotatedSortedArrayII {
    /*穷尽与nums[0], 与start比， 与end比之后的最优解*/
    public int findMin(int[] nums) {
        int len = nums.length;
        int start = 0, end = len - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] > nums[end]) start = mid;
            else if (nums[mid] < nums[end]) end = mid;
            else end--;
        }
        return Math.min(nums[start], nums[end]);
    }
}