import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Testdeom {

    public static void main(String[] args) {
       String[] arr ={"75-64*"};
       Testdeom testdeom = new Testdeom();
        System.out.println(testdeom.evalRPN(arr));
    }
    public int evalRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for(String t : tokens){

            switch(t){

                case "+":

                    stack.push(stack.pop()+stack.pop());

                    break;

                case "-":

                    int num = stack.pop();

                    stack.push(stack.pop()-num);

                    break;

                case "*":

                    stack.push(stack.pop()*stack.pop());

                    break;

                case"/":

                    int num2 = stack.pop();

                    stack.push(stack.pop()/num2);

                    break;

                default:

                    stack.push(Integer.valueOf(t));
            }

        }

        return stack.pop();

    }
}
