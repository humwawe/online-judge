package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;
import java.util.Stack;
import java.util.TreeSet;

public class DArrayRestoration {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    int[] a = new int[n];
    int[] l = new int[m + 1];
    int[] r = new int[m + 1];
    int inf = (int) 1e8;
    Arrays.fill(l, inf);
    Arrays.fill(r, -1);
    boolean f = false;
    TreeSet<Integer> treeSet = new TreeSet<>();
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
      if (a[i] == m) {
        f = true;
      }
      if (a[i] == 0) {
        treeSet.add(i);
      }
      l[a[i]] = Math.min(l[a[i]], i);
      r[a[i]] = Math.max(r[a[i]], i);
    }
    if (!f) {
      if (treeSet.isEmpty()) {
        out.println("NO");
        return;
      }
      Integer idx = treeSet.pollFirst();
      a[idx] = m;
      l[m] = r[m] = idx;
    }


    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        continue;
      }
      while (!stack.isEmpty() && a[stack.peek()] >= a[i]) {
        stack.pop();
      }
      if (!stack.isEmpty() && l[a[i]] < stack.peek()) {
        out.println("NO");
        return;
      }
      stack.push(i);
    }

    out.println("YES");

    for (int i = m; i >= 0; i--) {
      if (r[i] == -1) {
        continue;
      }
      Integer ceiling = treeSet.ceiling(l[i]);
      while (ceiling != null && ceiling < r[i]) {
        a[ceiling] = i;
        treeSet.remove(ceiling);
        ceiling = treeSet.ceiling(l[i]);
      }

    }
    for (int i = 0; i < n; i++) {
      if (a[i] == 0) {
        out.print(1, "");
      } else {
        out.print(a[i], "");
      }
    }

  }
}
