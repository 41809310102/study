public class Join {
    public static void main(String[] args) {
   Runnable runnable = new Runnable() {
       @Override
       public void run() {
           System.out.println(Thread.currentThread().getName()+"上班");

       }
   };
    }
}
