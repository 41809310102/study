public class Deadlock {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("线程一得到了lock1");
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程一获取lock2");
                    synchronized (lock2){
                        System.out.println("线程一得到了lock2");
                    }
                }
            }
        });
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1){
                    System.out.println("线程二得到了lock1");
                    try{
                        //让线程2，获取锁1
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程二获取lock1");
                    //尝试获取lock1
                    synchronized (lock2){
                        System.out.println("线程二得到了lock2");
                    }
                }
            }
        });
        thread2.start();

    }
}
