public class Shopxiancheng {
    //线程中断
    //全局自定义变量
    private  static  boolean flag = false;
    public static void main(String[] args) {
        //全局自定义变量
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!flag){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    System.out.println("别烦我，再转账");
                }
                System.out.println("停止了");
            }
        });
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(340);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("终止");
            }
        });
        t2.start();
    }
}
