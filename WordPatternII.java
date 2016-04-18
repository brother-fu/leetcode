/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

Examples:
pattern = "abab", str = "redblueredblue" should return true.
pattern = "aaaa", str = "asdasdasdasd" should return true.
pattern = "aabb", str = "xyzabcxzyabc" should return false.
*/



public class WordPatternII   {
    public boolean wordPatternMatch(String p, String s) {
        Map<Character, String> map = new HashMap();
        return helper(p, s, 0, 0, map);
    }
    private boolean helper(String p, String s, int pp, int sp, Map<Character, String> map) {
        if (sp == s.length() && pp != p.length())
            return false;
        if (pp == p.length()) {
            return sp == s.length();
        }
        char c = p.charAt(pp);
        if (map.containsKey(c)) {
            String match = map.get(c);
            if (!s.startsWith(match, sp))
                return false;
            return helper(p, s, pp + 1, sp + match.length(), map);
        } else {
            for (int i = sp + 1; i <= s.length(); i++) {
                String toMatch = s.substring(sp, i);
                if (map.values().contains(toMatch))
                    continue;
                map.put(c, toMatch);
                if (helper(p, s, pp + 1, i, map))
                   return true;
                map.remove(c);
            }
            return false;
        }
    }
}