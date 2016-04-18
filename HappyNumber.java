public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet();
        while (n != 1) {
            int tmp = n;
            int sum = 0;
            while (tmp > 0) {
                int b = tmp % 10;
                sum += b * b;
                tmp /= 10;
            }
            n = sum;
            if (!seen.add(n))
                return false;
        }
        return true;
    }
}