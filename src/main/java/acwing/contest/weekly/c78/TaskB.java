package acwing.contest.weekly.c78;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class TaskB {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    Stack<Character> stack = new Stack<>();
    for (int i = 0; i < s.length(); i++) {
      if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
        stack.pop();
        continue;
      }
      stack.push(s.charAt(i));
    }

    for (Character character : stack) {
      out.print(character);
    }
    out.println();
  }
}
