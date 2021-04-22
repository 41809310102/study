import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] res = Getnumber(n);
            String b="";
          for(int i =0;i<res.length;i++){
              if(res[i]!=-1){
                  String a = String.valueOf(res[i]);
                   b = b+a;
              }
          }
            System.out.println(b);
            }
        }


    public  static  int[] Getnumber(int n){
        int res ;
        int i =0;
        int[] arr = new int[32];
        for(int j = 0;j<arr.length;j++){
            arr[j] = -1;
        }
        while (n/10!=0){
            res = n%10;
            arr[i] = res;
            i++;
            n = n/10;
       }
        i++;
        arr[i]=n;
        return arr;
    }
}
