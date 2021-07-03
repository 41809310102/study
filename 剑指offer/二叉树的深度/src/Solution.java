
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
    public static void main(String[] args) {

    }
    //递归
    public int TreeDepth(TreeNode root) {
        if(root==null) return 0;
        return (Math.max(TreeDepth(root.left),TreeDepth(root.right))+1);
    }
    //非递归
    public  int TreeDepth1(TreeNode root){
        if(root==null) return  0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int ros = 0;
        int count=0;
        while (!queue.isEmpty()){
            int res = queue.size();
            while (res!=0){
                TreeNode node = queue.poll();
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                res--;
            }
            count++;
        }
        return count;
    }

}
