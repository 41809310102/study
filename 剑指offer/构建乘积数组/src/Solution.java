import java.util.Arrays;

public class Solution {




    public int[] multiply(int[] A) {
        if(A==null||A.length==0) return A;
        int[] B = new int[A.length];
        Arrays.fill(B,1);
        for(int i = 0 ;i<A.length;i++){
            for(int j = 0;j<A.length;j++){
                if(i==j){
                    continue;
                }
                B[i]*=A[j];
            }
        }
        return B;
    }
}
