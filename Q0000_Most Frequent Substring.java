/**
 * Created by csy99 on 8/29/21.
 
Given a string, we want to know the maximum no. of occurrences of any substring that satisfies following two conditions:

The substring’s lengths is within in inclusive range of minLength to maxLength.
The total no. of unique characters in the string doesn’t exceed maxUnique.
For example, given a string s=abcde, minLength=2, maxLength=5, maxUnique=3, the substrings matching the criteria are (ab, bc, cd, de, abc, bcd, cde). Any shorter string fails he minLength>=2 any longer will fail maxUnique <= 3. Each of the substring occurs only one time.

INPUT :
First line contains a string, second line contains minLength, third line contains maxLength, and the last line contains maxUnique.

Constraints :

2<=n<=105
2<=minLength<= maxLength <=26
maxLength<n
2<=maxUnique<=26
SAMPLE INPUT :
ababab
2
3
4
SAMPLE OUTPUT :
3
**EXPLANATIONS : **
We want to find the no. of occurrences of the most frequently occurring substring of s= “ababab” that has the length in the inclusive range from minLength = 2 and maxLength=3 and contains maximum of maxUnique = 4 unique characters. The substring ab occurs three times aba, bab and ba occurs twice. Because we want maximum of this frequencies we return 3 as our answer.

 */
class Solution {
	public static int mostFreqSubstring(String str, int minLength, int maxLength, int unique) {
		int n = str.length();
		if (n < minLength) return 0;
		int res = 0;
		Map<Character, Integer> counts = new HashMap();
		Map<String, Integer> candidate = new HashMap();
		for (int r = 0; r < minLength-1; r++) {
			char c =  str.charAt(r);
			counts.put(c, counts.getOrDefault(c,0)+1);
		}
		for (int r = minLength-1; r < n; r++) {
			int l = r - minLength + 1
			char cur = str.charAt(r);
			counts.put(cur, counts.getOrDefault(cur, 0)+1);
			String sub = str.substring(l, r+1);
			if (counts.size() <= unique) {
				int freq = candidate.getOrDefault(sub, 0)+1;
				res = Math.max(freq, res);
				freq = put(sub, freq);
			}
			char first = str.charAt(l);
			int cnt1 = counts.get(first);
			if (cnt1 == 1)
				counts.remove(first);
			else
				counts.put(first, cnt-1);
		}
		return res;
	}
}
