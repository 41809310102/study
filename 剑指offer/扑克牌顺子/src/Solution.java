import java.util.*;
public class Solution {
    public boolean IsContinuous(int [] numbers) {
        if(numbers.length==0) return false;
        Arrays.sort(numbers);
        int help=0;
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==0) help++;
            else if(i>0&&numbers[i-1]!=0&&numbers[i]==numbers[i-1]) return false;
            else if(i>0&&numbers[i-1]!=0&&numbers[i]!=numbers[i-1]+1) help-=numbers[i]-numbers[i-1]-1;
        }
        return help>=0;
    }
}