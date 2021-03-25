import java.util.Stack;

class listNode {
    public  int var ;
    public  listNode next;

    public listNode(int var) {
        this.var = var;
    }
}


public class Demo {
    public static void main(String[] args) {
        Demo sb = new Demo();
        listNode pNode = new listNode(0);
        pNode.next = sb.create();
        System.out.println(sb.Foundk(pNode, 1));

    }
    //构建一个链表
    public  listNode create(){
        listNode a = new listNode(1);
        listNode b = new listNode(2);
        listNode c = new listNode(3);
        listNode d = new listNode(4);
        listNode e = new listNode(5);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        return  a;
    }

//快慢指针法
    public  listNode Findk(int k,listNode node){
        int currentIndex = 0;
        listNode first = node;
        listNode second = node;

        if (node== null) {
            return null;
        }
        while (currentIndex < k && first != null ) {
            first = first.next;
            currentIndex++;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        if (currentIndex < k) {
            return null;
        }
        return second;
    }


    //栈实现，时间和空间复杂对都很高
    public  int Foundk(listNode node ,int k){
        if(node==null || k<=0) return -1;
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (node!=null){
            count++;
            stack.push(node.var);
            node = node.next;

        }
        if(k==1) return  stack.pop();
        int res =0;
        while (k-1>0){
             res = stack.pop();
              k--;
        }
        return res;
    }

}
