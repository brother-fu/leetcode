public class SearchinRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l + 1 < r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) return true;
            if (nums[m] > nums[l]) {  //递增区间
                if (target >= nums[l] && target < nums[m])
                    r = m;
                else 
                    l = m;
            } else if (nums[m] < nums[l]) {
                if (target > nums[m] && target <= nums[r])
                    l = m;
                else 
                    r = m;
            } else {
                l++;
            }
        }
        return nums[l] == target || nums[r] == target;
    }
}







/*构建可以二分的子区间, 确保某个区间是增区间（宽松型，可以相等），可以用于二分查找*/
/*通过mid与left 的关系，来划分递增区间的思路值得学习！*/