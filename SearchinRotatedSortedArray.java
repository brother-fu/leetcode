public class SearchinRotatedSortedArray {
/*稍微记忆一下，正常情况不会有影响*/
/*与nums[0]相比判断左右branch*/
    public int search1(int[] nums, int target) {
        int len = nums.length;
        int l = 0, r = len - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2; 
            if (nums[m] == target)
                return m;
            if (nums[m] >= nums[0]) { // left
                if (nums[m] < target) {
                    l = m;
                } else {
                    if (target >= nums[0]) {
                        r = m;
                    } else {
                        l = m;
                    }
                } 
            } else { // r
                if (nums[m] > target) {
                    r = m;
                } else {
                    if (target >= nums[0]) {
                        r = m;
                    } else {
                        l = m;
                    }
                }
            }
        }
        return nums[l] == target ? l : nums[r] == target ? r : -1;
    }





    /*与l相比, 判断该区间是否递增*/
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return m;
            if (nums[m] >= nums[l]) {  //递增区间
                if (target >= nums[l] && target < nums[m])
                    r = m;
                else 
                    l = m;
            } else {
                if (target > nums[m] && target <= nums[r])
                    l = m;
                else 
                    r = m;
            }
        }
        if (nums[l] == target) return l;
        return nums[r] == target ? r : -1;
    }1
}