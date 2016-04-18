/*
Given a string, we can "shift" each of its letter to its successive letter, for example: "abc" -> "bcd". We can keep "shifting" which forms the sequence:

"abc" -> "bcd" -> ... -> "xyz"
Given a list of strings which contains only lowercase alphabets, group all strings that belong to the same shifting sequence.

For example, given: ["abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"], 
Return:

[
  ["abc","bcd","xyz"],
  ["az","ba"],
  ["acef"],
  ["a","z"]
]
Note: For the return value, each inner list's elements must follow the lexicographic order.

Show Company Tags
Show Tags
Show Similar Problems

*/


public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> ans = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for (String s : strings) {
            String key = getKey(s);
            if (!map.containsKey(key))
                map.put(key, new ArrayList());
            map.get(key).add(s);
        }
        for (List<String> val : map.values()) {
            Collections.sort(val);
            ans.add(val);
        }
        return ans;
    }
    private String getKey(String s) {
        if (s.length() == 0)
           return s;
        StringBuilder sb = new StringBuilder();
        int diff = s.charAt(0) - 'a';
        for (int i = 0; i < s.length(); i++) {
            int tmp = s.charAt(i) - diff;
            if (tmp < 'a') /*<a, 而不是小于0*/
                tmp += 26;
            char c = (char)tmp;
            sb.append(c);
        }
        return sb.toString();
    }
}