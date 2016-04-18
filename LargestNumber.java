public class LargestNumber {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        String[] snums = new String[len];
        for (int i = 0; i < len; i++) 
            snums[i] = String.valueOf(nums[i]);
        Arrays.sort(snums, (a, b) -> {
            return (b + a).compareTo(a + b);
        });
        StringBuilder sb = new StringBuilder();
        for (String s : snums)
            sb.append(s);
        String ans = sb.toString();
        int j = 0;
        /*数字要合理的数字*/
        while (j < ans.length() - 1 && ans.charAt(j) == '0' && ans.charAt(j + 1) == '0')
            j++;
        return ans.substring(j);
    }
}
