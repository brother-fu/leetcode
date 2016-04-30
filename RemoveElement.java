public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val)
               j++;
            else 
               nums[i++] = nums[j++];
        }
        return i;
    }

    public int removeElement2(int[] nums, int val) {
        int len = nums.length;
        int i = 0, j = len - 1;
    while (i <= j) { /*这里必须有等于，不然只有一个元素的时候错*/
            while (nums[i] != val) {
                i++;
                if (i == len)
                    break;
            }
            while (nums[j] == val) {
                j--;
                if (j == -1)
                   break;
            }
            if (i < j)
                swap(nums, i, j);
        }
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}