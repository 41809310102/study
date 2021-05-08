


//先定义一个二叉树
class  Tree{
    public  int val;
    public  Tree left;
    public  Tree right;

    public Tree(int val) {
        this.val = val;
    }
}




public class Demo {
    public static void main(String[] args) {
        Tree a= new Tree(8);
        Tree b= new Tree(8);
        Tree c= new Tree(7);
        Tree d= new Tree(9);
        Tree e= new Tree(2);
        Tree f= new Tree(4);
        Tree g= new Tree(7);
        a.left = b;
        a.right=c;
        b.left = d;
        b.right = e;
        e.left = f;
        e.right =g;

        Tree a1 = new Tree(2);
        Tree a2 = new Tree(9);
        Tree a3 = new Tree(1);
        a1.left = a2;
        a1.right =a3;
        System.out.println(HasTree1(a, a1));
    }

    public  static   boolean HasTree1(Tree tree1,Tree tree2){
        boolean flag = false;
        if(tree1!=null&&tree2!=null){
            if(tree1.val == tree2.val){
                flag = HasTree2(tree1,tree2);
            }
            if(!flag){
                flag = HasTree1(tree1.left,tree2);
            }
            if(!flag){
                flag = HasTree1(tree1.right,tree2);
            }
        }
        return flag;
    }
//判断树1中以R为根节点的子树是不是和树具有相同的结点。
    private static boolean HasTree2(Tree tree1, Tree tree2) {
        if(tree2==null){
            return  true;
        }
        if(tree1==null){
            return false;
        }
        if(!(tree1.val == tree2.val)){
            return false;
        }
        return HasTree2(tree1.left,tree2.left)&&HasTree2(tree1.right ,tree2.right);
    }
}
