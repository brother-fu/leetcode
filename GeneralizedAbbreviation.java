/*
Write a function to generate the generalized abbreviations of a word.

Example:
Given word = "word", return the following list (order does not matter):
["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
*/


public class GeneralizedAbbreviation {
    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList();
        dfs(ans, new StringBuilder(), word, 0, 0);
        return ans;
    }
    private void dfs(List<String> ans, StringBuilder sb, String word, int pos, int num) {
        int len = sb.length();
        if (pos == word.length()) {
            if (num != 0) sb.append(num);
            ans.add(sb.toString());
            sb.setLength(len);
            return;
        }
        dfs(ans, sb, word, pos + 1, num + 1);
        if (num != 0) sb.append(num);
        dfs(ans, sb.append(word.charAt(pos)), word, pos + 1, 0);
        sb.setLength(len);
    }
}