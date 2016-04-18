public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] counter = new int[256];
        Stack<Character> stack = new Stack();
        Set<Character> seen = new HashSet();
        char[] sc = s.toCharArray();
        for (char c : sc) {
            counter[c]++;
        }
        /*太好了，又是一坨屎*/
        for (int i = 0; i < sc.length; i++) {
            char c = sc[i];
            if (seen.contains(c)) { /*abcacb的例子，如果存在就得跳过！*/
                counter[c]--;
                continue;
            } else {
                while (!stack.empty() && stack.peek() > c && counter[stack.peek()] > 0) {
                     char t = stack.pop();
                     seen.remove(t);
                }
                counter[c]--;
                stack.push(c);
                seen.add(c);
            }
        }
        
        
        
        //
        StringBuilder sb = new StringBuilder();
        for (Character c : stack)
            sb.append(c);
        return sb.toString();
    }
}