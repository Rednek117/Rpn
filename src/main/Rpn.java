package main;


import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class Rpn extends ReversePolishNotation {
    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter number of expression: ");
        int number = in.nextInt();
        for (int i = 0; i < number; i++)
            if(i <= 100) {
                System.out.println("Enter your expression: ");
                String input = in.next();
                check(input);
            }
    }
}
