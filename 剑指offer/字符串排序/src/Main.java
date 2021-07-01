import  java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            String s = sc.nextLine();
            System.out.println(strSort(s).subList(0, 3));
        }
    }

    public static ArrayList strSort(String s){
        List<String> res = new ArrayList<>();
        if(s.length()==0||s==null) {
            return (ArrayList)res;
        }
        change1(s.toCharArray(),res,0);
        Collections.sort(res);
        return (ArrayList) res;
    }


    //交换字母
    public  static  void  change1(char[] ch,List<String> list,int i){
        if(i==ch.length-1){
            if(!list.contains(ch)){
                list.add(new String(ch));
            }
        }else{
           for(int j = i;j<ch.length;j++){
               change2(ch,i,j);
               change1(ch,list,i+1);
               change2(ch,i,j);
           }
        }
    }

    public  static  void change2(char[] str,int i,int j){
          char temp = str[i];
          str[i] =  str[j];
          str[j] = temp;
    }
}
