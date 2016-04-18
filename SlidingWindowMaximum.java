public class SlidingWindowMaximum  {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0)
            return new int[0];
        int len = nums.length;
        int[] ret = new int[len - k + 1];
        int i = 0, j = 0;
        Deque<Integer> dq = new ArrayDeque();
        for (i = 0; i < len; i++) {
            while (dq.size() != 0 && nums[dq.peekLast()] <= nums[i])
                dq.pollLast();
            if (dq.size() != 0 && i - dq.peekFirst() >= k)
                dq.pollFirst();
            dq.offer(i);
            if (i >= k - 1)
                ret[j++] = nums[dq.peekFirst()]; /*这里最后忘记了，存的是index*/
        }
        return ret;
    }
}