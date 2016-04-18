public class SubstringwithConcatenationofAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<String, Integer> tofind = new HashMap<String, Integer>();
        HashMap<String, Integer> find = new HashMap<String, Integer>();
        for (String word : words) {
            if (!tofind.containsKey(word))
                tofind.put(word, 1);
            else 
                tofind.put(word,tofind.get(word) + 1);
        }
        int m = words[0].length(), n = words.length;
        int j = 0;
        for (int i = 0; i <= s.length() - m * n; i++) {
            find.clear();   //HashMap 可以用clear()函数
            for (j = 0; j < n; j++) {
                int k = i + j * m;
                String sub = s.substring(k, k + m);
                if (!tofind.containsKey(sub))
                    break;
                else {
                    if (!find.containsKey(sub))
                        find.put(sub, 1);
                    else 
                        find.put(sub,find.get(sub) + 1);
                    if (find.get(sub) > tofind.get(sub))
                       break;
                }
            }
            if (j == n) ans.add(i);   //用j来判断是否最后加成功了，很巧妙
        }
        return ans; 
    }
}