public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.startsWith(needle, i))
               return i;
        }
        return -1;
    }
}