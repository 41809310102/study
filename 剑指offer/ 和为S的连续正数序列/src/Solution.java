import  java.util.*;

public class Solution {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
          while (sc.hasNext()){
              int n = sc.nextInt();
              for(int i = 0;i<FindContinuousSequence(n).size();i++){
                  System.out.println(FindContinuousSequence(n).get(i));
              }

          }
    }

    public static ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        if(sum==1||sum==0||sum==2) return list;
        int p1 = 1; //左指针
        int num = 0;
        for(int i = 1;i+p1<=sum;i++){
            num = num+i;
            while (num>sum){
                num=num-p1;
                p1++;
            }
            if(num==sum) {
                ArrayList<Integer> list1 = new ArrayList<>();
                for (int j = p1; j <= i; j++) {
                    list1.add(j);
                }
                list.add(list1);
            }
        }
        return list;
    }
}
