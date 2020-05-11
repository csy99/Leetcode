/*
 * Created by csy99 on 2/29/20 during competition.
1366. Rank Teams by Votes
In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.
The ordering of teams is decided by who received the most position-one votes. 
If two or more teams tie in the first position, we consider the second position to resolve the conflict, 
if they tie again, we continue this process until the ties are resolved. 
If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.
Given an array of strings votes which is the votes of all voters in the ranking systems. 
Sort all teams according to the ranking system described above.
Return a string of all teams sorted by the ranking system.

Constraints:

1 <= votes.length <= 1000
1 <= votes[i].length <= 26
votes[i].length == votes[j].length for 0 <= i, j < votes.length.
votes[i][j] is an English upper-case letter.
All characters of votes[i] are unique.
All the characters that occur in votes[0] also occur in votes[j] where 1 <= j < votes.length


Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
Output: "ACB"
Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
Team B was ranked second by 2 voters and was ranked third by 3 voters.
Team C was ranked second by 3 voters and was ranked third by 2 voters.
As most of the voters ranked C second, team C is the second team and team B is the third.

Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
Explanation: Only one voter so his votes are used for the ranking.

Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
Output: "ABC"
Explanation: 
Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
There is a tie and we rank teams ascending by their IDs.

Input: votes = ["M","M","M","M"]
Output: "M"
Explanation: Only team M in the competition so it has the first rank.
*/

class Solution {
    public String rankTeams(String[] votes) {
      int len = votes.length;
      int teams = votes[0].length();
      if (len == 1 || teams == 1)  // only one team or only one vote
        return votes[0];
      
      int[][] cnt = new int[26][teams + 1];
      for (int i = 0; i < len; i++) {
        int val = 0;
        for (int j = 0; j < teams; j++) {  // rank in this vote
          val = votes[i].charAt(j) - 65;  // 65 is the ascii value of 'A'
          cnt[val][j] += 1;
          cnt[val][teams] = -(val + 65);
        }
      }
      
      // debug
      // for (int i = 0; i < teams; i++) {
      //   System.out.println(Arrays.toString(cnt[i]));
      // }
      
      Arrays.sort(cnt, new java.util.Comparator<int[]>() {
        public int compare(int[] a, int[] b) {
          for (int i = 0; i < a.length; i++) {
            if (a[i] > b[i])
              return -1;
            else if (a[i] < b[i])
              return 1;
          }
          return 0;  // not gonna happen
        }
      });
      
      // debug
      // for (int i = 0; i < teams; i++) {
      //   System.out.println(Arrays.toString(cnt[i]));
      // }
      
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < teams; i++) {
        int tmp = -cnt[i][teams];
        char c = ((char) tmp);
        sb.append(c);
      }
      return sb.toString();
      
    }
}

