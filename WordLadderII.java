public class WordLadderII {
    public List<List<String>> findLadders(String begin, String end, Set<String> wordList) {
        Map<String, List<String>> map = new HashMap();
        Map<String, Integer> dist = new HashMap();
        bfs(end, begin, wordList, map, dist);
        List<List<String>> ans = new ArrayList();
        List<String> path = new ArrayList();
        path.add(begin);
        dfs(ans, path, begin, end, map, dist);
        return ans;
    }
    
    private void bfs(String end, String begin, Set<String> wordList, 
                     Map<String, List<String>> map, Map<String, Integer> dist)
    {
        Queue<String> queue = new LinkedList();
        queue.offer(end);
        dist.put(end, 0);
        int len = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                String now = queue.poll();
                for (String next : getNext(now, wordList)) {
                    if (!dist.containsKey(next)) {
                        queue.offer(next);
                        dist.put(next, len);
                    }
                    if (!map.containsKey(next))
                        map.put(next, new LinkedList());
                    map.get(next).add(now);
                }
            }
            if (dist.containsKey(begin))
                break;
        }
    }
    private void dfs(List<List<String>> ans, List<String> path, String start,
                     String end, Map<String, List<String>> map,
                     Map<String, Integer> dist)
    {
        if (path.contains(end)) {
            ans.add(new ArrayList(path));
            return;
        }
        String pre = path.get(path.size() - 1);
        if (!map.containsKey(pre))    /*这里可能没法构成链路，所以图里面不存在begin的单词*/
            return;
        for (String next: map.get(pre)) {
            if (dist.get(next) == dist.get(pre) - 1) {
                path.add(next);
                dfs(ans, path, start, end, map, dist);
                path.remove(path.size() - 1);
            }
        }
        
    }
    private List<String> getNext(String s,  Set<String> wordList) {
        List<String> next = new ArrayList();
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                char tmp = sc[i];
                if (c != tmp) {
                    sc[i] = c;
                    String cand = String.valueOf(sc);
                    if (wordList.contains(cand))
                        next.add(cand);
                    sc[i] = tmp;
                }
            }
        }
        return next;
    }
}

/*45*/