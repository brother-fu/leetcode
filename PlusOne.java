public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return new int[] {1};
        }
        int[] ans = new int[digits.length];
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            ans[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if (carry == 1) {
            int s[] = new int[digits.length + 1];
            s[0] = 1;
            return s;
        } 
        return ans;
    }
}


//还能更简单： 唯一出现可能进位的情况，是第一位为1，其它全为0；