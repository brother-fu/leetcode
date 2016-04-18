public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int len = nums.length;
        int j = sort(nums, 0, len - 1, 2);
        sort(nums, 0, j, 1);
    }
    private int sort(int[] nums, int s, int f, int ref) {
        int i = s - 1, j = f + 1;
        while (i < j) {
            while(nums[++i] < ref) 
                if (i == f) 
                    break;
            while(nums[--j] == ref)
                if (j == s)
                    break;
            if (i < j)
                swap(nums, i, j);
        }
        return j;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}