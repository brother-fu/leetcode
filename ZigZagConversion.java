public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (nRows <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        int cycle = 2 * nRows - 2;
        for (int i = 0; i < nRows; i++) {
            for (int j = i; j < len; j = j + cycle) {
                sb.append(s.charAt(j));
                int second = j + cycle - 2 * i;
                if (i != 0 && i != nRows - 1 && second < len) 
                    sb.append(s.charAt(second));
            }
        }
        return sb.toString();
    }
}