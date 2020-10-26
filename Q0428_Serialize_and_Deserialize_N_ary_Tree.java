/**
 * Created by csy99 on 10/25/20.
 */

public class Solution {
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) return "";
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(Node root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        sb.append(root.children.size()).append(",");
        for (Node child: root.children)
            serializeHelper(child, sb);
    }
    
    public Node deserialize(String data) {
        if (data.isEmpty()) return null;
        String[] tmp = data.split(",");
        Queue<String> q = new LinkedList(Arrays.asList(tmp));
        return construct(q);
    }
    
    private Node construct(Queue<String> q) {
        if (q.size() == 0) return null;
        int val = Integer.parseInt(q.poll());
        int size = Integer.parseInt(q.poll());
        Node root = new Node(val);
        for (int i = 0; i < size; i++) 
            root.children.add(construct(q));
        return root;
    }
}
