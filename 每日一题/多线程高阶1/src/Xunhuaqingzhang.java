import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Xunhuaqingzhang {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier =new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("执行CYc");
            }
        });

        for(int i =0;i<11;i++){
            final  int n = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(n*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    try {
                        System.out.println(Thread.currentThread().getName()+"开始起跑");
                        cyclicBarrier.await();
                        System.out.println(Thread.currentThread().getName()+"等代起跑");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"执行结束");
                }
            }).start();
        }
    }
}
