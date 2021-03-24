import java.util.Arrays;

class Btree{
    public  Object val;
    public  Btree leftchild;
    public  Btree rightchild;
    public Btree() {

    }
    public Btree(Object val) {
        this.val = val;
    }

    public Object getVal() {
        return val;
    }

    public void setVal(Object val) {
        this.val = val;
    }

    public Btree getLeftchild() {
        return leftchild;
    }

    public void setLeftchild(Btree leftchild) {
        this.leftchild = leftchild;
    }

    public Btree getRightchild() {
        return rightchild;
    }

    public void setRightchild(Btree rightchild) {
        this.rightchild = rightchild;
    }
}


public class Tree {
    public static void main(String[] args) {
        Btree tree1= new Btree(1);
        Btree tree2= new Btree(2);
        Btree tree3= new Btree(3);
        Btree tree4= new Btree(4);
        Btree tree5= new Btree(5);
        Btree tree6= new Btree(6);
        Btree tree7= new Btree(7);
        Btree tree8= new Btree(8);
       tree1.leftchild=tree2;
       tree1.rightchild=tree3;
       tree2.leftchild=tree4;
       tree3.leftchild=tree5;
       tree3.rightchild=tree6;
       tree4.rightchild=tree7;
       tree6.leftchild=tree8;
       Tree sb=new Tree();
        System.out.print("前序遍历是:");
        sb.Firstree(tree1);
        System.out.println();
        System.out.print("中序遍历是:");
        sb.Midtree(tree1);
        System.out.println();
       System.out.print("后序遍历是:");
       sb.lastree(tree1);
        System.out.println();
        System.out.println("-----------------");
        int[] first = {1,2,4,7,3,5,6,8};
        int[]  mid= {4,7,2,1,5,3,8,6};
        Btree res = new Btree();
        res = sb.reConstructBinaryTree(first,mid);
        System.out.print("重构后后序:");
        sb.lastree(res);
    }
/**
 * 1.前序遍历是 根—>左->右；
 * 2.后序遍历是 左->右->根；
 * 3.中序遍历是 左->根->右；
 */
//前序遍历递归
    public  void Firstree(Btree tree){
        if(tree==null) {
            return ;
        }
        Object res;
        res = tree.val;
        System.out.print(res);//先打印根
        Firstree(tree.leftchild);//再大印左根
        Firstree(tree.rightchild);//再打印右根=
    }
//后序遍历是 左->右->根；
    public  void lastree(Btree tree){
        if(tree==null) {
            return ;
        }
        Object res;
        res = tree.val;
        lastree(tree.leftchild);//再打印左根
        lastree(tree.rightchild);//再打印右根=
        System.out.print(res);//先打印根
    }

    public  void Midtree(Btree tree){
        if(tree==null) {
            return ;
        }
        Object res;
        Midtree(tree.leftchild);//再大印左根
        res = tree.val;
        System.out.print(res);//先打印根
        Midtree(tree.rightchild);//再打印右根
    }

    //重构二叉树 ，递归
    public  Btree  reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null)
            return null;
        if(pre.length == 0 || in.length == 0)
            return null;
        if(pre.length != in.length)
            return null;

        Btree  node = new  Btree (pre[0]);
        for(int i = 0 ; i < pre.length ; i++){
            if(pre[0] == in[i]){
                node.leftchild = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));//左子树
                node.rightchild = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));//右子树
            }
        }
        return node;
    }


}
