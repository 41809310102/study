public class Demo {
    public static void main(String[] args) {
        int n = 5;
        try {
            n = n/5;
            System.exit(-1);
        }catch (AbstractMethodError e){

        }finally {
            System.out.println("运行了finall！");
        }

    }


}
