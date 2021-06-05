package Menu;

import java.util.Scanner;

public class Menumingwen {
     public int[] choseMingwen1(){
         String[] arr = {"宿命","调和","虚空"};
         int[] result = new int[2];
         System.out.println("+++++++++++");
         for(int i =0;i<arr.length-1;i++){
             System.out.print(i+1+"<"+arr[i]+">"+"   ");
         }
         System.out.println(3+"<"+arr[2]+">"+"   ");
         System.out.println("+++++++++++");
         System.out.println("输入你要选择的铭文");
         Scanner sc= new Scanner(System.in);
         int res = sc.nextInt();
         result[0]=res;
         System.out.println("输入你要选择的铭文数量");
         int num = sc.nextInt();
             result[1] = num;
             if (num > 10) {
                 System.out.println("当前准备该铭文已达上限");

                 return null;
             }
         return result;
     }
}
