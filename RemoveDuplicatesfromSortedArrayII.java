public class RemoveDuplicatesfromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums == null) return 0;
        if (nums.length <= 2) return nums.length;
        int count = 0;
        int i = 0, j = 0;
        while(j < nums.length) {
            if (nums[j] == nums[i]) {
                if (j - i < 2) {
                    nums[count++] = nums[j];
                }
                j++;
            } else {
                i = j;
            }
        }
        return count;
    }
}