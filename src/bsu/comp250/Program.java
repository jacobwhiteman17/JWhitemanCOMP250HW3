package bsu.comp250;

import java.util.Scanner;

public class Program {

    Program(){

    }

    private void printMenu(){//prints the menu
        System.out.println("    [1] Read");
        System.out.println("    [2] Evaluate");
        System.out.println("    [0] Exit");
    }

    public void runProgram(){//executes my program
        var input = new Scanner(System.in);//input
        StackLink myStack = new StackLink();//stack i will use
        String expression = "";
        while(true){
            printMenu();
            var response = input.nextInt();
            input.nextLine();
            switch(response){
                case 1:
                    System.out.println("Enter a postfix expression");
                    var myExpression = input.nextLine();//entering an expression to use
                    expression = myExpression;
                    System.out.println(expression);//the expression
                    break;
                case 2:
                    System.out.println(myStack.evaluate(expression));//evaluation of expression
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Not available");//default
            }
        }
    }


}

