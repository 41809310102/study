import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(StrToInt(s));
        }
    }

    public static int StrToInt(String str) {
       if(str==null||str.length()==0) return 0;

       char[] arr = str.toCharArray();
       Boolean flag = false;
       if(arr[0]=='-'){
           flag = true;
       }else if(arr[0]=='+'){
           flag = false;
       }
      //校验是否1合法
        if(!isok(arr)){
            return 0;
        }

    int res=  change(arr);
        if(flag){
            return (0-res);
        }

    return res;
    }



    public  static boolean isok(char[] res){
        for(int i = 1;i<res.length;i++){
            if(!(res[i]>='0'&&res[i]<='9')){
                return false;
            }
        }
        return true;
    }

    public  static  int change(char[] res){
        int i = 0;
        if(res[0]=='-'||res[0]=='+') {
            i = 1;
        }
          int cos=0;
        for(;i<res.length;i++){
          int cur = res[i]-48;
          int pre = res.length-i-1;
            System.out.println(cur+" "+pre);
            cos+=getNumber(cur,pre);
        }
        return cos;
    }


    public static  int getNumber(int res ,int n){
        int temp = 1;
        while (n>0){
          temp=10*temp;
          n--;
        }
        return temp*res;
    }
}