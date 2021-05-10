import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] res = str.toCharArray();
            if(res==null||res.length==0) return;
            char[] res1 = new char[res.length];
            for(int i =str.length()-1;i>=0;i--){
              res1[str.length()-i-1] = res[i];
            }
            String  s = new String(res1);
            System.out.println(s);
        }
    }
}
