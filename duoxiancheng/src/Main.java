public class Main {

private static class MyRunnable implements Runnable {
    @Override
       public void run() {
            try {
     Thread.sleep(1000);
                } catch (InterruptedException e) {
               System.out.println("通过异常收到了中断情况");
              }
              for (int i = 0; i < 10; i++) {
             System.out.println(Thread.currentThread().isInterrupted());
}
}
}
public static void main(String[] args) throws InterruptedException {
MyRunnable target = new MyRunnable();
Thread thread = new Thread(target, "李四");
thread.start();
thread.interrupt();
}
    }

