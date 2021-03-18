//用两个栈实现队列
/*
* 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail和deleteHead,分别，
* 完成在队列尾部插入节点和在队列头部删除节点删除*/

import java.util.EmptyStackException;
import java.util.Stack;

class  Queue{   //创建两个栈 stack1 和 stack2
    public Stack<Integer> stack1 = new Stack<Integer>();
    public Stack<Integer> stack2 = new Stack<Integer>();
    public int deleteHead(){
        if(stack2.size()==0) {    //如果要出队列，那么就是stack1的最底部元素
            while (stack1.size() > 0) {
                int res = stack1.peek();
                stack1.pop();
                stack2.push(res);
            }
        }  //将stack1中的元素peek到stack2中 ，那么当stack1为空的时候，stack2中的栈顶元素就是出队的第一个元素；

            if(stack2.size()<=0)
               throw  new EmptyStackException();//stack2如果为空时，报出异常；
                int queue = stack2.peek();
                stack2.pop();
                return queue;
        }
    public void appendTail(int a){
         stack1.push(a);
    }
}
public class Demo {

    public static void main(String[] args) {
    Queue queue = new Queue();
    queue.appendTail(1);
    queue.appendTail(2);
    queue.appendTail(3);
    queue.appendTail(5);
    queue.appendTail(6);
    queue.appendTail(7);
    queue.appendTail(8);
    queue.appendTail(9);

 /* while (queue.stack1.size()>0){
         int res = queue.stack1.peek();
         queue.stack1.pop();
        System.out.print(res+" ");
    }*/
        System.out.print("出队：");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead()+" ");
        System.out.print(queue.deleteHead());
    }
}
