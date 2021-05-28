public class Chonglock {
    private  static   Object lock = new Object();

    public static void main(String[] args) {
        //第一次进入锁
        synchronized (lock){
            System.out.println("第一次进入锁");
            synchronized (lock){
                System.out.println("第二次进入锁");
            }
        }
    }
}
