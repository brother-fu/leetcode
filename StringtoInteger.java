public class StringtoInteger  {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0)
           return 0;
        s = s.trim();
        int sign = 1, i = 0;
        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-')
               sign = -1;
            i++;
        }
        long num = 0;
        for (; i < s.length(); i++) {
            char c  = s.charAt(i);
            if (Character.isDigit(c)) {
               num = num * 10 + c - '0';
               if (sign * num > Integer.MAX_VALUE)
                  return Integer.MAX_VALUE;
               if (sign * num < Integer.MIN_VALUE)
                  return Integer.MIN_VALUE;
            }
            else {
                break;
            }
        }
        return sign * (int)num;
    }
    
}