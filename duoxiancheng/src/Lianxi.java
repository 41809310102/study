public class Lianxi {
    public static void main(String[] args) throws InterruptedException {
      char[] arr = {'A','B','C','D'};

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int i = 0;i<arr.length;i++){
                        System.out.print(arr[i]);

                    }

                }

            });
            thread.start();
        thread.sleep(200);




        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0;i<arr.length;i++){
                    System.out.print(arr[i]);
                }

            }

        });
        thread1.start();
        thread1.sleep(1000);


    }
}
