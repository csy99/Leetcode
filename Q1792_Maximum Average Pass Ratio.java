/**
 * Created by csy99 on 3/13/21 during contest.
 */
class Solution {
    public double maxAverageRatio(int[][] classes, int extra) {
        int n = classes.length;
        double sum = 0;
        double[] rate_classes = new double[n];
        int passes = 0;
        int students = 0;
        double avg_rate = 0;
        for (int i = 0; i < n; i++) {
            int[] cls = classes[i];
            passes += cls[0];
            students += cls[1];
            rate_classes[i] = (double) cls[0] / cls[1];
        }
        // System.out.println(Arrays.toString(rate_classes));
        avg_rate = (double) passes / students;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                if ( (double)(classes[a][0]+1)/(classes[a][1]+1) - rate_classes[a] > (double)(classes[b][0]+1)/(classes[b][1]+1) - rate_classes[b]) return -1;
                if ( (double)(classes[a][0]+1)/(classes[a][1]+1) - rate_classes[a] < (double)(classes[b][0]+1)/(classes[b][1]+1) - rate_classes[b]) return 1;
                return 0;
            }
        });
        for (int i = 0; i < n; i++)
            pq.add(i);
        while (extra > 0) {
            Integer idx = pq.poll();
            // System.out.printf("idx: %d\n",idx);
            rate_classes[idx] = (double)(classes[idx][0]+1)/(classes[idx][1]+1);
            classes[idx][0] += 1;
            classes[idx][1] += 1;
            // System.out.printf("[0]:%d, [1]:%d\n",classes[idx][0],classes[idx][1]);
            pq.add(idx);
            extra--;
        }
        // System.out.println(Arrays.toString(rate_classes));
        for (double rate: rate_classes) 
            sum += rate;
        return sum / n;
    }
}
 
