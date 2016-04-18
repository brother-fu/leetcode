public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
    /* find the first pos >= target, maybe the end*/   
        int l = 0, r = nums.length - 1;
        while (l + 1< r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target)
                r = mid;
            else
               l = mid;
        }
        if (nums[l] >= target) return l;
        return nums[r] >= target ? r : nums.length;
        
        
    }
}