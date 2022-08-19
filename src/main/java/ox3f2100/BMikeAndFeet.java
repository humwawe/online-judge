package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class BMikeAndFeet {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }

    int[] left = new int[n];
    int[] right = new int[n];

    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        left[i] = -1;
      } else {
        left[i] = stack.peek();
      }
      stack.push(i);
    }
    stack.clear();
    for (int i = n - 1; i >= 0; i--) {
      while (!stack.isEmpty() && a[i] <= a[stack.peek()]) {
        stack.pop();
      }
      if (stack.isEmpty()) {
        right[i] = n;
      } else {
        right[i] = stack.peek();
      }
      stack.push(i);
    }
    int[] map = new int[n + 1];
    for (int i = 0; i < n; i++) {
      map[right[i] - left[i] - 1] = Math.max(map[right[i] - left[i] - 1], a[i]);
    }
    for (int i = n - 1; i > 0; i--) {
      map[i] = Math.max(map[i], map[i + 1]);
    }
    for (int i = 1; i <= n; i++) {
      out.print(map[i], "");
    }

  }
}
