public class GraphValidTree {
    /* Union & Find works like a Charm;*/
    public boolean validTree(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int[] edge : edges) {
            int p1 = findParent(edge[0], parent);
            int p2 = findParent(edge[1], parent);
            if (p1 == p2)
                return false; //circlue
            parent[p1] = p2;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i])
               count++;
        }
        return count == 1;
    }
    private int findParent(int p, int[] parent) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }
    


    /*dfs solution*/
    public boolean validTree2(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap();
        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList());
        int[] isVisited = new int[n];
        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        boolean hasCircle = dfs(0, map, isVisited);
        for (int i = 0; i < n; i++)
            if (isVisited[i] == 0)
                return false;
        return hasCircle;
        
    }
    private boolean dfs(int start, Map<Integer, List<Integer>> map, int[] isVisited) {
        isVisited[start] = 1;
        boolean ret = true;
        for (int next : map.get(start)) {
            if (isVisited[next] == 2) 
                return false;
            if (isVisited[next] == 0)
                ret = ret && dfs(next, map, isVisited);
        }
        isVisited[start] = 2;
        return ret;
    }

}

//try both Union find & DFS