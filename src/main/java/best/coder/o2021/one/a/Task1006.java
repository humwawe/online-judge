package best.coder.o2021.one.a;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class Task1006 {
  int N = (int) (5e6 + 5);
  int[] t = new int[N];
  boolean[] vis = new boolean[N];

  int n;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    n = in.nextInt();
    for (int i = 0; i < n; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a == 1) {
        if (!vis[b]) {
          add(b, 1);
          vis[b] = true;
        }
      } else {
        if (!vis[b]) {
          add(b, 1);
          out.println(search());
          add(b, -1);
        } else {
          out.println(search());
        }
      }
    }

  }

  private int search() {
    int l = 0;
    int r = n;
    while (l < r) {
      int mid = l + r + 1 >> 1;
      if (sum(mid) == mid) {
        l = mid;
      } else {
        r = mid - 1;
      }
    }
    return l + 1;
  }

  int lowbit(int x) {
    return x & -x;
  }

  void add(int x, int c) {
    for (int i = x; i <= n; i += lowbit(i)) {
      t[i] += c;
    }
  }

  int sum(int x) {
    int res = 0;
    for (int i = x; i > 0; i -= lowbit(i)) {
      res += t[i];
    }
    return res;
  }
}
