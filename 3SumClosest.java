public class 3SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        int dist = Integer.MAX_VALUE;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, t = nums.length - 1;
            while(j < t) {
                int tmp = nums[i] + nums[j] + nums[t];
                if (tmp < target) {
                    if (target - tmp < dist) {
                        dist = target - tmp;
                        ans = tmp;
                    }
                    j++;
                } else if (tmp > target) {
                    if (tmp - target< dist) {
                        dist = tmp - target; //醉了，小心别写错了
                        ans = tmp;
                    }
                    t--;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }
}