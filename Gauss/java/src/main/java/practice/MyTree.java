package practice;

/**
 * Created by neerbans on 6/15/2017.
 */
public class MyTree {

    private int result = 0;
    private int minDepth = Integer.MAX_VALUE;

    public static void main (String [] args) {

        MyTree obj = new MyTree();
        TreeNode node = obj.createTree();
        System.out.println(obj.minDepth(node));
//        System.out.println(obj.pathSum(node, 13));
    }

    private int minDepth(TreeNode node) {
        getMinDepth(node, 1);
        return minDepth;
    }

    private void getMinDepth(TreeNode node, int d) {
        if (node != null) {
            if (node.right == null && node.left == null) {
                if (d < minDepth) {
                    minDepth = d;
                }
            }
            getMinDepth(node.left, d+1);
            getMinDepth(node.right, d+1);
        }
    }

    private int pathSum(TreeNode node, int sum) {
        getPathSum(node, 0, sum);
        return result;
    }

    private void getPathSum(TreeNode node, int s, int sum) {
        if (node != null) {
            s = s + node.val;
//            System.out.println(s);
            if (s == sum && node.left == null && node.right == null) {
                result = 1;
            } else {
                getPathSum(node.left, s, sum);
                getPathSum(node.right, s, sum);
            }
        }
    }

    private TreeNode createTree() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(3);
        node.right = new TreeNode(5);
        node.left.left = new TreeNode(7);
        node.left.right = new TreeNode(9);
        node.right.left = new TreeNode(11);
        node.right.right = new TreeNode(13);
        return node;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x;}
}
