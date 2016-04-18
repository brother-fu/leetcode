public class ReverseInteger {
    public int reverse(int x) {
        if (x == 0) return 0;
        int sign = 1;
        if (x < 0) 
          sign = -1;
        String s = String.valueOf(x);
        if (s.charAt(0) == '+' || s.charAt(0) == '-')
          s = s.substring(1); // + / - ?
        long tmp = Long.parseLong(new StringBuilder(s).reverse().toString());
        if (sign == 1) {
            if (tmp > Integer.MAX_VALUE)
               return 0;
        }
        if (sign == -1) {
            if (tmp * sign < Integer.MIN_VALUE) 
               return 0;
        }
        
        return (int) tmp * sign;
    }
}