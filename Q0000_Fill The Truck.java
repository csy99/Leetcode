/**
 * Created by csy99 on 12/27/20. No promise for correctness. 
 */
import java.io.*;
import java.util.*;

/**
 * 
An Amazon Warehouse manager needs to create a shipment to fill a truck. All of the products in the warehouse are in boxes of the same size. Each product is packed in some number of units per box.

Given the number of boxes the truck can hold, write an algorithm to determine the maximum number of units of any mix of products that can be shipped.

Input

The input to the function method consists of five arguments:

num, an integer representing number of products;
boxes, a list of integers representing the number of available boxes for products;
unitSize, an integer representing size of unitsPerBox;
unitsPerBox, a list of integers representing the number of units packed in each box;
truckSize, an integer representing the number of boxes the truck can carry.

Output

Return an integer representing the maximum units that can be carried by the truck.

Constraints
1 <= |boxes| <= 10^5
|boxes| == |unitsPerBox|
1 <= boxes[i] <= 10^7
1 <= i <= |boxes|
1 <= unitsParBox[i] <= 10^5
1 <= j <= |unitsPerBox|
1 <= truckSize <= 10 ^ 8

Note

[list name] denotes length of the list.

Example

Input:
num=3
boxes=[1,2,3]
unitSize=3
unitsPerBox= [3,2,1]
truckSize = 3

Output
7

Explanation:
Product 0: because boxes[0] = 1, we know there is 1 box in product 0. And because unitsPerBox[0] = 3, we know there is 1 box with 3 units in product 0.
Product 1: 2 boxes with 2 units each
Product 2: 3 boxes with 1 unit each
Finall we have the packed products like a list : [3, 2, 2, 1, 1, 1]
The truckSize is 3, so we pick the top 3 from the above list, which is [3, 2, 2], and return the sum 7.
The maximum number of units that can be shipped = 3 + 2 + 2 = 7 units
 * @author CSY
 *
 */
class Solution {
    
    private int getMaxUnit(int num, int unitSize, int truckSize,
                    List<Integer> boxes, List<Integer> unitsPerBox) {
        int res = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for (int i = 0; i < num; i++) {
            int num_box = boxes.get(i);
            int unit = unitsPerBox.get(i);
            for (int j = 0; j < num_box; j++) {
                if (unit > minHeap.peek()) 
                    minHeap.add(unit);
                else
                    break;
                if (minHeap.size() > truckSize)
                    minHeap.poll();
            }
        }
        for (int unit: minHeap)
            res += unit;
        return res;
    }
    
    
    public static void main(String[] args) {
    
    }
}
