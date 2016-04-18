public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<Character>();
        HashMap<Character, Character> mp = new HashMap<Character, Character>(){{put(')', '('); put('}', '{'); put(']', '[');}};
        for (int i = 0; i < s.length(); i++) {
            if (! mp.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if (stack.empty()) {
                    return false;
                }
                char pre = stack.pop();
                if (pre != mp.get(s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }
}