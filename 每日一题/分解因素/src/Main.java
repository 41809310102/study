import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int num =n;
            if(isshunumber(n)){
                System.out.println(1);
                continue;
            }
            int count=0;
            Stack<Integer> stack = new Stack<>();
            for(int i =2;i<Math.sqrt(n);i++){
                if(n%i==0){
                    while (n%i==0){
                        n=n/i;
                    }
                    count++;
                    stack.push(i);
                }
            }
            if(n!=1){
                count++;
                stack.push(n);
            }
            String s = " = ";
            while (stack.size()>1){
                        s = s+ String.valueOf(stack.pop())+" * ";
            }
            s=s+stack.pop();
            System.out.println(num+s);
        }
    }

    public  static  boolean isshunumber(int n){
        for(int i = 2;i<=Math.pow(n,0.5);i++){
            if(n%i==0) return false;
        }
        return true;
    }
}
