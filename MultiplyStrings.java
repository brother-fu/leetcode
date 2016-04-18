public class MultiplyStrings {
    public String multiply(String num1, String num2) {
        int l1 = num1.length(), l2 = num2.length();
        int[] ans = new int[l1 + l2];
        for (int i = l1 - 1; i >= 0; i--) {
            for (int j = l2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = ans[p2] + mul;
                ans[p1] += sum / 10;
                ans[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            if(sb.length() == 0 && a == 0)
               continue;
            sb.append(a);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}