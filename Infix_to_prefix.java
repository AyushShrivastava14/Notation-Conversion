import java.util.Stack;

public class Infix_to_prefix {

    public static String reverseString(String exp) {
        String result = "";

        for(int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if(c == '(') result += ')';
            
            else if(c == ')') result += '(';

            else result += c;
        }

        return result;
    }

    public static int prec(char op) {
        switch(op) {
            case '+':
            case '-': return 1;

            case '*':
            case '/': return 2;

            case '^': return 3;

        }
        return -1;
    }

    public static String infixToPostfix(String exp) {
        String result = "";
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if(Character.isLetterOrDigit(c)) result += c;

            else if(c == '(') stack.push(c);

            else if(c == ')') {
                while(!stack.isEmpty() && stack.peek() != '(') {
                    result += stack.pop();
                }

                stack.pop();
            }

            else {
                while(!stack.isEmpty() && prec(c) <= prec(stack.peek())) {
                    result += stack.pop();
                }

                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }
    
    public static void main(String[] args) {
        String infix = "(p+q)*(c-d)";
        infix = reverseString(infix);
        String postfix = infixToPostfix(infix);
        String prefix = reverseString(postfix);

        System.out.println("Postfix:-");
        System.out.println(postfix);
        System.out.println();

        System.out.println("Prefix:-");
        System.out.println(prefix);
    }
}
