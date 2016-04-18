/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new ArrayList();
        if (intervals == null || intervals.size() == 0)
            return ans;
        Collections.sort(intervals, (a, b) -> {
            return a.start - b.start;
        });
        int i = 0, j = 0;
        Interval pre = null;
        while (j < intervals.size()) {
            pre = intervals.get(i);
            Interval post = intervals.get(j);
            if (post.start <= pre.end) {
                j++;
                pre.end = Math.max(post.end, pre.end);
                continue;
            }
            ans.add(pre);
            i = j;
        }
        ans.add(pre);
        return ans;
    }
}