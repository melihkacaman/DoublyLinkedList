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

        System.out.println("Example : " + reverseString("Example"));
    }

    static boolean isPalindrome(String text){
        Stack<Character> stack = new Stack<>();
        for (int i =0; i<text.length(); i++){
            stack.push(text.charAt(i));
        }

        for (int i =0; i< text.length(); i++) {
            if (stack.pop().data != text.charAt(i)){
                return false;
            }
        }

        return true;
    }

    static String reverseString(String text){
        Stack<Character> stack = new Stack<>();
        String result = "";

        for (int i=0; i<text.length(); i++){
            stack.push(text.charAt(i));
        }
        for (int i=0; i<text.length(); i++){
            result+= stack.pop().data.toString();
        }

        return result;
    }

    // kel  lek
    static String reverseRecursive(String text){
        if (text == null)
            return "";
        else {
            char c = text.charAt(0);
            return reverseRecursive(text.substring(1)) + c;
        }
    }
}
