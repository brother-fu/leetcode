public class ContainsDuplicateIII {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k == 0) return false;
        TreeSet<Long> set = new TreeSet();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) 
                set.remove((long)nums[i - k - 1]); //这里的坐标关系搞清楚
            Long ceil = set.ceiling((long)nums[i] - t);
            Long floor = set.floor((long)nums[i] + t);
            if ((ceil != null && ceil <= (long)nums[i] + t) || (floor != null && floor >= (long)nums[i] - t)) {
                return true;
            }
            set.add((long)nums[i]);
        }
        return false;
    }
}

/*全部要用long*/
/*不仅仅是由ceil / floor就行了*/
/*k <= 0*/ 直接返回false;