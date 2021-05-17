import java.util.Scanner;

public class Main {
   /* public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n =sc.nextInt();
            int res = Foundgen(n);
            System.out.println(res);
        }

    }

    private static int Foundgen(int n) {
        int sum=0;
        while (n>0){
            sum +=n%10;
            n=n/10;
        }
        if(sum<10){
            return sum;
        }
        if(sum>10)
            sum=Foundgen(sum);
        return sum;
    }*/

        public static void main(String[] args){
            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                String str=scanner.next();
                while(str.length()>1){
                    int result=0;
                    for(int i=0;i<str.length();i++)
                        result+=str.charAt(i)-'0';
                    str=String.valueOf(result);
                }
                System.out.println(str);
            }
        }


}
