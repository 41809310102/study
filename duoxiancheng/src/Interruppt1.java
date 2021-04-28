public class Interruppt1 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
              while (!Thread.interrupted()){
                  System.out.println("正在交易中");
              }
                System.out.println("好的，关闭");
            }
        });
        t1.start();
        Thread.sleep(100);
        System.out.println("有内鬼");
        t1.interrupt();
    }

}
