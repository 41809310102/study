import java.util.Arrays;

public class Deom {
    public static void main(String[] args) {
        int[] res = {4,1,-2,1,-3,-2,5,-4,0};
        mySub(res);
    }

    public  static  void  mySub(int[] res){
        if(res==null||res.length==0){
            return ;
        }

        int p1 =0;
        int p2 =p1+1;
        for(int i = 0;i<res.length;i++){
            if(p2<=res.length-1&&res[p1]+res[p2]+res[i]==0) {
                int[] arr={res[p1],res[p2],res[i]};
                System.out.println(Arrays.toString(arr));
                i=p2+1;
            }
            p1++;
            p2++;
        }
        return ;
    }
}
