package day3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ']') {
                List<Character> str = new ArrayList<>();
                while (stack.peek() != '['){
                    str.add(stack.pop());
                }
                stack.pop(); // pop [
                int base = 1;
                int k = 0;

                while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                    k = k + (stack.pop() - '0') * base;
                    base *= 10;
                }

                while (k != 0) {
                    for(int j = str.size() - 1; j >= 0; j--) {
                        stack.push(str.get(j));
                    }
                    k--;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }

        char[] result = new char[stack.size()];
        for(int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }

    public static void main(String[] args) {
        new DecodeString().decodeString("3[a]2[bc]");
    }
}
