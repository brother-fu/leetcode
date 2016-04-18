public class Sqrt(x) {
    public int mySqrt(int x) {
       double t = x; //double
       while (Math.abs(t * t - x) > 1e-6) { //绝对值
           t = (t + x / t) / 2.0; // 除以2
       }
       return (int)t;
    }
}