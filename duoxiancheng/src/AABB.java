import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
public class AABB {
    public static void main(String[] args) {
      Lock lock = new ReentrantLock();
      Runnable runnable = new Runnable() {
          @Override
          public void run() {
           for(char item:"AABB".toCharArray()){
               lock.lock();
               System.out.print(item);
           }
          }
      };

      Thread t1 = new Thread(runnable ,"t1");
      Thread t2 = new Thread(runnable ,"t2");
      t1.start();
      t2.start();
    }
}
