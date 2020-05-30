package Leetcode;

/**
 * Created by csy99 on 5/30/20.
 */
public class Q134_Gas_Station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        int n = gas.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
            if (totalGas < totalCost) {
                idx = i+1;
                totalGas = 0;
                totalCost = 0;
            }
            if (idx >= n)
                return -1;
        }
        for (int i = 0; i < idx; i++) {
            totalGas += gas[i];
            totalCost += cost[i];     
            if (totalGas < totalCost)
                return -1;
        }
        
        return idx;
    }
    
    // compress time
    public int canCompleteCircuit(int[] gas, int[] cost) {
      if (gas == null || gas.length == 0)
        return 0;
      
      int surplus = 0, pos = 0, net_diff = 0;  
      for (int i = 0; i < gas.length; i++) {
        surplus += gas[i] - cost[i];
        if (surplus < 0) {  // can't finish the cycle starting at pos 
          surplus = 0;
          pos = i + 1;  // try starting at a next possible station
        }
        net_diff += gas[i] - cost[i];
      }
      return net_diff >= 0 ? pos:-1;
    }
}
