package ox3f2100;

import fast.io.InputReader;
import fast.io.OutputWriter;

public class CPeacefulRooks {
  int[] p;

  public void solve(int testNumber, InputReader in, OutputWriter out) {
    int n = in.nextInt();
    int m = in.nextInt();
    p = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      p[i] = i;
    }

    int cnt = 0;
    for (int i = 0; i < m; i++) {
      int a = in.nextInt();
      int b = in.nextInt();
      if (a == b) {
        cnt++;
        continue;
      }
      if (find(a) == find(b)) {
        cnt--;
        continue;
      }

      p[find(a)] = find(b);
    }
    out.println(m - cnt);
  }

  int find(int x) {
    if (p[x] == x) {
      return x;
    }
    return p[x] = find(p[x]);
  }
}
