public class FractiontoRecurringDecimal {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator % denominator == 0)       
            return String.valueOf((long)numerator / (long)denominator);    //整除也会有溢出的情况；
        String ans = "";
        if ((numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0)) {
            System.out.println("in");
            ans += "-";
        }
        long num = (long)Math.abs((long)numerator);
        long denom = (long)Math.abs((long)denominator);
        Map<Long, Integer> map = new HashMap();
        ans += (num / denom) + ".";
        long left = (num - num / denom * denom) * 10;     //要乘以10；
        map.put(left, ans.length());
        while (left != 0) {
            long bit = left / denom;
            left = (left - bit * denom) * 10;
            ans += "" + bit;
            if (map.containsKey(left)) {
                int pos = map.get(left);
                String recur = ans.substring(pos);
                String pre = ans.substring(0, pos);
                ans = pre + "(" + recur + ")";
                break;
            } else {
                map.put(left, ans.length());
            }
        }
        return ans;
    }
}