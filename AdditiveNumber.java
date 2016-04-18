public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {
        int len = num.length();
        for (int i = 1; i <= len / 2 + 1; i++) {
            if (i > 1 && num.charAt(0) == '0')
                break;
            Long num1 = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && num.charAt(i) == '0') 
                   break;
                Long num2 = Long.parseLong(num.substring(i, j));
                if (helper(num, j, num1 + num2, num2))
                    return true;
            }
        }
        return false;
    }
    private boolean helper(String num, int i, Long start, Long num1) {
        if (i == num.length()) return true;
        String match = String.valueOf(start);
        if (num.startsWith(match, i)) {
            Long num2 = start;
            return helper (num, i + match.length(), num1 + num2, num2);
        } else {
            return false;
        }
    }
}

/*40*/