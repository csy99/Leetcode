/**
 * Created by csy99 on 8/24/21.
 */
 /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node par1 = p;
        Node par2 = q;
        Set<Node> seen = new HashSet();
        while (par1 != null && par2 != null) {
            if (seen.contains(par1)) return par1;
            seen.add(par1); 
            if (seen.contains(par2)) return par2;
            seen.add(par2);
            par1 = par1.parent;
            par2 = par2.parent;
        }
        while (par1 != null) {
            if (seen.contains(par1)) return par1;
            seen.add(par1); 
            par1 = par1.parent;
        }
        while (par2 != null) {
            if (seen.contains(par2)) return par2;
            seen.add(par2);
            par2 = par2.parent;
        }
        return null;
    }
    
}
