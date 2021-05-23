
import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            char[] arr = s.toCharArray();
            StringBuffer sb = new StringBuffer();
            for(int i =0;i<s.length();i++){
                char c=arr[i];
                if(c>='A'&&c<'F'){
                    sb.append((char)(c+21));
                }
                else  if(c>'E'&&c<='Z'){
                    sb.append((char)(c-5));
                }
                else {
                    sb.append(c);
                }

            }
            System.out.println(sb.toString());
        }
    }
}
