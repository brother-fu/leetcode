public class FindtheDuplicateNumber {
    public int findDuplicate1(int[] nums) {
        int slow = nums[0], fast = nums[slow];
        while (fast != slow) {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        int ret = nums[0];
        while (nums[slow] != ret) {
            ret = nums[ret];
            slow = nums[slow];
        }
        return ret;
    }
    
    /*genius, find the first element that numbers less or equal than it greater than itself*/
    public int findDuplicate(int[] nums) {
        int low = 1, high = nums.length - 1;
        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            for (int num : nums) 
                if (num <= mid)
                    cnt++;
            if (cnt > mid) high = mid;
            else low = mid;
        }
        int cnt = 0;
        for (int num : nums)
            if (num <= low)
                cnt++;
        if (cnt > low)
            return low;
        return high;
    }a
}




/*12 -17*/