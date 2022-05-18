package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class EMergeEqualElements {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    Stack<Integer> stack = new Stack<>();
    int n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int x = in.nextInt();
      while (!stack.isEmpty() && stack.peek() == x) {
        stack.pop();
        x++;
      }
      stack.push(x);
    }
    out.println(stack.size());
    for (Integer i : stack) {
      out.print(i, "");
    }
  }
}
