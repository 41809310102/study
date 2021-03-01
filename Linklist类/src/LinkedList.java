//LinkedList本质上是链表，此次只是实现了LinkedList里面几个基础简单的方法，为了便于理解LinkedList
class Node{
    public Node prev;
    public Node next;
    public Object var;
    public Node first;
    public Node last;
    public  int size;

    public Node(Node prev, Node next, Object var) {
        this.prev = prev;
        this.next = next;
        this.var = var;
    }

    public Node(Object var) {
        this.var = var;
    }
    public Node() {

    }
    //判断是不是合法；
    public  void checkIndex(int index){
        if (index<0||index>this.size){
            throw new RuntimeException("检索不合法！"+index);
        }
    }
    //getNode(),getNode(int index)：获得索引处的节点，当索引小于长度的一半时，从前面开始查找，当索引大于长度的一半时，从后面开始查找。
    public Node getNode(int index){
        Node res=null;
        int n=(this.size/2);
        if(index<=n){
            res = first;
            for (int i =0;i<index;i++){
                res=res.next;
            }
        }else{
            res = last;
            for (int i =this.size-1;i>index;i--){
                res = res.prev;
            }
        }
        return  res;
    }

    //get(int index)：获得索引处节点的数据，检查索引是否合法，调用getNode()获得索引处的节点，返回节点的数据。
    public Object get(int index){
        checkIndex(index);
        Node tmp =getNode(index);
        return tmp.var;
    }

    //add(E element)：在容器最后添加一个对象，如果容器内没有对象，直接将头指针，尾指针都指向新建的节点，size++。
    public  void add(Object data){
        Node cur = new Node(data);
       if (first==null){
            first= cur;
            last=cur;
        }
        cur.prev=last;
        cur.last=null;
        last.next=cur;
        last =cur;
        size++;
    }

    //add(E element,int index)：在指定索引处添加一个对象（如果容器内没有对象则抛出异常），
    // 调用getNode()获得索引处的节点，让down指向它，让up等于索引出前一个节点，之后让新节点的previous，
    // next分别指向up和down，up.next，down.previous都指向新节点，最后size++;

    public  void  add(Object data,int index){
        Node node = new Node(data);
        checkIndex(index);
        Node down = getNode(index);
        Node up =down .prev;
        down.prev = node;
        node.next =down;
        if(up != null)
            up.next = node;
        else
            first = node;
            size++;
    }
    //remove()
    //从容器中移除索引位置处的节点（对象本身并未删除）。首先检查索引是否合法，然后调用getNode()获得索引处的节点，up指向上一个节点，down指向下一个节点。
    //
    //如果up为null，则这个节点是头节点，移除的话直接将头指针指向dwon,down的previous等于null
    //如果down为null，则这个节点是尾节点，移除的话直接将尾指针指向up，up的next等于null
    //其他情况，up的下一个指向down，down的上一个指向up
    //size减一
    public  void remove(int index){
        checkIndex(index);
        Node up = getNode(index).prev;
        Node down = getNode(index).next;
        if (up==null){
            first = down;
            down.prev=null;
        }
        if (down == null){
            last = up;
            up.next=null;
        }
        up.next = down;
        down.prev =up;
        size--;
    }

    @Override
    public String toString() {
        return "Node{" +
                ", var=" + var +
                '}';
    }
}
