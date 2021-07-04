import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {

    }

    public int LastRemaining_Solution(int n, int m) {
        if(n==0) return -1;
        ArrayList<Integer> boy = new ArrayList<>();
        for(int i= 0;i<n;i++){
            boy.add(i);
        }

        int index = 0;
        while (boy.size()!=1){
            for(int i = 0;i<m-1;i++){
                index = (index+1)%boy.size();
            }
            boy.remove(index);
        }
        return   boy.get(0);
    }
}
