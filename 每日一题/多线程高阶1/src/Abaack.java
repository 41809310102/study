import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Abaack {

    //private  static AtomicReference money = new AtomicReference(100);//转账
private  static AtomicStampedReference money = new AtomicStampedReference(100,1);


//
    public static void main(String[] args) throws InterruptedException {
        //转账出线程1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(100,0,1,2);
                System.out.println("第一次转账100："+result);
            }
        });
        t1.start();
        t1.join();
        //转入100
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(0,100,2,3);
                System.out.println("其他人给你转账了100："+result);
            }
        });
        t3.start();
        //转账线程2
        t3.join();
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                boolean result =  money.compareAndSet(100,0,1,2);
                System.out.println("第二次点击转账100："+result);
            }
        });
        t2.start();

//Integer的高速缓存是-128--127（AtomicStampedReference）
        //如果大于127，那么就开始new对象了
        /*
        * 解决方法，调整边界值*/
    }


}
