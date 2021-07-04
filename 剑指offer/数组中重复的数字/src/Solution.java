public class Solution {

    public static void main(String[] args) {
        int[] arr = {1,2,3,7,8,2,3,5};
        System.out.println(duplicate(arr));
    }

    public static  int duplicate (int[] numbers) {
        if(numbers==null||numbers.length==0) return -1;
        for(int i = 0;i<numbers.length;i++){
            if(i!=numbers[i]) {
                if (numbers[i] == numbers[numbers[i]]) return numbers[i];
                int temp = numbers[numbers[i]];
                numbers[numbers[i]] = numbers[i];
                numbers[i] = temp;
                i--;
            }
        }
        return -1;
    }
}
