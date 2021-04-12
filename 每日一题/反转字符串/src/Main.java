import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = "I like beijing.";
        char[] res = str.toCharArray();
        int left =0;
        int right = res.length-1;
        if(res==null||res.length==0){
            System.out.println("");
        }
        while (left<right){
          char a = res[left];
            res[left]=res[right];
            res[right]=a;
            left++;
            right--;
        }
         Main sb = new Main();
        sb.Fanzhang(res);
        sb.Daying(res);
    }
      public   char[]  Fanzhang( char[] res){
          int left=0;
        for(int i =0;i<res.length;i++){
            if(res[i]==' '){
                int right =i-1;
                while (left<right){
                    char a = res[left];
                    res[left]=res[right];
                    res[right]=a;
                    left++;
                    right--;
                }
                left=i+1;
            }
        }
        return  res;
    }


   void Daying(char[] res){
        for(int i = 0;i<res.length;i++){
            System.out.print(res[i]);
        }
    }
}
