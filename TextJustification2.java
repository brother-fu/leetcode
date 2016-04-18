public class TextJustification2 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList();
        int len = words.length;
        System.out.println(len);
        int i = 0, j = 0;
        while (j <= len) {
            int curLen = 0;
            StringBuilder sb = new StringBuilder();
            for (; j < len;) {
                if (curLen + words[j].length() + j - i <= maxWidth) {
                    curLen += words[j].length();
                    j++;
                } else {
                    break;
                }
            }
            if (j == len || j - i == 1) {
                for (; i < j; i++) {
                    //System.out.println("i: " + i + "  j: " + j);
                    sb.append(words[i]);
                    if (maxWidth > sb.length())
                        sb.append(' '); /*2*/
                    if (i == j - 1) {
                        addSpace(sb, maxWidth - sb.length());
                    }
                } 
                if (j == len) { /*1*/
                    j++;
                }
                    
            } else {
                int space = maxWidth - curLen;
                int slot = j - i - 1;
                int more = space % slot;
                int gap = space / slot;
                int tmp = i;
                for (; i < j; i++) {
                    sb.append(words[i]);
                    if (i != j - 1) /*3*/
                        addSpace(sb, gap);
                    if (i - tmp < more) {
                        sb.append(' ');
                    }
                }
            }
            ans.add(sb.toString());
            i = j;
        }
        return ans;
    }
    private void addSpace(StringBuilder sb, int len) {
        for (int i = 0; i < len; i++)
            sb.append(' ');
    }
}



/*28*/