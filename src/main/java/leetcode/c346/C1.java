package leetcode.c346;

import java.util.Stack;

/**
 * @author hum
 */
public class C1 {
  public int minLength(String s) {
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (!stack.isEmpty() && stack.peek() == 'A' && c == 'B') {
        stack.pop();
        continue;
      }
      if (!stack.isEmpty() && stack.peek() == 'C' && c == 'D') {
        stack.pop();
        continue;
      }
      stack.push(c);
    }
    return stack.size();
  }
}
