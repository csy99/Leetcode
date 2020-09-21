/**
 * Created by csy99 on 9/21/20.
 */
class Solution {
    public String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        StringBuilder comp = new StringBuilder();
        StringBuilder ending = new StringBuilder();
        int n = arr.length;
        HashSet<Character> vowels = new HashSet();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');
        for (int i = 0; i < n; i++) {
            comp.setLength(0);
            char first = arr[i].charAt(0);
            if (vowels.contains(first)) {
                comp.append(arr[i]);
            } else {
                comp.append(arr[i]);
                comp.deleteCharAt(0);
                comp.append(first);
            }
            sb.append(comp.toString());
            sb.append("ma");
            ending.append("a");
            sb.append(ending.toString());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
