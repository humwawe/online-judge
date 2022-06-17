package codeforces.c800;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class BParanoidString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    String s = in.nextString();
    Stack<Integer> stack = new Stack<>();
    long res = 0;
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && s.charAt(stack.peek()) != s.charAt(i)) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        res += i + 1;
      } else {
        res += i - stack.peek();
      }
      stack.push(i);
    }
    out.println(res);
  }
}
