package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

import java.util.Arrays;

public class B1PaintingTheArrayI {
  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int[] a = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      a[i] = in.nextInt();
    }
    int[] last = new int[n + 1];
    int[] nxt = new int[n + 1];
    Arrays.fill(last, n + 1);
    for (int i = n; i >= 0; --i) {
      nxt[i] = last[a[i]];
      last[a[i]] = i;
    }
    int x = 0;
    int y = 0;
    int res = 0;
    for (int z = 1; z <= n; z++) {
      if (a[x] == a[z]) {
        res += a[y] != a[z] ? 1 : 0;
        y = z;
      } else if (a[y] == a[z]) {
        res += a[x] != a[z] ? 1 : 0;
        x = z;
      } else if (nxt[x] < nxt[y]) {
        res += a[x] != a[z] ? 1 : 0;
        x = z;
      } else {
        res += a[y] != a[z] ? 1 : 0;
        y = z;
      }

    }
    out.println(res);
  }
}
