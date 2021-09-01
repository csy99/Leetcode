/**
 * Created by csy99 on 9/1/21.
 * https://www.lintcode.com/problem/966/description
 */
public class Solution {
    /**
     * @param x: the list of coordinate x
     * @param y: the list of coordinate y
     * @return: find the closest pair of points and return the distance
     */
    public double getClosestDistance(double[] x, double[] y) {
        int n = x.length;
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) 
            points[i] = new Point(x[i], y[i]);
        Arrays.sort(points, (a,b)->(Double.compare(a.x, b.x)));
        return split(points, 0, n-1);
    }

    private double bruteForce(Point[] points, int start, int end) {
        double min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) 
            for (int j = i+1; j <= end; j++) 
                min = Math.min(min, Point.distance(points[i], points[j]));
        return min;
    }

    private double split(Point[] points, int start, int end) {
        int n = end-start+1;
        if (n <= 3) return bruteForce(points, start, end);
        Point midX = points[n/2];
        double dl = split(points, start, start+n/2);
        double dr = split(points, start+n/2+1, end);
        double d = Math.min(dl, dr);
        List<Point> middles = new ArrayList();
        for (int i = start; i <= end; i++) {
            if (Math.abs(points[i].x - midX.x) <= d)
                middles.add(points[i]);
        }
        return Math.min(d, crossRegionMin(middles, d));
    }

    private double crossRegionMin(List<Point> points, double min) {
        Collections.sort(points, (a,b)->(Double.compare(a.y, b.y)));
        for (int i = 0; i < points.size(); i++) {
            for (int j = i+1; j < points.size(); j++) {
                if (points.get(j).y - points.get(i).y >= min)
                    break;
                if (Point.distance(points.get(i), points.get(j)) < min)
                    min = Point.distance(points.get(i), points.get(j));
            }
        }
        return min;
    }
}

class Point {
    double x, y;

    public Point(double x_, double y_) {
        x = x_;
        y = y_;
    }

    public static double distance(Point a, Point b) {
        return Math.sqrt((a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y));
    }
}
