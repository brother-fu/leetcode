public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        //nums[i] = i + 1;
        //在i的位置放 i＋1的数字，一次通过！
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for (int i = 0; i < len; i++)
            if (nums[i] != i + 1)
                return i + 1;
        return len + 1;
    }
}

/*50 - 58*/