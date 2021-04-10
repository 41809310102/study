//定义二叉树
class NodeTree{
    public  int val;
    public  NodeTree leftchild;
    public  NodeTree rightchild;

    public NodeTree(int val) {
        this.val = val;
    }

    public NodeTree() {

    }

    public  NodeTree Create(){
        NodeTree a = new NodeTree(8);
        NodeTree b = new NodeTree(8);
        NodeTree c = new NodeTree(7);
        NodeTree d = new NodeTree(9);
        NodeTree e = new NodeTree(2);
        NodeTree f = new NodeTree(4);
        NodeTree g = new NodeTree(7);
        a.leftchild = b;
        a.rightchild = c;
        b.leftchild = d;
        b.rightchild=e;
        e.leftchild = f;
        e.rightchild =g;
        return  a;
    }

    public  NodeTree Createchild(){
        NodeTree a = new NodeTree(8);
        NodeTree b = new NodeTree(9);
        NodeTree c = new NodeTree(2);

        a.leftchild = b;
        a.rightchild = c;
        return  a;
    }
}


public class Demo {
    public static void main(String[] args) {
 NodeTree node = new NodeTree();
 Demo sb = new Demo();
        System.out.println(sb.Doestree(node.Create(), node.Createchild()));

    }
//先确定根结点的值是否相等
    public  boolean  Rootequal( NodeTree root , NodeTree root1){
        Boolean result = false;
        if(root!=null&& root!=null){
            if(root.val == root1.val){
                result = Doestree(root,root1);
            }
            if(!result){
                result = Doestree(root.leftchild,root1);
            }
            if(!result){
                result = Doestree(root.rightchild,root1);
            }
        }
        return  result;
    }

    public  boolean  Doestree(NodeTree root,NodeTree root1){

        if(root1==null){
            return  true;
        }
        if(root==null){
            return  false;
        }
        if(root.val!=root1.val){
            return false;
        }
        return Doestree(root.leftchild,root1.leftchild)&& Doestree(root.rightchild,root1.rightchild);
    }

}
