import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    
    public int[][] solution(int[][] nodeinfo) {
        int len = nodeinfo.length;
        int[][] answer = new int[2][len];

        Node[] nodes = new Node[len];
        for(int i=0;i<len;i++) {
            nodes[i] = new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]);
        }
        Arrays.sort(nodes, (a, b) -> {
            if (a.y == b.y) return a.x - b.x;
            return b.y - a.y;
        });

        Node root = nodes[0];
        for(int i=1;i<len;i++) addNode(root, nodes[i]);

        List<Integer> preList = new ArrayList<>();
        List<Integer> postList = new ArrayList<>();

        preorder(preList, root);
        postorder(postList, root);

        for(int i=0;i<len;i++) {
            answer[0][i] = preList.get(i);
            answer[1][i] = postList.get(i);
        }

        return answer;
    }
    
    public void addNode(Node parent, Node child) {
        if(child.x < parent.x) {
            if(parent.left == null) parent.left = child;
            else addNode(parent.left, child);
        }else {
            if(parent.right == null) parent.right = child;
            else addNode(parent.right, child);
        }
    }

    public void preorder(List<Integer> list, Node node) {
        if(node == null) return;
        list.add(node.index);
        preorder(list, node.left);
        preorder(list, node.right);
    }

    public void postorder(List<Integer> list, Node node) {
        if(node == null) return;
        postorder(list,node.left);
        postorder(list,node.right);
        list.add(node.index);
    }

    class Node {
        int x, y, index;
        Node left, right;

        public Node(int index, int x, int y) {
            this.index = index;
            this.x = x;
            this.y = y;
        }
    }
}