import java.util.concurrent.locks.LockSupport;

public class ThreadSleep0rwait {
    public static void main(String[] args) throws InterruptedException {
      Object lock = new Object();
      Thread t1 = new Thread(new Runnable() {
          @Override
          public void run() {
              LockSupport.park();
                  System.out.println("线程1，拥有了lock");

              System.out.println("执行成功");
          }

      });
      t1.start();
      Thread.sleep(1000);
        System.out.println("唤醒线程");
        LockSupport.unpark(t1);
    }
}
