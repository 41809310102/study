import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            char[] res = str.toCharArray();
            int len = res.length;
            int k =0;
            int count = 0;
           while (k<len){
               if(res[k]=='_'){
                    res[k+1]=(char) (res[k+1]-32);
                    count++;
               }
               k++;
           }
            String s = "";
            String res1 = new String(res);

           for(int i = 0;i<res1.length();i++){
               if(res1.charAt(i)!='_'){
                   s = s+res1.charAt(i);
               }
           }

            System.out.println(s);
        }
    }
}
