package main;


public class Rpn extends ReversePolishNotation {
    public static void main(String[] args) {
        check("(a+(b*c))\n" +               // enter the expression
                "((a+b)*(z+x))\n" +
                "((a+t)*((b+(a+c))^(c+d)))");

    }
}
