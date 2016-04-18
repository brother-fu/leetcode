public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
       List<String> ans = new ArrayList<String>();
       if (digits.length() == 0) {
           /*ans.add("");*/ //改进1
           return ans;
       }
       HashMap<Character, String> map = new HashMap<Character, String>(){{put('0',""); put('1', ""); put('2', "abc"); put('3', "def"); put('4', "ghi"); put('5', "jkl"); put('6', "mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");}};
       char a = digits.charAt(0);
       String now = map.get(a);
       List<String> right = letterCombinations(digits.substring(1));
       if (right.size() == 0) right.add(""); //改进2
       if (now.length() == 0)  return right;
       for (char c : now.toCharArray()) {
           for (String s : right) {
               ans.add(c + s);
           }
       }
       return ans;
    }
}
// 我用了recursion的方法，刚开始为空的时候会出现一个［“”］的答案，而此时目标答案应该是[]; 不好搞；
//除了多一个参数的方案，还有其他方式判断两者区别么, 在right为空的时候，[进入双层循环前] right给它加一个“”;
