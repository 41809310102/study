import java.util.*;
import java.io.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str ="";
        Map<Character,Character> convert = new HashMap<>();
        convert.put('0','0');
        convert.put('1','8');
        convert.put('2','4');
        convert.put('3','C');
        convert.put('4','2');
        convert.put('5','A');
        convert.put('6','6');
        convert.put('7','E');
        convert.put('8','1');
        convert.put('9','9');
        convert.put('A','5');
        convert.put('B','D');
        convert.put('C','3');
        convert.put('D','B');
        convert.put('E','7');
        convert.put('F','F');

        while((str = br.readLine())!=null){

            String[] strings = str.split("\\s");
            char[] chars = (strings[0]+strings[1]).toCharArray();
            char[] odd = new char[(chars.length+1)/2];
            char[] even = new char[chars.length/2];
            int oddIndex = 0;
            int evenIndex = 0;
            for(int i = 0;i<chars.length;i++){
                if(i%2==0){
                    odd[oddIndex++] = chars[i];
                }else{
                    even[evenIndex++] = chars[i];
                }
            }
            Arrays.sort(odd);
            Arrays.sort(even);
            oddIndex = 0;
            evenIndex = 0;
            for(int i = 0;i<chars.length;i++){
                if(i%2==0){
                    chars[i] = odd[oddIndex++];

                }else{
                    chars[i] = even[evenIndex++];
                }
                char ch = chars[i];
                if(Character.isLowerCase(ch)){
                    ch = Character.toUpperCase(ch);
                }
                if(convert.containsKey(ch)){
                    chars[i] = convert.get(ch);
                }
            }

            System.out.println(new String(chars));
        }
    }
}