public class ShortestWordDistanceIII {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, Integer> map = new HashMap();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            String now = words[i];
            if (now.equals(word1)) {
                if (map.containsKey(word2)) 
                    min = Math.min(i - map.get(word2), min);
                map.put(now, i);
            } else if (now.equals(word2)) {
                if (map.containsKey(word1))
                    min = Math.min(min, i - map.get(word1));
                map.put(now, i);
            }
        }
        return min;
    }
}