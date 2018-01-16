package main;

import java.util.Stack;

public class ReversePolishNotation {

    public static void  check(String input){                                        // checking text grouped in [ ] does not appear in the input line.
        String s = input.replaceAll("(\\]|\\[).*(\\]|\\[)", " ");
        if(s != null && s.length() <= 400)
        execute(s);
        else System.out.println("Enter algebraic expression is empty or too long");

    }
    public static void execute(String s){                                           // RPN transformation

        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < c.length; i++)
            switch (c[i]){
                case '+':
                case '-':
                    while(!stack.empty() && (stack.peek().equals('*') || stack.peek().equals( '/'))){
                        sb.append(' ').append(stack.pop());
                    }
                case '^':
                case '*':
                case '/':
                    sb.append(' ');
                case '(':
                    stack.push(c[i]);
                case ' ':
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() !='('){
                        sb.append(' ').append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                    break;
                default:
                    sb.append(c[i]);
                    break;
            }
            while (!stack.empty()) sb.append(' ').append(stack.pop());
            System.out.println(sb.toString());
    }
}
