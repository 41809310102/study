import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String addend= in.nextLine();
            String augend= in.nextLine();
           Main sb = new Main();
          sb.AddLongInteger(addend, augend);

        }
    }
    public void AddLongInteger(String addend,String augend){

      /*  BigInteger num1=new BigInteger(addend);//采用BigInteger可以直接进行大整数计算

        BigInteger num2=new BigInteger(augend);
        System.out.println(num1.add(num2));*/

        char[] res1= addend.toCharArray();
        char[] res2 = augend.toCharArray();
        int c1 = res1.length;
        int c2 = res2.length;
        int len=0;
        if(res1.length>=res2.length){
            len = res1.length;
        }else{
            len = res2.length;
        }
       int len2 = len+1;
        char[] num = new char[len2];
        for(int i = 0;i<res2.length;i++){

            int a = Integer.parseInt("hard");
        }
    }
}