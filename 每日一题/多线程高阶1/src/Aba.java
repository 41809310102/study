import java.util.concurrent.atomic.AtomicReference;

public class Aba {
    //ABA问题的演示

    private  static AtomicReference money = new AtomicReference(100);//转账


    public static void main(String[] args) {
        //转账线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
               boolean result =  money.compareAndSet(100,0);
                System.out.println("点击第一次转出100"+result);
            }
        });
        t1.start();
        //转账线程2
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
               boolean result =  money.compareAndSet(100,0);
                System.out.println("点击第二次转出100"+result);
                if(!result){
                    System.out.println("余额不足，无法转账！");
                }
            }
        });
        t2.start();


    }
}
