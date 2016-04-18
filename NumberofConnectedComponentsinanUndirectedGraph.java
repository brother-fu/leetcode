/*Union & Find*/
public class NumberofConnectedComponentsinanUndirectedGraph {
    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int count = n;
        for (int i = 0; i < n; i++)
            parent[i] = i;
        for (int[] edge : edges) { 
            int p1 = findParent(parent, edge[0]);
            int p2 = findParent(parent, edge[1]);
            if (p1 != p2) {
                count--;
                parent[p1] = p2;
            }
        }
        return count;
    }
    private int findParent(int[]parent, int p) {
        while (p != parent[p])
            p = parent[p];
        return p;
    }
}