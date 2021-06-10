public class Node {

        public  int val;
        public Node next;


        public Node(){

        }
        public Node(int val) {
            this.val = val;
        }
        //创建链表
        public Node create(){
            Node a = new Node(15);
            Node a1 = new Node(25);
            Node a2 = new Node(35);
            Node a3 = new Node(45);
            a.next = a1;
            a1.next=a2;
            a2.next=a3;
            return a;
        }
        //头插
        public void addFirst(int data){
            Node head = new Node(data);
        }
        //尾插法
        public void addLast(int data){

        }
        //任意位置插入,第一个数据节点为0号下标
        public boolean addIndex(int index,int data){
            return false;
        }
        //查找是否包含关键字key是否在单链表当中
        public boolean contains(int key){
            return false;
        }
        //删除第一次出现关键字为key的节点
        public void remove(int key){

        }
        //删除所有值为key的节点
        public void removeAllKey(int key){

        }
        //得到单链表的长度
        public int size(){
            return 0;
        }
        public void display(Node node){
            if(node==null) return;
            while (node!=null){
                System.out.print(node.val+" ");
                node = node.next;
            }
        }

        public void clear(){

        }



    }




