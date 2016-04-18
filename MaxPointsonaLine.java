/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class MaxPointsonaLine {
    public int maxPoints(Point[] points) {
        if (points == null) return 0;
        if (points.length <= 2) return points.length;
        int len = points.length;
        int sameP = 0, coLine = 0, max = 0;
        int innerMax = 0;
        for (int i = 0; i < len; i++) {
            Point A = points[i];
            sameP = 1; innerMax = 0;  //!!!!   !!!!   !!!! !!!  !!! innerMax 非常关键
            for (int j = i + 1; j < len; j++) {
                Point B = points[j];
                if (A.x == B.x && A.y == B.y) {
                    sameP++;
                    continue;
                }
                coLine = 1;
                for (int k = j + 1; k < len; k++) {
                    Point C = points[k];
                    if (A.x == C.x && A.y == C.y)
                        continue;
                    if (isCoLine(A, B, C))
                        coLine++;
                }
                innerMax = Math.max(innerMax, coLine);
            }
            max = Math.max(max, innerMax + sameP);
        }
        return max;
    }
    private boolean isCoLine(Point A, Point B, Point C) {
        return (A.x - B.x) * (A.y - C.y) == (A.y - B.y) * (A.x - C.x);
    }
}