/**
 * Created by csy99 on 2/6/2021 during contest. 
 */
class Solution {
    public String largestMerge(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        StringBuilder sb =  new StringBuilder();
        StringBuilder candidate1 = new StringBuilder();
        StringBuilder candidate2 = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (arr1[i] > arr2[j]) {
                sb.append(arr1[i]);
                i++;
            } else if (arr1[i] < arr2[j]) {
                sb.append(arr2[j]);
                j++;
            } else {
                candidate1.setLength(0);
                candidate1.append(word1);
                String tmp1 = candidate1.substring(i);
                candidate2.setLength(0);
                candidate2.append(word2);
                String tmp2 = candidate2.substring(j);
                if (tmp1.toString().compareTo(tmp2.toString()) > 0) {
                    sb.append(arr1[i]);
                    i++;
                } else {
                    sb.append(arr2[j]);
                    j++;
                }
            }
        }
        while (i < m) {
            sb.append(arr1[i]);
            i++;
        }
        while (j < n) {
            sb.append(arr2[j]);
            j++;
        }
        return sb.toString();
    }
}
