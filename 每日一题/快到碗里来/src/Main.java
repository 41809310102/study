import java.net.Socket;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Double a = sc.nextDouble();
            Double b = sc.nextDouble();
            float pi = 3.14f;
            comperLong(a,b,pi);

        }
    }
    public  static  void comperLong(Double cat,Double   wan,float pi){

        if(cat>0&&wan>0){
            wan = 2*pi*wan;
        }
        if(cat<=wan){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }

    }
}
