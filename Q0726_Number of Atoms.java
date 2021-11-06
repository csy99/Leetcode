/**
 * Created by csy99 on 11/6/21.
 */
class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        StringBuilder res = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        char[] arr = formula.toCharArray();
        Stack<Map<String, Integer>> multi_level_counts = new Stack();
        multi_level_counts.push(new HashMap());
        Stack<String> atoms = new Stack();
        int i = 0;
        while (i < n) {
            if (Character.isLetter(arr[i])) {
                sb.append(arr[i]);
                while (i+1 < n && Character.isLowerCase(arr[i+1])) {
                    sb.append(arr[i+1]);
                    i++;
                }
                atoms.push(sb.toString());
                sb.setLength(0);
            } else if (Character.isDigit(arr[i])) {
                int[] tuple = getNumber(arr, i, n);
                int cnt = tuple[0];
                i = tuple[1];
                Map<String, Integer> local_counts = multi_level_counts.peek();
                String atom = atoms.pop();
                local_counts.put(atom, local_counts.getOrDefault(atom, 0) + cnt);
                addAtomNotFollwedByNum(multi_level_counts, atoms);
            } else if (arr[i] == '(') {
                addAtomNotFollwedByNum(multi_level_counts, atoms);
                multi_level_counts.push(new HashMap());
            } else if (arr[i] == ')') {
                addAtomNotFollwedByNum(multi_level_counts, atoms);
                int factor = 1;
                if (i+1 < n && Character.isDigit(arr[i+1])) {
                    int[] tuple = getNumber(arr, i+1, n);
                    factor = tuple[0];
                    i = tuple[1];
                }
                Map<String, Integer> local_counts = multi_level_counts.pop();
                Map<String, Integer> upper_counts = multi_level_counts.peek();
                for (String atom: local_counts.keySet()) {
                    int cnt = local_counts.get(atom);
                    upper_counts.put(atom, upper_counts.getOrDefault(atom, 0) + cnt * factor);
                }
            }
            i++;
        }
        addAtomNotFollwedByNum(multi_level_counts, atoms);
        Map<String, Integer> counts = multi_level_counts.pop();
        List<Node> nodes = new ArrayList();
        for (String atom: counts.keySet()) 
            nodes.add(new Node(atom, counts.get(atom)));
        Collections.sort(nodes);
        for (Node node: nodes)
            res.append(node.toString(sb));
        return res.toString();
    }
    
    // return (number, pointer)
    private int[] getNumber(char[] arr, int i, int n) {
        int cnt = 0;
        while (i < n && Character.isDigit(arr[i])) {
            cnt = cnt * 10 + (arr[i] - '0');
            i++;
        }
        return new int[] {cnt, i-1};
    }
    
    // adding atoms that are not followed up by a number 
    private void addAtomNotFollwedByNum(Stack<Map<String, Integer>>multi_level_counts, Stack<String> atoms) {
        Map<String, Integer> counts = multi_level_counts.peek();
        while (atoms.size() > 0) {
            String atom = atoms.pop();
            counts.put(atom, counts.getOrDefault(atom, 0) + 1);
        }
    }
}

class Node implements Comparable<Node>{
    String atom;
    int cnt;
    
    public Node (String a, int c) {
        atom = a;
        cnt = c;
    }
    
    public int compareTo(Node o) {
        return atom.compareTo(o.atom);
    }
    
    public String toString(StringBuilder sb) {
        sb.setLength(0);
        sb.append(atom);
        if (cnt > 1)
            sb.append(cnt);
        return sb.toString();
    }
}
