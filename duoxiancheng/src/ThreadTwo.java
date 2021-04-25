public class ThreadTwo {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println("线程名"+currentThread().getName());
            }
        };

    }
}
