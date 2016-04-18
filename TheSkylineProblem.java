public class TheSkylineProblem {
    public List<int[]> getSkyline(int[][] buildings) {
         List<int[]> ans = new ArrayList();
         List<int[]> boundary = new ArrayList();
         PriorityQueue<Integer> pq = new PriorityQueue((a, b) -> {
             return (int)b - (int)a;
         });
         for (int[] b : buildings) {
             boundary.add(new int[]{b[0], b[2]});
             boundary.add(new int[]{b[1], -b[2]});
         }
         Collections.sort(boundary, (a, b) ->{
             if (a[0] != b[0])
                 return a[0] - b[0];
             return b[1] - a[1];
         });
         
         int pre = 0;
         pq.offer(0);
         for (int i = 0; i < boundary.size(); i++) {
             int[] now = boundary.get(i);
             if (now[1] > 0) {
                 pq.offer(now[1]);
             } else {
                 pq.remove(-now[1]);
             }
             //System.out.println(pq.peek());
             if (pq.peek() != pre) {
                 ans.add(new int[]{now[0], pq.peek()});
                 pre = pq.peek();
             }
         }
         return ans;
    }
}