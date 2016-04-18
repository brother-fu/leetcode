public class Solution {
    public void wiggleSort1(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i % 2 == 1 && nums[i] < nums[i - 1]) || (i % 2 == 0 && nums[i] > nums[i - 1]))
                swap(nums, i, i - 1);
        }
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }



    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len <= 2)
            return;
        //switch uppermid with last
        swap(nums, len / 2, len - 1);
        int i = 1, j = len / 2;
        while(i < j) {
            swap(nums, i, j);
            i += 2;
            j++;
        }
    }
}