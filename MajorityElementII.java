public class MajorityElementII {
    /*先判断相等，再判断 count, 否则会出错！*/
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList();
        if (nums == null || nums.length == 0)
            return ans;
        int count1 = 0, count2 = 0;
        int cand1 = 0, cand2 = 0;
        for (int num : nums) {
            if (num == cand1) {
                count1++;
            } else if (num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1++;
            } else if (count2 == 0) {
                cand2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == cand1)
               count1++;
            else if (num == cand2)
               count2++;
        }
        if (count1 > nums.length / 3)
            ans.add(cand1);
        if (count2 > nums.length / 3)
            ans.add(cand2);
        return ans;
    }
}