public class Pow(x, n) {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        if (n == 0) return 1;
        if (n == 2) return x * x;
        if (n > 0) {
          return myPow(myPow(x, n / 2), 2) * (n % 2 == 1 ? x : 1);
        } else {
            return 1 / (myPow(x, -(n + 1))) / x;
        }
        
        
    }
}