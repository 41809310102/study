import java.util.concurrent.CountDownLatch;

public class CountDownLatchDeom {
    //计算器
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        for(int i =0;i<5;i++){
            final  int finall = i;
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"开始起跑");
                    try {
                        Thread.sleep(finall*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"到达终点");
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println("比赛结束");
    }
}
