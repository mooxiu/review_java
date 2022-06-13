package dataStructures;

import java.util.Stack;

public class stacks {
    public static void main(String[] args) {
        var stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        assert stack.isEmpty();
    }
}
