public class MedianofTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1)
            return findKth(nums1, 0, nums2, 0, (len + 1) / 2);
        else
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
    }
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];      /* 坐标要注意！*/
        if (start2 >= nums2.length) return nums1[start1 + k - 1];
        if (k == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int Ak = start1 + k / 2 - 1 >= nums1.length 
                 ? Integer.MAX_VALUE
                 : nums1[start1 + k / 2 - 1];
        int Bk = start2 + k / 2 - 1>= nums2.length
                 ? Integer.MAX_VALUE
                 : nums2[start2 + k / 2 - 1];
        if (Ak > Bk)
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        else
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    }
}