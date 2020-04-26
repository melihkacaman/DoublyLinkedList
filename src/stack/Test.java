package stack;

public class Test {
    public static void main(String[] args) {
        Stack<Integer> intStack = new Stack<Integer>();

        intStack.pop();

        intStack.print();
        System.out.println("size : " + intStack.size());

        intStack.push(5);
        intStack.push(7);
        System.out.println("peek : " + intStack.peek());
        intStack.push(3);

        intStack.print();
        System.out.println("size : " + intStack.size());
    }
}
