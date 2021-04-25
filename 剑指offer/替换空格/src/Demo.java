import java.util.Arrays;
/*
* 替换空格
*1.先遍历一次字符串，统计空格格式，基本处于替换后的长度。
2.准备两个指针， P一指向字符串末尾。， P2指向替换后字符串末尾。
3.移动PE向前把P1指向的内容复制到P2之上的内容中，直到碰到第1个空格为止。
4.碰到一个空格后，把P1向前移动一格，在P2之前插入20% ， P2向前移动三个单位。
*/
public class Demo {
        public static void main(String[] args) {
       Demo sb = new Demo();
       sb.Find();

    }
    public   void Find(){
        String s="We are happy.";
        char[] res=s.toCharArray();
        //统计空格的个数；
        int count=0;
        for(int i=0;i<res.length;i++){
            if(res[i]==' '){
                count++;
            }
        }
        int len=res.length-1+2*count;
        char[] nums=new char[len+1];
        for(int i =0;i<res.length;i++){
            nums[i]=res[i];
        }
        int p1=res.length-1;
        int p2=len;
        while (p1<=p2&&p1>=0){
            if(nums[p1]!=' '){
                nums[p2]=nums[p1];
                p1--;
                p2--;
            }else if(nums[p1]==' '){
                p1--;
                nums[p2--]='0';
                nums[p2--]='2';
                nums[p2--]='%';
            }
        }
        System.out.println("替换前"+new String(res));
        System.out.println("替换后："+new String(nums));
    }


}
