private int partition(int[] nums, int s, int f, int ref) {
        int l = s, r = f;
        while (l <= r) { 
            while (nums[l] != ref) {
                l++;
                if (l == f + 1)
                    break;
            }
            while (nums[r] == ref) {
                r--;
                if (r == s - 1)
                    break;
            }
            if (l <= r)
                swap(nums, l, r);
        }
        return r;
    }