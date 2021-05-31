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

    }



    public boolean VerifySquenceOfBST(int [] sequence) {
        int len=sequence.length;
        return VerifySquenceOfBST(sequence,len);
    }

    private  static  boolean VerifySquenceOfBST(int [] sequence,int len) {
      if(len<=0||sequence==null) return false;
      //先取数组最后的一个元素，该元素是二叉树的根；
        int root = sequence[len-1];
        int i =0;
        for(;i<len-1;i++){
            if(sequence[i]>root) {
                return  false;
            }
        }

        //在二叉树中右树节点是大于根节点的值
        int j =i;
        for(;j<len-1;j++){
            if(sequence[j]<root){
                return false;
            }
        }
        //判断左树是不是二叉搜索树
        boolean left = true;
        if(i>0){
            left = VerifySquenceOfBST(sequence,i);
        }
        //判断右子树是不是二叉搜索树
        boolean right = true;
        if(i<len-1)
            right = VerifySquenceOfBST(sequence,len-i-1);
        return  (left&&right);

    }
}
