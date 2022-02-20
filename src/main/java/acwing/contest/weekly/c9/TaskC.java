package acwing.contest.weekly.c9;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Stack;

public class TaskC {
  int n;
  int N = 500005;
  int inf = 0x3f3f3f3f;
  long[] m = new long[N];
  long[] l = new long[N];
  long[] r = new long[N];
  long[] a = new long[N];

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    for (int i = 1; i <= n; i++) {
      m[i] = in.nextLong();
    }
    Stack<Integer> stack = new Stack<>();
    stack.add(0);
    m[0] = -inf;
    for (int i = 1; i <= n; i++) {
      while (m[stack.peek()] >= m[i]) {
        stack.pop();
      }
      l[i] = l[stack.peek()] + (i - stack.peek()) * m[i];
      stack.push(i);
    }
    stack.clear();
    stack.push(n + 1);
    m[n + 1] = -inf;
    for (int i = n; i > 0; i--) {
      while (m[stack.peek()] >= m[i]) {
        stack.pop();
      }
      r[i] = r[stack.peek()] + (stack.peek() - i) * m[i];
      stack.push(i);
    }

    long res = 0;
    int k = 0;
    for (int i = 1; i <= n; i++) {
      long cur = l[i - 1] + r[i];
      if (cur > res) {
        res = cur;
        k = i;
      }
    }
    a[k] = m[k];
    for (int i = k - 1; i > 0; i--) {
      a[i] = Math.min(a[i + 1], m[i]);
    }
    for (int i = k + 1; i <= n; i++) {
      a[i] = Math.min(a[i - 1], m[i]);
    }
    for (int i = 1; i <= n; i++) {
      out.print(a[i] + " ");
    }

  }


}
