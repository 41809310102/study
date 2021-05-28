import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            String name = sc.nextLine();
            char[] ch = s.toCharArray();
            List<String> list = new ArrayList<>();
            int flag = 0;
            String res = "";
            for (int i = 0; i < ch.length; i ++ ) {
                if(flag == 0 && ch[i] == '"') {
                    flag = 1;
                    list.add(res);
                    res = "";
                } else if(flag == 1 && ch[i] == '"') {
                    flag = 0;
                    list.add(res);
                    res = "";
                } else if(flag == 1) {
                    res += ch[i];
                } else if(flag == 0 && ch[i] != ',') {
                    res += ch[i];
                }
            }
            list.add(res);
            boolean isFinded = false;
            for (String string:list) {
                if(name.equals(string)) {
                    isFinded = true;
                    break;
                }
            }
            if(isFinded) System.out.println("Ignore");
            else System.out.println("Important!");
        }
    }
}