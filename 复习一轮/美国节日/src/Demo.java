import java.time.DayOfWeek;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int year = sc.nextInt();
            //判断当前year是不是闰年
         amaircanFiver(year);
        }

    }
    //判断当前year是不是闰年
   private static  Boolean  isYear(int year){
       if(year>=2000&&year<=9999){
           if(year%4==0||year%100==0||year%400==0){
               return true;
           }else {
               return false;
           }
       }
       return false;
   }


   //判断日期
    public static  void  amaircanFiver(int year){

     String data = "-01-01-01-20-02-17-05-26-07-04-09-01-11-27-12-25";
     String data1 = "-01-01-01-21-02-18-05-27-07-04-09-02-11-28-12-25";
     int start=0;
        if(isYear(year)){
           for(int i =0 ;i<8;i++){
               int last = start+6;
               System.out.println(year+data.substring(start,last));
               System.out.println();
               start = last;
           }
           }else {
            for(int i =0 ;i<8;i++){
                int last = start+6;
                System.out.println(year+data1.substring(start,last));
                System.out.println();
                start = last;
            }
        }
        }
    }



