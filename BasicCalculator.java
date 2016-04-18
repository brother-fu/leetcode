public class BasicCalculator   {
    public int calculate(String s) {
        int len = s.length();
        Stack<Integer> nums = new Stack();
        Stack<Integer> ops = new Stack();
        int num = 0, ret = 0, op = 1;
        for (int i = 0; i <= len; i++) {
            if (i == len) {
                ret += num * op;
                break;
            }
            char c = s.charAt(i);
            if (c == ' ') continue;
            else if (Character.isDigit(c)) {
                num = num * 10 + c -'0';
            } else {
                 ret += num * op;
                 num = 0;
                 
                 if (c == '+')
                     op = 1;
                 if (c == '-')
                     op = -1;
                 if (c == '(') {
                     nums.push(ret);
                     ops.push(op);
                     ret = 0;
                     op = 1;
                 } 
                 if (c == ')')
                     ret = ret * ops.pop() + nums.pop();
            }
        }
        return ret;
    }
}
/*参照最新刷题总结的三板斧克敌之术*/