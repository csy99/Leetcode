/**
 * Created by csy99 on 8/1/21.
An e-commerce company imports a type of fitness band from China and sell them in US for a higher price for a profit. The company has multiple suppliers for the product, each with their own inventory. The suppliers raise the price of their product when inventory gets small due to scarcity. More specifically, the profit the e-commerce company makes for each product sold is equal to the number of products left from the supplier.

Given a list of integers representing the number of products each supplier has and an integer representing the number of products sold, find the maximum profit the company can make.

Examples
Example 1:
Input:
inventories = [4, 6] order = 4

Output: 19
Explanation:
There are two suppliers, with inventory 4 and 6 respectively. A total of 4 items are ordered. We can make maximum profit by

getting 1 item from the second supplier for 6
getting 1 item from the second supplier for 5
getting 1 item from the second supplier for 4
getting 1 item from the first supplier for 4
The maximum profit is 6 + 5 + 4 + 4 = 19.

Example 2:
Input:
inventories = [10, 10]

order = 5

Output: 46
Explanation:
The maximum profit we can generate is by

getting 1 item for a profit of 10 from the first supplier
getting 1 item for a profit of 10 from the second supplier
getting 1 item for a profit of 9 from the first supplier
getting 1 item for a profit of 9 from the second supplier
getting 1 item for a profit of 8 from the first or second supplier
The maximum profit is 10 + 10 + 9 + 9 + 8 = 46. 
 */

class Solution {
//pq
}
