import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String arr = "They are students.";
        String arr2 = "aeiou";
        char[] res1 = arr.toCharArray();
        char[] res2 = arr2.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = res1.length - 1; i >= 0; i--) {
            stack.push(res1[i]);
        }
        for (int j = 0; j < stack.size(); j++) {
            for (int k = 0; k < res2.length; k++) {
                if (stack.peek() != res2[k]||stack.peek()==' ') {
                    System.out.print(stack.peek());
                    stack.pop();
                }
                if(stack.peek() == res2[k]){
                    stack.pop();
                }

            }
        }
    }
}



