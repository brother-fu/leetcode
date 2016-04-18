public class JumpGameII   {
    public int jump(int[] nums) {
        int len = nums.length;
        if (len <= 1) return 0;
        int pre = 0, max = 0, step = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > pre) {
                pre = max;
                step++;
            }
            max = Math.max(i + nums[i], max);
            if (max >= len - 1)
                return ++step;
        }
        return step;
    }
}

/*20-28, 一次通过, 从后面比较正常的情况进行分析*/