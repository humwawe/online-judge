package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class CLongestRegularBracketSequence {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    String s = in.nextString();
    s = ")" + s;
    Stack<Integer> stack = new Stack<>();
    int res = 0;
    int cnt = 1;
    int[] dp = new int[s.length()];
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') {
        stack.push(i);
      } else {
        if (!stack.isEmpty()) {
          int tmp = i - stack.peek() + 1 + dp[stack.peek() - 1];
          if (tmp > res) {
            res = tmp;
            cnt = 1;
          } else if (tmp == res) {
            cnt++;
          }
          dp[i] = tmp;
          stack.pop();
        }
      }
    }
    out.println(res + " " + cnt);
  }
}
