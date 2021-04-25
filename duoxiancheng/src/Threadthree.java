public class Threadthree {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程名"+Thread.currentThread().getName());
            }
        });
       thread.start();

    }


}
