
//定义一个链表
  class  List{
    public  int var;
    public  List next;
//有参构造
    public List(int var) {
        this.var = var;
    }
//无参构造
    public List() {

    }
    //创建一个带环的链表
    public  List Create(){
        List a = new List(1);
        List b = new List(2);
        List c = new List(3);
        List d = new List(4);
        List e = new List(5);
        List f = new List(6);
        a.next = b;
        b.next =c;
        c.next = d;
        d.next =e;
        e.next = f;
        f.next =d; //入口节点值为4
        return  a;
    }
    //判断是否有环，并找到相遇的节点
    public  List MeetingNode(List node){
        List slow = new List();
        List fast = new List();
        if(node==null) return  null;
        slow = node.next;
        if(slow==null) return  null;
        fast=slow.next;
        while (fast!=null && slow!=null){
            if (fast==slow){
                return fast; //fast追上了slow，确定是一个有环的链表；
            }
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
       return null;
    }

    public  List Enterdear(List node){
        if(node==null) return null;
        if(MeetingNode(node)==null) return null;
        int count =1;
        List res2;
        List res1 = MeetingNode(node);
        while (res1.next!=MeetingNode(node)){
            res1 = res1.next;
            count++;
        }
        res1 = node;
        for(int i = 0;i<count;i++){
            res1 =res1.next;
        }
        res2 = node;
        while (res1!=res2 && res1!=null && res2!=null){
            res1 = res1.next;
            res2 = res2.next;
        }
        return res1;
    }
}

public class Deom {

    public static void main(String[] args) {
       List SB = new List();
       List res = SB.Create();
       List dear= SB.Enterdear(res);
       System.out.println(dear.var);

    }


}
