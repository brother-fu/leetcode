public class OneEditDistance {
    public boolean isOneEditDistance(String s, String t) {
        int lens = s.length(), lent = t.length();
        if (Math.abs(lens - lent) > 1) return false;
        int i = 0, j = 0;
        int count = 0;
        while(i < lens && j < lent) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; j++;
            } else {
                if (lens > lent) 
                   i++;
                else if (lens < lent)
                   j++;
                else {
                   i++; j++; //这里括号不能能略
                }
                if (++count > 1)
                    return false;
            }
        }
        return (count == 1) || (Math.abs(lens - lent) == 1);
    }
}