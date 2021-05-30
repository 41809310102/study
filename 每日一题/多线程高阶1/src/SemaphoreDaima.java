import java.util.concurrent.*;

//限流
public class SemaphoreDaima {
    // 最多 5 个坑
    private static final Semaphore avialable = new Semaphore(5);

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Runnable r = new Runnable() {
            public void run() {
                try {
                    avialable.acquire();    //此方法阻塞
                    Thread.sleep(10 * 1000);
                    System.out.println(Thread.currentThread().getName());
                    avialable.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            pool.execute(r);
        }
        pool.shutdown();
    }
}

