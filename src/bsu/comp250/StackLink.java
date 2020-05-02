package bsu.comp250;

public class StackLink {

    public class Node {//new number coming in
        int value;
        Node next;
    }

    private Node cap;//top of the stack

    StackLink(){
        cap = null;//constructor
    }
    public void push (int n){//pushes the new value into the stack, makes the cap a new node
        Node theNode = new Node();
        theNode.value = n;
        theNode.next = cap;
        cap = theNode;
    }

    public int pop() throws NullPointerException{
        if (cap == null) {
            throw new NullPointerException();//if there isn't anything in the cap
        }
        int value = cap.value;
        cap = cap.next;
        return value;//makes the next number the new cap
    }



    public int evaluate(String expression1)throws NullPointerException{
        var expression = expression1.replaceAll("\\s","");//gets rid of spaces in expression
        for (int i = 0; i < expression.length(); i++) {
            char symbol = expression.charAt(i);//looks at char at i
            if (Character.isDigit(symbol)) {//if it is a number, take its int value and push into the stack
                int z = Integer.parseInt(String.valueOf(symbol));
                push(z);
            }
            else {//if it is an operator
                int val1 = pop();//first operand
                int val2 = pop();//second operand

                switch (symbol) {//evaluate those 2 given the operation
                    case '+':
                        push(val2 + val1);
                        break;

                    case '-':
                        push(val2 - val1);
                        break;

                    case '/':
                        push(val2 / val1);
                        break;

                    case '*':
                        push(val2 * val1);
                        break;
                }
            }
        }
        return pop();//return the answer
    }
}

