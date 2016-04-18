/* 题目介绍
Given a string s, return all the palindromic permutations (without duplicates) of it. Return an empty list if no palindromic permutation could be form.

For example:

Given s = "aabb", return ["abba", "baab"].

Given s = "abc", return [].
*/

public class PalindromePermutationII {
    public List<String> generatePalindromes(String s) {
        List<String> ans = new ArrayList();
        int[] counter = new int[256];
        char single = ' '; int count = 0; //不能有empty character literal
        for (char c : s.toCharArray()) {
            counter[c]++;
        }
        for (int i = 0; i < 256; i++) {
            if (counter[i] % 2 != 0) {
                single = (char)i;
                count++;
            }
        }
        if (count > 1)  
            return ans;
        List<String> half = new ArrayList();
        StringBuilder sb = new StringBuilder();
        dfs(half, counter, sb, s);
        for (String ss : half) {
            String extra = single == ' ' ? "" : "" + single;
            ans.add(ss + extra + new StringBuilder(ss).reverse().toString());
         }
        return ans;
    }
    private void dfs(List<String> half, int[] counter, StringBuilder sb, String s) {
        if (sb.length() == s.length() / 2) {
            half.add(sb.toString());
            return;
        }
        for (int i = 0; i < 256; i++) {
            if (counter[i] >= 2) {
                counter[i] -= 2;
                char c = (char)i;
                sb.append(c);
                dfs(half, counter, sb, s);
                sb.setLength(sb.length() - 1);
                counter[c] += 2;
            }
        }
    }
}