public class Solution {
    public static void main(String[] args) {

    }

    public int Add(int num1,int num2) {
        int a = num1;
        int b = num2;
        while (b!=0){
            int temp = a^b;
            b = (a&b)<<1;
            a = temp;
        }
        return a;
    }

}
