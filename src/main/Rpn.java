package main;

import java.util.Stack;

public class Rpn {
    public static void main(String[] args) {
        System.out.println(reversePolishNotation("(a+(b*c))\n" +
                "((a+b)*(z+x))\n" +
                "((a+t)*((b+(a+c))^(c+d)))"));
    }


    public static String reversePolishNotation(String input){
        if(input == null) return new String("");
        String s = input.replaceAll("(\\]|\\[).*(\\]|\\[)", " ");
        char[] letters = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < letters.length; i++)
            switch (letters[i]){
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
                    stack.push(letters[i]);
                case ' ':
                    break;
                case ')':
                    while (!stack.empty() && stack.peek() !='('){
                        sb.append(' ').append(stack.pop());
                    }
                    if(!stack.isEmpty()) stack.pop();
                    break;
                default:
                     sb.append(letters[i]);
                     break;
            }
            while (!stack.empty()) sb.append(' ').append(stack.pop());


        return sb.toString();
    }
}
