//二叉树，孩子表示法

import java.util.LinkedList;
import java.util.Stack;

/**
 1. NLR：前序遍历(Preorder Traversal 亦称先序遍历)——访问根结点--->根的左子树--->根的右子树。
 2. LNR：中序遍历(Inorder Traversal)——根的左子树--->根节点--->根的右子树。
 3. LRN：后序遍历(Postorder Traversal)——根的左子树--->根的右子树--->根节点。
 */


public class BTNode {
    public Object value;
    public BTNode leftchild;
    public BTNode rightchild;

    public BTNode() {
    }

    public BTNode(Object value) {
        this.value = value;
    }

    public  BTNode createTree1(){
        BTNode A = new BTNode('A');
        BTNode B = new BTNode('B');
        BTNode C = new BTNode('C');
        BTNode D = new BTNode('D');
        BTNode E = new BTNode('E');
        BTNode F = new BTNode('F');
        BTNode G = new BTNode('G');
        BTNode H = new BTNode('H');
        A.leftchild = B;
        A.rightchild =C;
        B.leftchild = D;
        B.rightchild =E;
        E.rightchild= H;
        C.rightchild =G;
        C.leftchild= F;
        return  A;
    }
    // 前序遍历
     public  void preOrderTraversal(BTNode root){
       if (root == null){
           return;
       }
         System.out.print(root.value);
         preOrderTraversal(root.leftchild);
         preOrderTraversal(root.rightchild);

     }
    // 中序遍历
    public  void inOrderTraversal(BTNode root){
        if (root == null){
            return;
        }
        inOrderTraversal(root.leftchild);
        System.out.print(root.value);
        inOrderTraversal(root.rightchild);
       }


    // 后序遍历
    public  void postOrderTraversal(BTNode root){

        if (root == null){
            return;
        }
        postOrderTraversal(root.leftchild);
        postOrderTraversal(root.rightchild);
        System.out.print(root.value);

    }
    // 前序遍历
    void preOrderTraversal1(BTNode  root){
   if (root==null){
       return;
   }
        Stack<BTNode> stack = new Stack<BTNode>();
   BTNode cur = root;
   while (cur!=null||!stack.isEmpty()) {
       while (cur != null) {
           stack.push(cur);
           System.out.print(cur.value);
           cur = cur.leftchild;
       }
       BTNode top = stack.pop();
       cur = top.rightchild;
   }
    }
    // 中序遍历
    void inOrderTraversal1(BTNode root){
        if (root==null){
            return;
        }
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode cur = root;
        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftchild;
            }
            BTNode top = stack.pop();
            System.out.print(top.value);
            cur = top.rightchild;
        }
    }
    // 后序遍历
    void postOrderTraversal1(BTNode  root){
        if (root==null){
            return;
        }
        Stack<BTNode> stack = new Stack<BTNode>();
        BTNode cur = root;
        BTNode prev= null;
        while (cur!=null||!stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.leftchild;

            }
            BTNode top = stack.peek();
            if(top.rightchild==null||top.rightchild ==prev){
                top = stack.pop();
                System.out.print(top.value);
                prev = top;
                    }else{
                cur = top.rightchild;
            }

        }
    }
    // 遍历思路-求结点个数
    static int size = 0;
    void getSize1( BTNode root){
     if (root!=null){
         size++;
         getSize1(root.leftchild);
         getSize1(root.rightchild);
     }
    }


    // 子问题思路-求结点个数
    int getSize2( BTNode root){
        if (root ==null) {return 0;}

        return getSize2(root.leftchild) + getSize2(root.rightchild) + 1;
    }


    // 遍历思路-求叶子结点个数
    static int leafSize = 0;
    void getLeafSize1( BTNode  root){
        if (root == null){
            return;
        }
        if (root.leftchild==null && root.rightchild==null){
            leafSize++;
        }
        getLeafSize1(root.leftchild);
        getLeafSize1(root.rightchild);
    }


    // 子问题思路-求叶子结点个数
    int getLeafSize2( BTNode  root){
        if (root ==null) {return 0;}
        if (root.leftchild==null && root.rightchild==null){
           return 1;
        }
        return getLeafSize2(root.leftchild) + getLeafSize2(root.rightchild) ;
    }


    // 子问题思路-求第 k 层结点个数
    int getKLevelSize( int k,BTNode  root){
    if (root ==null){
        return 0;
    }
     if (k==1){
         return 1;
     }
      return getKLevelSize(k-1,root.leftchild)+getKLevelSize(k-1,root.rightchild);
      }



    // 获取二叉树的高度
    int getHeight( BTNode  root){
        if (root == null){
            return 0;
        }
        int left = getHeight(root.leftchild);
        int right=getHeight(root.rightchild);
        if( left >right){
            return left+1;
        }else{
            return right+1;
        }
    }
    // 查找 val 所在结点，没有找到返回 null
// 按照 根 -> 左子树 -> 右子树的顺序进行查找
// 一旦找到，立即返回，不需要继续在其他位置查找
    BTNode find(BTNode  root, Object val){
        if (root == null){
            return null;
        }
        if (root.value == val){
            System.out.println("找到了");
            return root;
        }
        BTNode ret = find(root.leftchild,val);
            if (ret!=null){
            return ret;
        }
        ret = find(root.rightchild,val);
        if (ret!=null){
            return ret;
        }
        return null;
    }
    //给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
    public BTNode mergeTrees(BTNode t1, BTNode t2) {
        if(t1 == null)
            return t2;
        if(t2 == null)
            return t1;
      //  t1.value= t1.value + t2.value;
        t1.leftchild= mergeTrees(t1.leftchild,t2.leftchild);
        t1.rightchild = mergeTrees(t1.leftchild,t2.leftchild);
        return t1;
    }
    //给定两个二叉树，编写一个函数来检验它们是否相同。
   /* public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p!=null&&q!=null&&p.val==q.val){
            return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }else{
            return false;
        }


    }*/
//给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。
// s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。

    /*public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s==null||t==null){
            return false;
        }
        if(isSameTree(s,t)) return true;
        if(isSubtree(s.left,t)) return true;
        if(isSubtree(s.right,t)) return true;
        return false;
    }*/
    // 判断一棵树是不是完全二叉树
    public boolean isCompleteTree(BTNode root) {
        LinkedList<BTNode > link = new LinkedList<>();
        BTNode cur;
        link.addLast(root);
        while((cur=link.removeFirst())!=null){
            link.addLast(cur.leftchild);
            link.addLast(cur.rightchild);
        }
        while(!link.isEmpty()){
            if(link.removeLast()!=null){
                return false;
            }
        }
        return true;
    }
}
