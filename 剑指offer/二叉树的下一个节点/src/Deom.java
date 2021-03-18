import java.util.Scanner;

class Btree {
    public  Object val;
    public   Btree leftchild;
    public  Btree rightchild;
    public  Btree father;//指向父节点的指向；

    public Btree(Object val) {
        this.val = val;
    }
    public Btree() {

    }
}


public class Deom {
    public static void main(String[] args) {
        Btree node1=new Btree('a');
        Btree node2=new Btree('b');
        Btree node3=new Btree('c');
        Btree node4=new Btree('d');
        Btree node5=new Btree('e');
        Btree node6=new Btree('f');
        Btree node7=new Btree('g');
        Btree node8=new Btree('h');
        Btree node9=new Btree('i');
        //创建一个二叉树；
        node1.leftchild=node2;
        node1.rightchild=node3;
        node2.leftchild=node4;
        node2.rightchild=node5;
        node3.leftchild=node6;
        node3.rightchild=node7;
        node5.leftchild=node8;
        node5.rightchild=node9;
        //增加指向父节点的指向
        node2.father=node1;
        node3.father=node1;
        node4.father=node2;
        node5.father=node2;
        node6.father=node3;
        node7.father=node3;
        node8.father=node5;
        node9.father=node9;
        Deom sb =new Deom();
        sb.Found(node2);
        System.out.println(sb.Found(node1).val);
    }
    //中序遍历
    public  void  midfind(Btree n){
        if(n==null){ return;}
        Object res = n.val;
        midfind(n.leftchild);
        System.out.print(res);
        midfind(n.rightchild);
    }

    public Btree Found(Btree node){
        if(node==null) return null;
        if(node.rightchild!=null){
            if(node.rightchild.leftchild!=null) return node.rightchild.leftchild;
        }
        if(node.rightchild==null){
            if(node.father!=null&&node.father.leftchild==node){ return  node.father;}
        }
        if(node.rightchild==null&& node.father.rightchild==node){
            Btree res =new Btree();
            while(node.father==node.father.father.rightchild){
                node.father=node.father.father;
            }
            return node.father;
        }
        return null;
    }
}
