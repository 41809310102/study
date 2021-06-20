
import java.util.*;
class TreeNode {
   int val = 0;
   TreeNode left = null;
   TreeNode right = null;
 }
public class Main {
    public int[][] threeOrders (TreeNode root) {
        //调用先序遍历
        TreeNode a = root;
        List<Integer> preList = new ArrayList<Integer>();
        preList = preorderTraversal(a);
        int preRes[] = new int[preList.size()];
        for(int o = 0; o < preList.size(); o++){
            preRes[o] = preList.get(o);
        }

        //调用中序遍历
        TreeNode b = root;
        List<Integer> inList = new ArrayList<Integer>();
        inList = inorderTraversal(b);
        int inRes[] = new int[inList.size()];
        for(int p = 0; p < inList.size(); p++){
            inRes[p] = inList.get(p);
        }

        //调用后序遍历
        TreeNode c = root;
        List<Integer> postList = new ArrayList<Integer>();
        postList = postorderTraversal(c);
        int postRes[] = new int[postList.size()];
        for(int q = 0; q < postList.size(); q++){
            postRes[q] = postList.get(q);
        }

        //整理输出结果
        int result[][] = {preRes, inRes, postRes};

        return result;
    }

    //先序遍历(递归)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(root, res);
        return res;
    }

    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    //中序遍历(递归)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }

    //后序遍历(递归)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public static void postorder(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
}