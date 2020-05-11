/**
 * Created by csy99 on 3/25/20. 
 */
 
  
  // Priority Queue + HashMap
  // time: O(n logk), space: O(n)
  public List<String> topKFrequent(String[] words, int k) {
    HashMap<String, Integer> freq = new HashMap();
    for (String w: words) 
      freq.put(w, freq.getOrDefault(w, 0) + 1);
    PriorityQueue<Pair> pq = new PriorityQueue(new Comparator<Pair>() {
      public int compare(Pair p1, Pair p2) {  // tie breaking
        int ans = Integer.compare(p1.cnt, p2.cnt);
        return ans != 0 ? ans : p2.word.compareTo(p1.word);
      }
    });
    
    for (String key: freq.keySet()) {
      Pair p = new Pair(key, freq.get(key));
      pq.offer(p);
      if (pq.size() > k)
        pq.poll();
    }
    
    LinkedList<String> res = new LinkedList();
    for (int i = 0; i < k; i++)
      res.addFirst(pq.poll().word);
    return res;
  }
}

class Pair {
  String word;
  int cnt;
  
  public Pair (String w, int c) {
    word = w;
    cnt = c;
  }
}
