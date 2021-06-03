class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

}


public class Main {
    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode node1 = new RandomListNode(2);
        RandomListNode node2= new RandomListNode(3);
        RandomListNode node3 = new RandomListNode(4);
        RandomListNode node4= new RandomListNode(5);
        head.next =node1;
        node1.next = node2;
        node2.next = node3;
        node3.next=node4;
        head.random = node2;
        node1.random = node4;
        RandomListNode node = Clone(head);
        while (node!=null){
            System.out.print(node.label+" ");
         if(node.random!=null){
             System.out.println("指向"+node.random.label);
         }
            node = node.next;
        }


    }

    public  static  RandomListNode Clone(RandomListNode pHead) {
             CloneNodes(pHead);
             ConnectsitNodes(pHead);
             return  chose(pHead);
    }

    //第一步：把复制得N‘ 放在N后
    public  static void CloneNodes(RandomListNode head){
        RandomListNode node = head;
        while (node!=null){
            RandomListNode clond = new RandomListNode(0);
            clond.label = node.label;
            clond.next = node.next;
            clond.random = null;
            node.next = clond;
            node = clond.next;
        }
    }

    //第二步设置复制出来的结点的random
    public  static void ConnectsitNodes(RandomListNode head){
        RandomListNode node = head;
        while (node!=null){
            RandomListNode clond = node.next;
            if(node.random!=null){
                clond.random = node.random.next;
            }
            node = clond.next;
        }

    }
    //把长链表拆分成两个链表，把奇数位置的节点和偶数位置上节点用next链接起来
    public  static RandomListNode chose(RandomListNode head){
        RandomListNode node = head;
        RandomListNode pclondhead = null;
        RandomListNode pclondnode = null;
        if(node!=null){
            pclondhead = pclondnode = node.next;
            node.next = pclondnode.next;
            node = node.next;
        }
        while(node!=null){
            pclondnode.next = node.next;
            pclondnode = pclondnode.next;
            node.next = pclondnode.next;
            node = node.next;
        }
        return pclondhead;
    }

}
