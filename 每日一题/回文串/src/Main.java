import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        for(int i=0;i<=s1.length();i++){
            StringBuilder sb = new StringBuilder(s1);
            //StringBuider类中的方法：insert(offset,str)
            //在指定位置插入字符串
            sb.insert(i,s2);
            if(isHuiWen(sb.toString())){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isHuiWen(String s){
        int i = 0;
        int j = s.length()-1;
        while (i<j){
            //String类中的方法：charAt(index)-返回索引处的值
            if(s.charAt(i) != s.charAt(j)){  //索引值i,j对应的元素不相等
                return false;  //不是回文串
            }
            //否则i++,j++继续判断
            i++;
            j--;
        }
        return true;
    }
}
