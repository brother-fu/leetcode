/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class InsertInterval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ans = new ArrayList();
        for (int i = 0; i < intervals.size();) {
            Interval it = intervals.get(i);
            if (newInterval == null || it.end < newInterval.start) {
                ans.add(it);
                i++;
            } else if (it.start > newInterval.end) {
                ans.add(newInterval);
                newInterval = null;   //这里不能i++
            } else {
                newInterval.start = Math.min(it.start, newInterval.start);
                newInterval.end = Math.max(it.end, newInterval.end);
                i++;
            }
        }
        if (newInterval != null)
            ans.add(newInterval);
        return ans;
    }
}