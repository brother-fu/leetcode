/* 题目大意
You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right. You are given a 2D grid of values 0, 1 or 2, where:

Each 0 marks an empty land which you can pass by freely.
Each 1 marks a building which you cannot pass through.
Each 2 marks an obstacle which you cannot pass through.
For example, given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2):

1 - 0 - 2 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (1,2) is an ideal empty land to build a house, as the total travel distance of 3+3+1=7 is minimal. So return 7.
*/

public class ShortestDistancefromAllBuildings  {
    public int shortestDistance(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dist = new int[row][col];
        int[][] reach = new int[row][col];
        int buildNum = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    buildNum++;
                    bfs(grid, i, j, dist, reach, row, col);
                }
            }
        }
        //get value;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0 && reach[i][j] == buildNum) 
                    min = Math.min(min, dist[i][j]);
            }
        }
        return min == Integer.MAX_VALUE? -1 : min;
    }
    private void bfs(int[][] grid, int x, int y, 
                     int[][] dist, int[][] reach,
                     int row, int col)
    {
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList();
        Set<Integer> seen = new HashSet();
        queue.offer(new int[]{x, y});
        seen.add(x * col + y);
        int len = 0;
        while (queue.size() != 0) {
            int size = queue.size();
            len++;
            for (int i = 0; i < size; i++) {
                int[] now = queue.poll();
                for (int[] dir : dirs) {
                    int xx = now[0] + dir[0];
                    int yy = now[1] + dir[1];
                    if (xx < 0 || xx >= row || yy < 0 || yy >= col || grid[xx][yy] != 0 || seen.contains(xx * col + yy))
                        continue;
                    dist[xx][yy] += len;
                    reach[xx][yy] += 1;
                    seen.add(xx * col + yy);
                    queue.offer(new int[]{xx, yy});
                }
            }
        }
    }
}

/*18*/