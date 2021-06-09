import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String s = sc.nextLine();
            char[] res = s.toCharArray();
            String s2 = new String(mySub(res));
            res = s2.toCharArray();
            int prev =0; int last =0;
            while (prev<s2.length()&&last<=prev){
                if(res[prev]>122||res[prev]<65){
                    mySub1(res,last,prev-1);
                    last = prev+1;
                }
                prev++;
            }

            String s3 = new String(res);
            String s4 = "";
            for(int k =0 ;k<s3.length();k++){
                if(s3.charAt(k)<65||s3.charAt(k)>122){
                    s4=s4+' ';
                }
                s4=s4+s3.charAt(k);
            }
            System.out.println(s4);
        }
    }

    public  static  char[] mySub(char[] arr){
        if(arr==null||arr.length==0) return null;
        int p1 = 0;
        int p2 = arr.length-1;
        int mid = (p1+p2)/2+1;
        for(int i = 0;i<mid;i++){
            char npm = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = npm;
            p1++;
            p2--;
        }
        return arr;
    }

    public  static  void mySub1(char[] arr,int i ,int j){
        if(arr==null||arr.length==0) return;
        int mid = (j-i)/2+1;
        for(int n = 0;n<mid;n++){
            char npm = arr[i];
            arr[i] = arr[j];
            arr[j] = npm;
            i++;
            j--;
        }
    }
}
/*
* 链接：https://www.nowcoder.com/questionTerminal/81544a4989df4109b33c2d65037c5836
来源：牛客网

import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        if("".equals(text.trim())){
        System.out.println("");
        }else{
              String[] sp = text.split("[^a-zA-Z]+");
        StringBuilder sb = new StringBuilder();
        for (int i = sp.length - 1; i >= 0; i--)
            sb.append(sp[i] + " ");
        System.out.println(sb.toString().trim());
        sc.close();
        }

    }

}*/