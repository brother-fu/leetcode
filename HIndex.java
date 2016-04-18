public class HIndex {
    public int hIndex(int[] citations) {
       Arrays.sort(citations);
       int len = citations.length;
       for (int i = 0; i < len; i++) {
           if (citations[i] >= len - i)
               return len - i;
       }
       return 0;
    }

    /*O(n)*/
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] papers = new int[n + 1];
        // counting papers for each citation number
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // finding the h-index
        int k = n;
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;
    }
}