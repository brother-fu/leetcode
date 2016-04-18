public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
       HashMap<String, ArrayList<String>> record = new  HashMap<String, ArrayList<String>>();
       List<List<String>> ans  = new ArrayList<List<String>>();
       if (strs == null || strs.length == 0) return ans;
       int len = strs.length;
       for (int i = 0; i < len; i++){
           String temp = modify(strs[i]);
           if (! record.containsKey(temp)){
               ArrayList<String> strgroup = new ArrayList<String>();
               strgroup.add(strs[i]);
               record.put(temp, strgroup);
           } else {
               record.get(temp).add(strs[i]);
           }
       }
        for (String key : record.keySet()){
            Collections.sort(record.get(key));
            ans.add(record.get(key));
        }
        return ans;
    }
    
    private String modify(String str){
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}