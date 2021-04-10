
//创建单链表
class ListNode{
    public int  val;
    public ListNode next;
//有参构造
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode() {

    }
  //创建第一个单链表
  public  ListNode CreateList1(){
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(7);
        ListNode e = new ListNode(9);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        return a;
    }


    public  ListNode CreateList2(){
        ListNode A = new ListNode(2);
        ListNode B= new ListNode(4);
        ListNode C= new ListNode(6);
        ListNode D = new ListNode(8);
        ListNode E = new ListNode(10);
        A.next=B;
        B.next=C;
        C.next=D;
        D.next=E;
        return A;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class Demo {

    public static void main(String[] args) {
        ListNode sb = new ListNode();
        sb.CreateList1();
        sb.CreateList2();
        Demo demo = new Demo();
        ListNode res;
        res = demo.Found(sb.CreateList1(), sb.CreateList2());
        System.out.println(res.toString());

    }
//递归实现
    public  ListNode  Found(ListNode node1 , ListNode node2){

        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        ListNode head = null;
        if(node1.val<node2.val){
            head = node1;
            head.next = Found(head.next,node2);
        }else{
            head = node2;
            head.next = Found(node1,head.next);
        }
        return head;
    }

}
