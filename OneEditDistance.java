public class OneEditDistance  {
    public boolean isOneEditDistance(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        int i = 0, j = 0;
        if ((int)Math.abs(len1 - len2) > 1)
            return false; /*teacher, tache*/
        int diff = 0;
        while(i < len1 && j < len2) {
            char sc = s.charAt(i);
            char tc = t.charAt(j);
            if (sc == tc) {
                i++;
                j++;
            } else {
                i++; j++;
                if (len1 < len2)
                    i--;
                if (len1 > len2)
                    j--;
                diff++;
            }
            if (diff > 1)
               return false;
        }
        return len1 - len2 == 1 || len1 - len2 == -1 || diff == 1; /*diff ==1不要忘记了*/
    }
}