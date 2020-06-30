package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by csy99 on 6/29/20.
 */
public class Q218_The_Skyline_Problem {
    /**
     * This video is super clear and helpful: https://www.youtube.com/watch?v=GSBLe8cKu0s
     * Algorithm:
     * First observation: all the points in the final result come from the four angles that each building has
     * Scan through the horizontal lines
     * Use a PriorityQueue to hold each building, and make the PriorityQueue to sort on the height of the buildings
     * whenever we encounter the start of a building, we push it into the PriorityQueue, whenever we finished scanning that building, we remove it from the PriorityQueue
     * Also, in the scan process, we’ll keep updating the maxHeight in the PriorityQueue if we find a new maxHeight which means the building will be overshadowed by the new higher one
     * <p>
     * Three edge cases (see the graph illustration in the above video at 12’18”):
     * when two buildings have the same start point, the one with higher height shows up in the final result
     * when two buildings have the same end point, the one with higher height shows up in the final result
     * when the start point of one building is is also the end point of another building, the one with higher height shows up in the final result
     * <p>
     * We use TreeMap over a normal PriorityQueue:
     * For the sake of efficiency (better time complexity), we’ll use TreeMap which supports O(logn) for remove() operation, this is the reason we choose TreeMap over a normal PriorityQueue in Java (PriorityQueue supports add() and getMaxVal() in both O(logn) time, however, for remove(), it does NOT.)
     * But TreeMap in Java supports all the three operations in O(logn) time.
     */
    // TreeMap, time: O(n*log n), space: O(n)
    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        Building[] points = new Building[n*2];
        int idx = 0;
        for (int[] build: buildings) {
            points[idx++] = new Building(build[0], true, build[2]);
            points[idx++] = new Building(build[1], false, build[2]);
        }
        Arrays.sort(points);
        TreeMap<Integer, Integer> cnt = new TreeMap();
        cnt.put(0, 1);
        int prevHi = 0;
        List<List<Integer>> res = new ArrayList();
        for (Building b: points) {
            if (b.isStart) {
                cnt.compute(b.hi, (key, val) -> {
                    if (val == null)
                        return 1;
                    return val + 1;
                });
            } else {
                cnt.compute(b.hi, (key, val) -> {
                    if (val == 1)
                        return null;
                    return val - 1;
                });
            }
            int curMax = cnt.lastKey();
            if (prevHi != curMax) {
                ArrayList<Integer> elem = new ArrayList();
                elem.add(b.x);
                elem.add(curMax);
                res.add(elem);
                prevHi = curMax;
            }
        }
        return res;
    }
}

class Building implements Comparable<Building> {
    int x;
    boolean isStart;
    int hi;
    
    public Building(int xval, boolean start, int height) {
        x = xval;
        isStart = start;
        hi = height;
    }
    
    @Override
    public int compareTo(Building b2) {
        if (this.x != b2.x)
            return this.x - b2.x;
        // if two starts are compared, then higher building should come first
        // if two ends are compared then lower height building should come first
        // otherwise, start should appear before end
        int h1 = this.isStart ? -this.hi:this.hi;
        int h2 = b2.isStart ? -b2.hi:b2.hi;
        return h1-h2;
    }
}


// known bugs: heap index 
class Solution {
  public List<List<Integer>> getSkyline(int[][] buildings) {
    int n = buildings.length;
    if (n == 0) return new ArrayList();
    
    ArrayList<List<Integer>> res = new ArrayList();
    Event[] events = new Event[2*n]; 
    int id = 0;  // id of each building
    for (int[] b: buildings) {
      Event entering = new Event(id, b[0], b[2], 1);
      Event leaving = new Event(id, b[1], b[2], -1);
      events[2*id] = entering;
      events[2*id+1] = leaving;
      id++;
    }
    Arrays.sort(events, (e1, e2) -> e1.compareTo(e2));
  
    MaxHeap heap = new MaxHeap(n);
    heap.add(0);
    for (Event e: events) {
      if (e.type == 1) {
        if (e.h > heap.maxHeight()) {
          ArrayList<Integer> line = new ArrayList();
          line.add(e.x);
          line.add(e.h);
          res.add(line);
        }
        heap.add(e.h, e.id);
      } else {
        heap.remove(e.id);
        if (e.h > heap.maxHeight()) {
          ArrayList<Integer> line = new ArrayList();
          line.add(e.x);
          line.add(heap.maxHeight());
          res.add(line);
        }
      }
    }
    
    return res;
  }
}

class Pair {
  int a;
  int b;
  
  public Pair(int a, int b) {
    this.a = a;
    this.b = b;
  }
}


class Event {
  int id;
  int x;
  int h;
  int type;  // 1 means the entering of the building, 0 means the leaving of the building
  
  public Event (int id, int x, int h, int type) {
    this.id = id;
    this.x = x;
    this.h = h;
    this.type = type;
  }
  
  public int compareTo(Event e2) {
    // entering event: ranking h from high to low
    // leaving event: ranking h from low to high
    if (x == e2.x) {
      if (type*h > e2.type*e2.h) return 1;
      else if (type*h == e2.type*e2.h) return 0;
      else return -1;
    }
    return x - e2.x;
  }
  
  public void print() {
    System.out.printf("id:%d, x:%d, h:%d, type:%d\n", id, x, h, type);
  }
}

    class MaxHeap {
        // (key, id)
        private List<int[]> nodes;
        
        // idx[i] = index of building[i] in nodes
        private int[] idx;
        
        public MaxHeap(int size) {
            idx = new int[size];
            nodes = new ArrayList<int[]>();
        }
        
        public void add(int key, int id) {
            idx[id] = nodes.size();
            nodes.add(new int[]{key, id});
            heapifyUp(idx[id]);
        }
        
        public void remove(int id) {
            int idx_to_evict = idx[id];
            swapNode(idx_to_evict, nodes.size() - 1);
            idx[id] = -1;
            nodes.remove(nodes.size() - 1);
            heapifyUp(idx_to_evict);
            heapifyDown(idx_to_evict);
        }
        
        public Boolean empty() {
            return nodes.isEmpty();
        }
        
        public int maxHeight() {
            return empty() ? 0 : nodes.get(0)[0];
        }
        
        private void heapifyUp(int i) {            
            while (i != 0) {            
                int p = (i - 1) / 2;
                if (nodes.get(i)[0] <= nodes.get(p)[0])
                    return;
                
                swapNode(i, p);
                i = p;
            }
        }
        
        private void swapNode(int i, int j) {
            int tmpIdx = idx[nodes.get(i)[1]];
            idx[nodes.get(i)[1]] = idx[nodes.get(j)[1]];
            idx[nodes.get(j)[1]] = tmpIdx;
 
            int[] tmpNode = nodes.get(i);
            nodes.set(i, nodes.get(j));
            nodes.set(j, tmpNode);
        }
        
        private void heapifyDown(int i) {
            while (true) {
                int c1 = i*2 + 1;
                int c2 = i*2 + 2;
 
                if (c1 >= nodes.size()) return;
 
                int c = (c2 < nodes.size() 
                      && nodes.get(c2)[0] > nodes.get(c1)[0]) ? c2 : c1;
                
                if (nodes.get(c)[0] <= nodes.get(i)[0])
                    return;
                
                swapNode(c, i);
                i = c;
            }
        }
        
    }
