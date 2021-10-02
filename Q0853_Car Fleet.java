/**
 * Created by csy99 on 10/2/21.
 */
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        List<Car> traffic = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Car car = new Car(position[i], speed[i]);
            car.calcDuration(target);
            traffic.add(car);
        }
        Collections.sort(traffic);
        double slowest = 0;
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            double dur = traffic.get(i).duration;
            if (dur > slowest) {
                slowest = dur;
                res++;
            }
        }
        return res;
    }
}

class Car implements Comparable<Car>{
    int pos;
    int speed;
    double duration;
    
    public Car(int p, int v) {
        pos = p;
        speed = v;
        duration = 0;
    }
    
    void calcDuration(int target) {
        duration = (target-pos) / (double) speed;
    }
    
    public int compareTo(Car o) {
        return Double.compare(pos, o.pos);
    }
}
