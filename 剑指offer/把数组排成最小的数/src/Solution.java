import java.util.*;

public class Solution {
    public String PrintMinNumber(int [] numbers) {

        if(numbers == null || numbers.length == 0) return "";

        String [] str = new String [numbers.length];
        for(int i=0; i<numbers.length; i++){
            str[i] = String.valueOf(numbers[i]);
        }

        String s = "";
        String s1 = "";
        //类似于冒泡排序，小的上浮，大的下沉；
        for(int i=0; i<str.length; i++){

            for(int j=i+1; j<str.length; j++){
                if(Integer.parseInt(str[i] + str[j]) >= Integer.parseInt(str[j]+str[i])){
                    s = str[i];
                    str[i] = str[j];
                    str[j] = s;
                }
            }

        }

        for(int i=0; i<str.length; i++){
            s1 = s1 + str[i];
        }
        return s1;
    }
}