public class NextPermutation {
    public int[] nextPermutation(int[] nums) {
        // write your code here
        int s = nums.length - 1, t = -1; //t初始化为－1；
        //int flag = 0;
        for(int i = nums.length - 1; i > t; i--) { //两个都是 > t
            for (int j = i - 1; j > t; j--) { //这里也是>t
                if (nums[i] > nums[j]) {
                    t = j;
                    s = i;
                    //flag ++;
                }
            }
        }
        //if (flag > 0) {
        if (t >= 0) { // flag 也可以省略
            swap(nums, s, t);
            Arrays.sort(nums, t + 1, nums.length);
        } else {
            Arrays.sort(nums);
        }
        return nums;
    }
    private void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}