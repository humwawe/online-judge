package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Stack;

public class CMinimalString {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    int len = s.length();
    int[] last = new int[26];
    Arrays.fill(last, -1);
    int[] pos = new int[len];
    for (int i = len - 1; i >= 0; i--) {
      int c = s.charAt(i) - 'a';
      int max = i;
      for (int j = 0; j < c; j++) {
        max = Math.max(max, last[j]);
      }
      pos[i] = max;
      last[c] = Math.max(last[c], i);
    }
    Stack<Integer> stack = new Stack<>();
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < len; i++) {
      if (pos[i] == i) {
        res.append(s.charAt(i));
        while (!stack.isEmpty() && pos[stack.peek()] <= i) {
          res.append(s.charAt(stack.pop()));
        }
      } else {
        stack.push(i);
      }
    }
    while (!stack.isEmpty()) {
      res.append(s.charAt(stack.pop()));
    }
    out.println(res.toString());
  }
}


