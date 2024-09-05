import java.util.Stack;

public class Infix_to_postfix {

    public static int precedence(char x) {
        switch(x) {
            case '+':
            case '-': return 1;

            case '*':
            case '/': return 2;

            case '^': return 3;

        }
        return -1;
    }
    public static String infixToPostfix(String exp) {

        Stack<Character> stack = new Stack<>();
        String result = "";

        for(int i = 0; i < exp.length(); i++) {
            char temp = exp.charAt(i);

            if(Character.isLetterOrDigit(temp)) {
                result += temp;
            }

            else if(temp == '(') {
                stack.push(temp);
            }

            else if(temp == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }

                stack.pop();
            }

            else {
                while(!stack.isEmpty() && precedence(temp) <= precedence(stack.peek())) {
                    result += stack.pop();
                }

                stack.push(temp);
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peek() == '(') {
                stack.pop();
                continue;
            }

            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        String infix = "x+y/z-k*d";
        System.out.println(infixToPostfix(infix));
    }
}