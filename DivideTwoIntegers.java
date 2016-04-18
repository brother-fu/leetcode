public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
       if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) 
           return Integer.MAX_VALUE;
       boolean sign = true;
       long ldividend = (long) dividend;
       long ldivisor  = (long) divisor;
       if (ldividend < 0) {
           sign = !sign;
           ldividend = -ldividend;
       }
       if (ldivisor < 0) {
           sign = !sign;
           ldivisor = -ldivisor;
       }
       int ans = 0;
       while (ldividend >= ldivisor) { //始终多操作一次的策略；
           long d = ldivisor;
           long base = 1;  //不然在2147483647时候回溢出
           while (d <= ldividend) {
               d <<= 1;
               base <<= 1;
           }
           d >>= 1;
           base >>= 1;
           ans += base;
           ldividend -= d;
       }
       if (!sign) ans = -ans;
       return (int)ans;
    }
}