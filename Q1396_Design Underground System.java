/**
 * Created by csy99 on 10/20/21.
 */
class UndergroundSystem {
    Map<String, Map<String, Transit>> routes = new HashMap();
    Map<Integer, Route> setOff = new HashMap();
    
    public UndergroundSystem() {
       
    }
    
    public void checkIn(int id, String start, int t) {
        Route r = new Route(start, t);
        setOff.put(id, r);
    }
    
    public void checkOut(int id, String end, int t) {
        Route r = setOff.get(id);
        setOff.remove(id);
        Map<String, Transit> times = routes.getOrDefault(r.start, new HashMap());
        Transit transit = times.getOrDefault(end, new Transit());
        transit.update(t - r.checkInTS);
        times.put(end, transit);
        routes.put(r.start, times);
    }
    
    public double getAverageTime(String start, String end) {
        Transit transit = routes.get(start).get(end);
        return transit.getAvg();
    }
}

class Route {
    String start;
    int checkInTS;
    
    public Route(String s, int t) {
        start = s;
        checkInTS = t;
    }
}

class Transit {
    double sum;
    int cnt;
    
    public Transit() {
        sum = 0;
        cnt = 0;
    }
    
    public double getAvg() {
        return sum / cnt; 
    }
    
    public void update(int num) {
        sum += num;
        cnt += 1;
    }
}
