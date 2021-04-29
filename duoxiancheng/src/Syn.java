public class Syn {

    private  static  int numder =0;
    private  static  final  int max = 10000;
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            for(int i =0 ;i<max;i++){
                synchronized (lock){
                    numder++;
                }
            }
        }
    });
    thread.start();
    thread.join();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0 ;i<max;i++){
                    numder--;
                }
            }
        });
        thread1.start();
        thread1.join();
        System.out.println(numder);

    }
}
