
class Tree{
    public  int var ;
    public  Tree left;
    public Tree right;

    public Tree() {

    }


    public Tree(int var) {
        this.var = var;
    }

    public Tree createTion(){
        Tree a = new Tree(8);
        Tree b = new Tree(6);
        Tree c = new Tree(6);
        Tree d = new Tree(5);
        Tree e = new Tree(7);
        Tree f = new Tree(7);
        Tree g = new Tree(5);
        a.left = b;
        a.right =c;
        b.left = d;
        b.right=e;
        c.left =f;
        c.right=g;
        return a;
    }

}

public class Main {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Tree tree1= tree.createTion();
        System.out.println(isSymmertical(tree1));
    }

    public static boolean isSymmertical(Tree a){
        return isSymmertical(a,a);
    }

    public static boolean isSymmertical(Tree a,Tree b) {
        if(a==null&&b==null){
            return true;
        }else if(a==null||b==null) {
            return false;
        }
        if(a.var!=b.var){
            return false;
        }
        return  isSymmertical(a.left,b.right)&&isSymmertical(a.right,b.left);

    }

}
