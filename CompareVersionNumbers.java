public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        for (; i < v1.length && i < v2.length; i++) {
            Integer it1 = Integer.parseInt(v1[i]);
            Integer it2 = Integer.parseInt(v2[i]);
            if (it1 > it2) return 1;
            if (it1 < it2) return -1;
        }
        for (; i < v1.length; i++)
            if (Integer.parseInt(v1[i]) > 0) return 1;
        for (; i < v2.length; i++) 
            if (Integer.parseInt(v2[i]) > 0) return -1;
        return 0;
    }
}