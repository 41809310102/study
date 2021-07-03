import  java.util.*;
 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }
}
public class Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(dp(root.left)-dp(root.right))>1) return false;
        return IsBalanced_Solution(root.right)&&IsBalanced_Solution(root.left);
    }

    public int dp(TreeNode root){
        if(root==null) return 0;
        return Math.max(dp(root.left),dp(root.right))+1;
    }
}
