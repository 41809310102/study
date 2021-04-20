// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int c=0;
        int res =0;
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            int b = in.nextInt();
            if(a<=b){
               c=a;
            }else {
                c=b;
            }


            for(int i = 1;i<=c;i++){
                if(a%i==0&&b%i==0){
                    res = i;
                }
            }
            System.out.println(a*b/res);
            }
        }
    }
