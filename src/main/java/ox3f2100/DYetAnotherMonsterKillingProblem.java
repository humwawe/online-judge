package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class DYetAnotherMonsterKillingProblem {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++) {
      a[i] = in.nextInt();
    }
    int m = in.nextInt();
    Node[] b = new Node[m];
    for (int i = 0; i < m; i++) {
      b[i] = new Node(in.nextInt(), in.nextInt());
    }
    Arrays.sort(b, (x, y) -> {
      int d = x.p - y.p;
      if (d == 0) {
        return x.s - y.s;
      }
      return d;
    });

    for (int i = m - 2; i >= 0; i--) {
      b[i].s = Math.max(b[i].s, b[i + 1].s);
    }
    int last = -1;
    int res = 1;
    int min = (int) (1e9 + 6);
    for (int i = 0; i < n; i++) {
      int x = helper(a[i], b);
      if (x == m) {
        out.println(-1);
        return;
      }
      min = Math.min(min, b[x].s);

      if (last + min < i) {
        last = i - 1;
        min = b[x].s;
        res++;
      }
    }
    out.println(res);

  }

  int helper(int v, Node[] b) {
    int l = 0;
    int r = b.length;
    while (l < r) {
      int mid = l + r >> 1;
      if (b[mid].p >= v) {
        r = mid;
      } else {
        l = mid + 1;
      }
    }

    return l;
  }

  class Node {
    int p, s;

    public Node(int p, int s) {
      this.p = p;
      this.s = s;
    }
  }
}
