public class Interruppt {
    public static void main(String[] args) throws InterruptedException {
        Thread ti = new Thread(new Runnable() {
            @Override
            public void run() {
              while (!Thread.interrupted()){//判断线程的终止状态的
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                      break;
                  }
                  System.out.println("我在转账中");
              }
                System.out.println("终止");
            }
        });
        ti.start();
        Thread.sleep(301);
        System.out.println("有内鬼");
        ti.interrupt();
    }
}
