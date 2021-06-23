import java.util.Scanner;

public class DeomTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
BTNode btNode = new BTNode();
BTNode root= btNode.createTree1();
BTNode root2= btNode.createTree1();

System.out.print("前序遍历:");
btNode.preOrderTraversal(root);
        System.out.println();
System.out.print("中序遍历:");
btNode.inOrderTraversal(root);
        System.out.println();
System.out.print("后序遍历:");
btNode.postOrderTraversal(root);
        System.out.println();
        System.out.print("(非)前序遍历:");
        btNode.preOrderTraversal1(root);
        System.out.println();
        System.out.print("（非）中序遍历:");
        btNode.inOrderTraversal1(root);
        System.out.println();
        System.out.print("（非）后序遍历:");
        btNode.postOrderTraversal1(root);
        System.out.println();
        System.out.println(btNode.isCompleteTree(root));
       /* System.out.println();
        System.out.print("结点个数:");
        btNode.getSize1(root);
        System.out.println(BTNode.size);
        System.out.println("-----------");
        System.out.print("递归取得结点个数:");
        System.out.println(btNode.getSize2(root));
            System.out.println("-----------");
            System.out.print("叶子结点个数:");
            btNode.getLeafSize1(root);
            System.out.println(BTNode.leafSize);
            System.out.println("-----------");
            System.out.print("递归叶子结点个数:");
            System.out.println(btNode.getLeafSize2(root));
          /* System.out.println("-----------");
            System.out.print("输入第k层:");
            Scanner scanner = new Scanner(System.in);
            int k = scanner.nextInt();
            System.out.println(btNode.getKLevelSize(k,root));*/
           /* System.out.println("-----------");
            System.out.print("查找 val 所在结点:");
            BTNode res = btNode.find(root,'A');
            System.out.println(btNode.value);
            System.out.println("-----------");
            System.out.print("树的高度：");
            System.out.println(btNode.getHeight(root));*/
    }
}
