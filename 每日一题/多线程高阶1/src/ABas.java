import java.util.concurrent.atomic.AtomicReference;

public class ABas {

    private  static AtomicReference money = new AtomicReference(100);//转账


    public static void main(String[] args) throws InterruptedException {
        //转账出线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(100,0);
                System.out.println("第一次"+result);
            }
        });
        t1.start();
        t1.join();
        //转入100
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(0,100);
                System.out.println("转账"+result);
            }
        });
        t3.start();
        //转账线程2
        t3.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(100,0);
                System.out.println("第二次"+result);
            }
        });
        t2.start();


    }
}
