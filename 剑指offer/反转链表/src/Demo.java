
//定义一个单链表
class ListNode{
    public  String  var;
    public  ListNode next;

    public ListNode(  String var) {
        this.var = var;
    }


    public ListNode() {

    }

    public  ListNode  Create(){
        ListNode a = new ListNode("a");
        ListNode b= new ListNode("b");
        ListNode c= new ListNode("c");
        ListNode d= new ListNode("d");
        ListNode e= new ListNode("e");
        ListNode f= new ListNode("f");
        ListNode g= new ListNode("g");
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next= f;
        f.next = g;
        return  a;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "var='" + var + '\'' +
                ", next=" + next +
                '}';
    }
}

public class Demo {
    public static void main(String[] args) {
        ListNode sb = new ListNode();
        Demo  demo = new Demo();
        System.out.println(demo.Changer(sb.Create()).toString());

    }
//反转链表的函数实现；
    public  ListNode Changer(ListNode node){
       ListNode band = null;
       ListNode nows = node;
       ListNode prev = null;
        while (nows!=null){
            ListNode next = nows.next;
            if(next == null)
                band = nows;
                nows.next = prev ;
                prev = nows;
                nows = next;
        }
    return  band;

    }
}
