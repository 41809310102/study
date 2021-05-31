public class Deom {
    public static void main(String[] args) {

        int a1 =  sum(1,2,3,4,5,6);
        int a2 =  sum(10,20,30,40,50);
        int a3 =  sum(-1,-2,-3);
        System.out.println("第一个结果是"+a1);
        System.out.println("第二个结果是"+a2);
        System.out.println("第三个结果是"+a3);

    }


    public static  int sum(int... numbers) {
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }
}
