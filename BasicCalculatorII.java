public class BasicCalculatorII {
    public int calculate(String s) {
        s = s + '$';
        char op = '+';
        int num = 0;
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else {
                if (op == '+') {
                    stack.push(num);
                }
                if (op == '-') {
                    stack.push(-num);
                }
                if (op == '*') {
                    stack.push(stack.pop() * num);
                }
                if (op == '/') {
                    stack.push(stack.pop() / num);
                }
                op = c;
                num = 0;
            }
        }
        int ans = 0;
        for (Integer it : stack)
            ans += it;
        return ans;
    }
}