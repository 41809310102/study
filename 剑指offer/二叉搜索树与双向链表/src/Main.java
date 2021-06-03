 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}


public class Main {

   static   TreeNode head = null;
   static TreeNode realHead = null;
    public static void main(String[] args) {

        //创建一个二叉搜索树；
        TreeNode a = new TreeNode(10);
        TreeNode a1 = new TreeNode(6);
        TreeNode a2 = new TreeNode(14);
        TreeNode a3 = new TreeNode(4);
        TreeNode a4 = new TreeNode(8);
        TreeNode a5 = new TreeNode(12);
        TreeNode a6 = new TreeNode(16);
        a.left = a1;a.right=a2;a1.left = a3;a1.right=a4;a2.left=a5;a2.right=a6;
        TreeNode head =   Convert(a);
        while (head!=null){
            System.out.print(head.val+" ");
            break;
        }


    }

    //直接用中序遍历


        public static TreeNode Convert(TreeNode pRootOfTree) {
            ConvertSub(pRootOfTree);
            return realHead;
        }

        private static  void ConvertSub(TreeNode pRootOfTree) {
            if(pRootOfTree==null) return;
            ConvertSub(pRootOfTree.left);
            if (head == null) {
                head = pRootOfTree;
                realHead = pRootOfTree;
            } else {
                head.right = pRootOfTree;
                pRootOfTree.left = head;
                head = pRootOfTree;
            }
            ConvertSub(pRootOfTree.right);
        }
}
