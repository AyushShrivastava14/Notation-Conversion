import java.util.Stack;

public class Postfix_to_infix {
    public static String postToInfix(String postfix) {
        // Write your code here.
        Stack<String> stack = new Stack<>();

        for(int i = 0; i < postfix.length(); i++) {
            String result = "";
            String c = postfix.substring(i, i + 1); 
            char ch = postfix.charAt(i);

            if(Character.isLetterOrDigit(ch)) {
                stack.push(c);
            }

            else {
                String temp = stack.pop();

                result += "(" + stack.pop() + c + temp + ")";
                stack.push(result);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        String postfix = "ab+c+";
        System.out.println(postToInfix(postfix));
    }
}
