import java.util.concurrent.locks.LockSupport;

public class Intrrput {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Interrput的状态"+Thread.interrupted());
                LockSupport.park();
                System.out.println("休眠之前的状态："+Thread.interrupted());
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println("休眠之后的状态："+Thread.interrupted());
        System.out.println("唤起");
        LockSupport.unpark(t1);
    }
}
