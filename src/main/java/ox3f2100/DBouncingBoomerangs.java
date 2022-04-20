package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DBouncingBoomerangs {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    Stack<int[]> stack1 = new Stack<>();
    Stack<int[]> stack2 = new Stack<>();
    Stack<int[]> stack3 = new Stack<>();

    List<int[]> res = new ArrayList<>();
    int cur = n;
    for (int i = n; i >= 1; i--) {
      if (a[i] == 1) {
        res.add(new int[]{cur, i});
        stack1.push(new int[]{cur, i});
        cur--;
      } else if (a[i] == 2) {
        if (stack1.isEmpty()) {
          out.println(-1);
          return;
        }
        int[] pop = stack1.pop();
        res.add(new int[]{pop[0], i});
        stack2.push(new int[]{pop[0], i});
        cur--;
      } else if (a[i] == 3) {
        if (stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty()) {
          out.println(-1);
          return;
        }
        int[] pop;
        if (!stack3.isEmpty()) {
          pop = stack3.pop();
        } else if (!stack2.isEmpty()) {
          pop = stack2.pop();
        } else {
          pop = stack1.pop();
        }
        res.add(new int[]{cur, i});
        res.add(new int[]{cur, pop[1]});
        stack3.push(new int[]{cur, i});
        cur--;
      }
    }
    out.println(res.size());
    for (int[] r : res) {
      out.println(r[0], r[1]);
    }
  }
}
