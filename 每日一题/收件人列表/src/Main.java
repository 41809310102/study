import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

     Scanner sc = new Scanner(System.in);
     while (sc.hasNext()){
         int n = sc.nextInt();
         ArrayList<String> arrayList = new ArrayList<>();
         sc.nextLine();
         for(int i=0;i<n;i++){
             String name = sc.nextLine();
             if(name.contains(" ")||name.contains(",")){
                 arrayList.add("\""+name+"\"");
             }else {
                 arrayList.add(name);
             }
         }
         for (int i = 0;i<n-1;i++){
             System.out.print(arrayList.get(i)+",");
         }
         System.out.println(arrayList.get(n-1));
     }

    }
}
