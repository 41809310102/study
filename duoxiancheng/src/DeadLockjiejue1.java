public class DeadLockjiejue1 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Object lock1 = new Object();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程一，进入线程方法");
                synchronized (lock) {
                    try {
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("执行完成");
            }
        },"t1");
        thread.start();
        Thread.sleep(1000);
        System.out.println("自主线程唤醒线程1");
        synchronized (lock){
           lock.notifyAll();
        }
    }
}
