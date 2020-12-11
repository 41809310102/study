/*public class JAVA02 {
    public static void main(String[] args) {
      int[] arr1={1,2,3,4,5,6};
      printArray(arr1);
    }
    public static void printArray(int[] arr){

        int len=arr.length;
        int i;
        for(i=0;i<len;i++){
            System.out.print(" "+arr[i]);
        }
    }*/
   /* public class JAVA02 {
    public static void main(String[] args) {
        int[] arr={1,2,8,4,6,3,9,5,7};
        System.out.println("数组的平均值是"+sum(arr));
    }
    public static double sum(int[] arr){
        double len=arr.length;
        double sum=0;
        for(int i=0;i<=len-1;i++){
            sum+=arr[i];
        }
        return sum;
    }
}*/
/*public class JAVA02 {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        transform(arr1);
        print(arr1);
    }

    public  static  void print(int[] arr){
        int len=arr.length;
        for (int i=0;i<len;i++){
            System.out.print(arr[i]);
        }

    }

    public static void transform(int[] arr){
        int len=arr.length;
        int sum=0;
        int i;
        for(i=0;i<len;i++){
            arr[i]=arr[i]*2;
        }
    }
}*/
import java.util.Scanner;
public class JAVA02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("给宝宝说爱你");
        int a = scan.nextInt();
        if(a==1){
            love1();
            love2();
            love3();
            love4();
        }
    }
    public static void love1(){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    System.out.print("*");
                }else if(i==4){
                    System.out.print("* ");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("+++++++++++++");
    }
    public static void love2(){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0||j==4){
                    System.out.print("* ");
                }else if((i==4||i==0)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();;
        }
        System.out.println("+++++++++++++");
    }

    public static void love3(){
        int n = 8;
        for(int i = 0;i < n/2;i++) {
            for(int j = 0;j < n;j++) {
                if(i == j) {
                    System.out.print("*");
                }else if(j == n-1-i) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("+++++++++++++");
    }


    public static void love4(){
        int n=5;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    System.out.print("* ");
                }else if((i==4||i==0)){
                    System.out.print("* ");
                }
                else if((i==2)){
                    System.out.print("* ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();;
        }
        System.out.println("+++++++++++++");
    }

}